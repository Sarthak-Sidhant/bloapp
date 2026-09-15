package in.gov.eci.bloapp.views.fragments.dse.requestformata;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloFormatABottomsheetBinding;
import in.gov.eci.bloapp.databinding.BloFormataPendingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentFormatABinding;
import in.gov.eci.bloapp.model.app_model.clusterDetailsDseModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.dse.DseMainFragment;
import in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormatAFragment extends BaseFragment {
    private static final String ALERT = "Alert";
    private static final String APPLICATION_JSON = "application/json";
    private static final String BLACK_COLOR = "#99000000";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String MESSAGE = "message";
    private static final String MESSAGE1 = "Message";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String STATE_CD = "stateCd";
    ActivityResultLauncher<Intent> activityResultLauncher1;
    private GenericRecyclerView adapter;
    private String address;
    private JSONArray addressDetails;
    private AlertDialog alertDialog1;
    private List<clusterDetailsDseModel> allhousesList;
    private String asmblyNO;
    private String atkband;
    BloFragmentFormatABinding binding;
    private Bitmap bitmap;
    private String blostatecode;
    Retrofit.Builder builder;
    private byte[] byteArray;
    private Dialog dialog;
    private String encodedImage;
    String filepathimg;
    BloFormatABottomsheetBinding formatABottomsheetBinding;
    private String formatBRemark;
    Uri imageUri;
    private String partNo;
    ArrayList<String> responseFormatAList;
    Retrofit retrofit;
    private String rtkband;
    private String selectedRemark;
    private String stateCode;
    private final CommomUtility commonUtilClass = new CommomUtility();
    private String photoref = " ";
    private String token = "";
    private JSONArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public FormatAFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.responseFormatAList = new ArrayList<>();
        this.blostatecode = "";
        this.addressDetails = null;
        this.activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass7());
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BloFragmentFormatABinding bloFragmentFormatABindingInflate = BloFragmentFormatABinding.inflate(getLayoutInflater());
        this.binding = bloFragmentFormatABindingInflate;
        bloFragmentFormatABindingInflate.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        initClickListener();
        this.allhousesList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        formatAPendingList();
        this.binding.searchDsePending.setVisibility(8);
        this.binding.searchDsePending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "7");
        SearchDseFragment searchDseFragment = new SearchDseFragment();
        searchDseFragment.setArguments(bundle);
        openFragment(searchDseFragment, "SearchDseFragment");
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$2(View view) {
        openFragment(new DseMainFragment(), "DseMainFragment");
    }

    public JSONArray formatAPendingList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put(STATE_CD, this.blostatecode);
        map.put("acNo", this.asmblyNO);
        map.put("partNo", this.partNo);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).formatAPending(this.token, "Close", "blo", APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                if (((EronetResponse) response.body()).getPayload() != null) {
                    FormatAFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (!FormatAFragment.this.payloadAllHouses.isEmpty()) {
                        Logger.d("json: ", String.valueOf(FormatAFragment.this.gson.toJsonTree((LinkedTreeMap) FormatAFragment.this.payloadAllHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload: ", String.valueOf(FormatAFragment.this.payloadAllHouses));
                        FormatAFragment formatAFragment = FormatAFragment.this;
                        formatAFragment.renderingdata(formatAFragment.payloadAllHouses);
                        FormatAFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    FormatAFragment.this.alertDialog1.dismiss();
                    FormatAFragment.this.binding.nodatalayout.setVisibility(0);
                    FormatAFragment.this.binding.allAppsRv.setVisibility(8);
                    FormatAFragment.this.binding.searchDsePending.setVisibility(8);
                    return;
                }
                FormatAFragment.this.alertDialog1.dismiss();
                FormatAFragment.this.binding.nodatalayout.setVisibility(0);
                FormatAFragment.this.binding.allAppsRv.setVisibility(8);
                FormatAFragment.this.binding.searchDsePending.setVisibility(8);
                return;
            }
            try {
                Logger.d("errorResponse", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("All houses", e.getMessage());
                if (response.code() == 401) {
                    FormatAFragment.this.alertDialog1.dismiss();
                    FormatAFragment.this.commomUtility.showMessageWithTitleOK(FormatAFragment.this.requireContext(), "Alert", FormatAFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
            }
            FormatAFragment.this.alertDialog1.dismiss();
            FormatAFragment.this.binding.nodatalayout.setVisibility(0);
            FormatAFragment.this.binding.allAppsRv.setVisibility(8);
            FormatAFragment.this.binding.searchDsePending.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormatAFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormatAFragment.this.getContext()).setLocaleBool(false);
            FormatAFragment.this.startActivity(new Intent((Context) FormatAFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            FormatAFragment.this.alertDialog1.dismiss();
            FormatAFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d(FormatAFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$3(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) DseActivity.class));
    }

    public void renderingdata(JSONArray allHouses) {
        this.allhousesList.clear();
        try {
            Logger.d("in reading...........................", String.valueOf(allHouses));
            for (int i = 0; i < allHouses.size(); i++) {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allHouses.get(i);
                String str = (String) linkedTreeMap.get("applicantFirstName");
                String str2 = (String) linkedTreeMap.get("applicantLastName");
                String str3 = str == null ? "" : str;
                String str4 = str2 == null ? "" : str2;
                String str5 = (String) linkedTreeMap.get("epicNumber");
                String strValueOf = String.valueOf(((Double) linkedTreeMap.get("acNumber")).intValue());
                String strValueOf2 = String.valueOf(((Double) linkedTreeMap.get("partNumber")).intValue());
                String strValueOf3 = String.valueOf(((Double) linkedTreeMap.get("age")).intValue());
                String str6 = (String) linkedTreeMap.get("gender");
                String str7 = (String) linkedTreeMap.get("relationName");
                String str8 = (String) linkedTreeMap.get("relationLName");
                String str9 = (str7 == null || str7.equals("null")) ? "" : str7;
                String str10 = (str8 == null || str8.equals("null")) ? "" : str8;
                this.allhousesList.add(new clusterDetailsDseModel(str3, str4, str5, strValueOf, strValueOf2, strValueOf3, str6, str9, str10, (String) linkedTreeMap.get("relationType"), null, 0, String.valueOf(((Double) linkedTreeMap.get("dseId")).intValue()), (String) linkedTreeMap.get("createdDttm"), null, (String) linkedTreeMap.get("photo"), String.valueOf(((Double) linkedTreeMap.get("clusterId")).intValue()), String.valueOf(((Double) linkedTreeMap.get("epicId")).intValue()), "", 0));
            }
            initRecyclerViewAdapter();
            this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.allAppsRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d("All houses", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloFormataPendingRvItemBinding.inflate(FormatAFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloFormataPendingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloFormataPendingRvItemBinding) holder.binding).HNoTv.setText(((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getClusterId());
            ((BloFormataPendingRvItemBinding) holder.binding).epicnumber.setText(((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getEpicnumber());
            ((BloFormataPendingRvItemBinding) holder.binding).applicantName.setText(((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getApplicantLastname());
            ((BloFormataPendingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getApplicantLastname();
            final String epicnumber = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getEpicnumber();
            final String age = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getAge();
            final String gender = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getGender();
            final String str2 = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getRelationfirstname() + " " + ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getRelationlastname();
            final String relationtype = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getRelationtype();
            final String ac = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getAc();
            final String partnumber = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getPartnumber();
            final String pseid = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getPseid();
            final String dateofinclusion = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getDateofinclusion();
            final String clusterId = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getClusterId();
            final String remark = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getRemark();
            final String photo = ((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getPhoto();
            ((BloFormataPendingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, epicnumber, pseid, partnumber, age, gender, str2, relationtype, ac, dateofinclusion, photo, clusterId, remark, view);
                }
            });
            if (FormatAFragment.this.partNo.equals(((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getPartnumber()) && FormatAFragment.this.asmblyNO.equals(((clusterDetailsDseModel) FormatAFragment.this.allhousesList.get(position)).getAc())) {
                ((BloFormataPendingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#C9F2FF"));
            } else {
                ((BloFormataPendingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, View view) {
            FormatAFragment.this.bottomSheet(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, BitmapFactory.decodeResource(FormatAFragment.this.getResources(), R.drawable.blo_dummy_image), str12, str13);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return FormatAFragment.this.allhousesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet(String name, final String epicno, final String dseID, final String partno, String age, String gender, String rlnName, String rlnType, final String acno, String dateofinclusion, String photo, Bitmap dummyimg, final String clusterId, final String epicIDs) {
        Date date;
        Dialog dialog = new Dialog(getContext());
        this.dialog = dialog;
        dialog.requestWindowFeature(1);
        BloFormatABottomsheetBinding bloFormatABottomsheetBindingInflate = BloFormatABottomsheetBinding.inflate(getLayoutInflater());
        this.formatABottomsheetBinding = bloFormatABottomsheetBindingInflate;
        this.dialog.setContentView((View) bloFormatABottomsheetBindingInflate.getRoot());
        this.dialog.getWindow().setLayout(-1, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        this.dialog.getWindow().setGravity(80);
        this.formatABottomsheetBinding.bottomSubmitLayout2.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitLayout.setVisibility(0);
        this.formatABottomsheetBinding.bottomSubmitForm8generation.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitForm8generated.setVisibility(8);
        this.formatABottomsheetBinding.preview.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
        String str = "";
        if (clusterId == null || clusterId.equals("null") || clusterId.equals("")) {
            this.formatABottomsheetBinding.clusterid.setText("");
        } else {
            this.formatABottomsheetBinding.clusterid.setText(clusterId);
        }
        if (name == null || name.equals("null") || name.equals("")) {
            this.formatABottomsheetBinding.applicantNameTv.setText("");
        } else {
            this.formatABottomsheetBinding.applicantNameTv.setText(name);
        }
        if (epicno == null || epicno.equals("null") || epicno.equals("")) {
            this.formatABottomsheetBinding.epicNoEt.setText("");
        } else {
            this.formatABottomsheetBinding.epicNoEt.setText(epicno);
        }
        if (age == null || age.equals("null") || age.equals("")) {
            this.formatABottomsheetBinding.ageEt.setText("");
        } else {
            this.formatABottomsheetBinding.ageEt.setText(age);
        }
        if (gender == null || gender.equals("null") || gender.equals("")) {
            this.formatABottomsheetBinding.genderTv1.setText("");
        } else if (gender.equals("M")) {
            this.formatABottomsheetBinding.genderTv1.setText("Male");
        } else if (gender.equals("F")) {
            this.formatABottomsheetBinding.genderTv1.setText("Female");
        } else if (gender.equals("T")) {
            this.formatABottomsheetBinding.genderTv1.setText("Other");
        }
        if (rlnName == null || rlnName.equals("null") || rlnName.equals("")) {
            this.formatABottomsheetBinding.relativeTv1.setText("");
        } else {
            this.formatABottomsheetBinding.relativeTv1.setText(rlnName);
        }
        if (rlnType == null || rlnType.equals("null") || rlnType.equals("")) {
            this.formatABottomsheetBinding.relationtype.setText("");
        } else if (rlnType.equals("F") || rlnType.equals("FTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Father");
        } else if (rlnType.equals("M") || rlnType.equals("MTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Mother");
        } else if (rlnType.equals("H") || rlnType.equals("HSBN")) {
            this.formatABottomsheetBinding.relationtype.setText("Husband");
        } else if (rlnType.equals("W") || rlnType.equals("WIFE")) {
            this.formatABottomsheetBinding.relationtype.setText("Wife");
        } else if (rlnType.equals("L") || rlnType.equals("OTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Other");
        } else {
            this.formatABottomsheetBinding.relationtype.setText("");
        }
        this.formatABottomsheetBinding.serialNo.setText(acno + " // " + partno);
        if (dateofinclusion != null && !dateofinclusion.equals("null") && !dateofinclusion.equals("")) {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateofinclusion.substring(0, 10));
            } catch (ParseException unused) {
                Logger.d("exception", "exception");
                date = null;
            }
            str = new SimpleDateFormat("dd/MM/yyyy").format(date);
        }
        this.formatABottomsheetBinding.dateInclusionEt.setText(str);
        if (photo != null) {
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile("objectstorage", photo, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3());
        } else {
            this.formatABottomsheetBinding.personImage.setImageBitmap(dummyimg);
        }
        HashMap map = new HashMap();
        map.put("epicNumber", epicno);
        map.put("acNo", acno);
        map.put("partNumber", partno);
        map.put(STATE_CD, this.blostatecode);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getaddressDetails(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass4());
        this.formatABottomsheetBinding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$5(view);
            }
        });
        this.formatABottomsheetBinding.chooseFileDeletion.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$6(view);
            }
        });
        this.formatABottomsheetBinding.submitTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$7(epicno, epicIDs, clusterId, acno, partno, dseID, view);
            }
        });
        this.formatABottomsheetBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$8(view);
            }
        });
        this.formatABottomsheetBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$9(view);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d("akjdal;", String.valueOf(response.code()));
            if (response.code() == 200) {
                ((JsonObject) response.body()).get("file");
                FormatAFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormatAFragment.this.encodedImage, 0);
                FormatAFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                FormatAFragment.this.formatABottomsheetBinding.personImage.setImageBitmap(FormatAFragment.this.bitmap);
                return;
            }
            try {
                Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString(FormatAFragment.MESSAGE));
            } catch (Exception e) {
                Logger.e("", e.getMessage());
                if (response.code() == 401) {
                    FormatAFragment.this.commomUtility.showMessageWithTitleOK(FormatAFragment.this.requireContext(), "Alert", FormatAFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$3$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormatAFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormatAFragment.this.getContext()).setLocaleBool(false);
            FormatAFragment.this.startActivity(new Intent((Context) FormatAFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(FormatAFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            Logger.d("ksjhf", String.valueOf(((EronetResponse) response.body()).getPayload()));
            if (response.body() != null) {
                FormatAFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                String string = "";
                if (!FormatAFragment.this.addressDetails.isEmpty()) {
                    JsonObject asJsonObject = FormatAFragment.this.gson.toJsonTree((LinkedTreeMap) FormatAFragment.this.addressDetails.get(0)).getAsJsonObject();
                    FormatAFragment formatAFragment = FormatAFragment.this;
                    if (!String.valueOf(asJsonObject.get("houseNumber")).equals("") && !String.valueOf(asJsonObject.get("houseNumber")).equals("null")) {
                        StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get("houseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim()).append(", ").append((String.valueOf(asJsonObject.get("localityStreet")).equals("") || String.valueOf(asJsonObject.get("localityStreet")).equals("null")) ? "" : String.valueOf(asJsonObject.get("localityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim() + ", ").append((String.valueOf(asJsonObject.get("villageName")).equals("") || String.valueOf(asJsonObject.get("villageName")).equals("null")) ? "" : String.valueOf(asJsonObject.get("villageName")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim() + ", ").append((String.valueOf(asJsonObject.get("townName")).equals("") || String.valueOf(asJsonObject.get("townName")).equals("null")) ? "" : String.valueOf(asJsonObject.get("townName")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim() + ", ").append((String.valueOf(asJsonObject.get("districtNameEnglish")).equals("") || String.valueOf(asJsonObject.get("districtNameEnglish")).equals("null")) ? "" : String.valueOf(asJsonObject.get("districtNameEnglish")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim() + ", ");
                        if (!String.valueOf(asJsonObject.get("stateNameEnglish")).equals("") && !String.valueOf(asJsonObject.get("stateNameEnglish")).equals("null")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get("stateNameEnglish")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim());
                            if (!String.valueOf(asJsonObject.get("poPin")).equals("") && !String.valueOf(asJsonObject.get("poPin")).equals("null")) {
                                string = ", " + String.valueOf(asJsonObject.get("poPin")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                            }
                            string = sbAppend2.append(string).toString();
                        }
                        string = sbAppend.append(string).toString();
                    }
                    formatAFragment.address = string;
                    FormatAFragment.this.formatABottomsheetBinding.addressTv1.setText(FormatAFragment.this.address);
                    return;
                }
                FormatAFragment.this.formatABottomsheetBinding.addressTv1.setText("");
                return;
            }
            try {
                Logger.d("errorResponse", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("house_number_frag", e.getMessage());
                if (response.code() == 401) {
                    FormatAFragment.this.commomUtility.showMessageWithTitleOK(FormatAFragment.this.requireContext(), "Alert", FormatAFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$4$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormatAFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormatAFragment.this.getContext()).setLocaleBool(false);
            FormatAFragment.this.startActivity(new Intent((Context) FormatAFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(FormatAFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$5(View view) {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose Image from Gallery", "Choose PDF from Gallery", "Cancel"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$bottomSheet$4(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$4(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            this.alertDialog1.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose Image from Gallery")) {
            this.alertDialog1.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
            openfile1();
        } else if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$6(View view) {
        this.photoref = " ";
        this.formatABottomsheetBinding.chooseFileName.setText("");
        this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
        this.formatABottomsheetBinding.preview.setVisibility(8);
        this.formatABottomsheetBinding.preview.setImageDrawable(null);
        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
        this.formatABottomsheetBinding.chooseFile.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$7(String str, String str2, String str3, String str4, String str5, String str6, View view) {
        this.formatBRemark = this.formatABottomsheetBinding.remarkUploadTv.getText().toString();
        System.out.println("forsf" + this.formatBRemark);
        if (this.formatABottomsheetBinding.remarkUploadTv.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Remark");
            return;
        }
        this.alertDialog1.show();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(Integer.parseInt(str2)));
        HashMap map = new HashMap();
        map.put(STATE_CD, this.stateCode);
        map.put("acNo", this.asmblyNO);
        map.put("dseClusterId", str3);
        map.put("epicNumbers", arrayList);
        map.put("epicIds", arrayList2);
        String str7 = this.photoref;
        if (str7 == null || str7.equals("null") || this.photoref.equals("") || this.photoref.equals(" ")) {
            map.put("dseStatus", 16);
            map.put("actionTaken", "BLO Verified without Format A Response");
        } else {
            map.put("dseStatus", 13);
            map.put("formatAResponseDoc", this.photoref);
            map.put("actionTaken", "Format A Response Upload");
        }
        JSONObject jSONObject = new JSONObject(map);
        Logger.d("formatAmap", String.valueOf(jSONObject));
        System.out.println("formatAmap" + jSONObject);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).dseSaveResponse(this.token, "blo", APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass5(str4, str5, str6, str3));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$acno;
        final /* synthetic */ String val$clusterId;
        final /* synthetic */ String val$dseID;
        final /* synthetic */ String val$partno;

        AnonymousClass5(final String val$acno, final String val$partno, final String val$dseID, final String val$clusterId) {
            this.val$acno = val$acno;
            this.val$partno = val$partno;
            this.val$dseID = val$dseID;
            this.val$clusterId = val$clusterId;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                Logger.d("response", String.valueOf(((JsonObject) response.body()).getAsJsonObject()));
                FormatAFragment formatAFragment = FormatAFragment.this;
                formatAFragment.formatASubmit(this.val$acno, this.val$partno, this.val$dseID, this.val$clusterId, formatAFragment.formatBRemark);
                FormatAFragment.this.alertDialog1.dismiss();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d("mesage---", String.valueOf(jSONObject.get(FormatAFragment.MESSAGE)));
                FormatAFragment.this.showdialog(FormatAFragment.MESSAGE1, String.valueOf(jSONObject.get(FormatAFragment.MESSAGE)));
                FormatAFragment.this.alertDialog1.dismiss();
            } catch (IOException | JSONException e) {
                Logger.d("pse_submit", e.getMessage());
                if (response.code() == 401) {
                    FormatAFragment.this.alertDialog1.dismiss();
                    FormatAFragment.this.commomUtility.showMessageWithTitleOK(FormatAFragment.this.requireContext(), "Alert", FormatAFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$5$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
                FormatAFragment.this.showdialog(FormatAFragment.MESSAGE1, "Null");
                FormatAFragment.this.alertDialog1.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormatAFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormatAFragment.this.getContext()).setLocaleBool(false);
            FormatAFragment.this.startActivity(new Intent((Context) FormatAFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(FormatAFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$8(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$9(View view) {
        this.dialog.dismiss();
    }

    public void formatASubmit(String acno, String partno, String dseId, String clusterId, String formatBRemark) {
        Logger.d("in pse submission ..............................", "");
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("clusterId", Integer.valueOf(Integer.parseInt(clusterId)));
        map.put("dseId", Integer.valueOf(Integer.parseInt(dseId)));
        map.put("action", "");
        map.put("bloRemarks", formatBRemark);
        map.put(STATE_CD, this.stateCode);
        map.put("acNo", Integer.valueOf(Integer.parseInt(acno)));
        map.put("partNo", Integer.valueOf(Integer.parseInt(partno)));
        map.put("bloAcNo", Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        map.put("bloPartNo", Integer.valueOf(Integer.parseInt(this.partNo)));
        map.put("document", "");
        map.put("epicNo", "");
        map.put("bloStatusId", 5);
        JSONObject jSONObject = new JSONObject(map);
        Logger.d("HELLO NO", String.valueOf(jSONObject));
        System.out.println("kjdksd" + jSONObject);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).formatASubmit(this.token, "blo", APPLICATION_JSON, this.blostatecode, "ANDROIDMOB", map).enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<EronetResponse> {
        AnonymousClass6() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                FormatAFragment.this.showdialog("Alert", "Dse Format A updated successfully");
                FormatAFragment.this.alertDialog1.dismiss();
                FormatAFragment.this.dialog.dismiss();
                FormatAFragment.this.openFragment(new FormatAFragment(), "FormatAFragment");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d("mesage---", String.valueOf(jSONObject.get(FormatAFragment.MESSAGE)));
                FormatAFragment.this.showdialog(FormatAFragment.MESSAGE1, String.valueOf(jSONObject.get(FormatAFragment.MESSAGE)));
                FormatAFragment.this.alertDialog1.dismiss();
            } catch (IOException | JSONException e) {
                Logger.d("pse_submit", e.getMessage());
                if (response.code() == 401) {
                    FormatAFragment.this.alertDialog1.dismiss();
                    FormatAFragment.this.commomUtility.showMessageWithTitleOK(FormatAFragment.this.requireContext(), "Alert", FormatAFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$6$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
                FormatAFragment.this.showdialog(FormatAFragment.MESSAGE1, "Null");
                FormatAFragment.this.alertDialog1.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormatAFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormatAFragment.this.getContext()).setLocaleBool(false);
            FormatAFragment.this.startActivity(new Intent((Context) FormatAFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(FormatAFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher1.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$7, reason: invalid class name */
    class AnonymousClass7 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass7() {
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0095 A[Catch: Exception -> 0x022d, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00ac A[Catch: Exception -> 0x022d, TRY_LEAVE, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: Exception -> 0x022d, TRY_ENTER, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:39:0x012e A[Catch: Exception -> 0x022d, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0146 A[Catch: Exception -> 0x022d, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0176 A[Catch: Exception -> 0x022d, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:44:0x021a A[Catch: Exception -> 0x022d, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0222 A[Catch: Exception -> 0x022d, TryCatch #2 {Exception -> 0x022d, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x021a, B:45:0x0222, B:46:0x022c), top: B:54:0x006d }] */
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            IOException e;
            Cursor cursorQuery;
            String string;
            double dRound;
            Throwable th;
            if (result.getResultCode() != -1) {
                return;
            }
            FormatAFragment.this.imageUri = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenInputStream = FormatAFragment.this.getContext().getContentResolver().openInputStream(FormatAFragment.this.imageUri);
                try {
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int i = inputStreamOpenInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStreamOpenInputStream != null) {
                                        try {
                                            inputStreamOpenInputStream.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                        } catch (IOException e2) {
                            e = e2;
                            Logger.e("", e.getMessage());
                            FormatAFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                            cursorQuery = FormatAFragment.this.getContext().getContentResolver().query(FormatAFragment.this.getSaveImagePath(Base64.encodeToString(FormatAFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.close();
                                throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                            }
                            cursorQuery.moveToFirst();
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                            if (string.toLowerCase().contains(".pdf")) {
                                if (FormatAFragment.this.filesize < 1024) {
                                    double dRound2 = Math.round(FormatAFragment.this.filesize * 100.0d) / 100.0d;
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.preview.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setText(string);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor(FormatAFragment.BLACK_COLOR));
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setText(dRound2 + "KB");
                                    FormatAFragment.this.formatABottomsheetBinding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                } else {
                                    dRound = Math.round(((double) (FormatAFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                    if (dRound > 3.0d) {
                                        FormatAFragment.this.formatABottomsheetBinding.preview.setVisibility(8);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
                                        FormatAFragment.this.showdialog("Alert", "PDF size exceeded 3MB limit.");
                                    } else {
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                                        FormatAFragment.this.formatABottomsheetBinding.preview.setVisibility(0);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setText(string);
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor(FormatAFragment.BLACK_COLOR));
                                        FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setText(dRound + "MB");
                                        FormatAFragment.this.formatABottomsheetBinding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    }
                                }
                                FormatAFragment.this.commonUtilClass.uploadToServer2(FormatAFragment.this.getContext(), FormatAFragment.this.stateCode, FormatAFragment.this.asmblyNO, FormatAFragment.this.partNo, FormatAFragment.this.filepathimg, FormatAFragment.this.saveImageFileName, FormatAFragment.this.token, "FormatAImage", FormatAFragment.this.atkband, FormatAFragment.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$7$$ExternalSyntheticLambda1
                                    @Override // in.gov.eci.bloapp.MyCallback
                                    public final void onCallback(int i2, String str) {
                                        this.f$0.lambda$onActivityResult$1(i2, str);
                                    }
                                });
                                return;
                            }
                            FormatAFragment.this.showdialog("", "Please Select the correct format of file");
                            return;
                        }
                        cursorQuery = FormatAFragment.this.getContext().getContentResolver().query(FormatAFragment.this.getSaveImagePath(Base64.encodeToString(FormatAFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (FormatAFragment.this.filesize < 1024) {
                                double dRound3 = Math.round(FormatAFragment.this.filesize * 100.0d) / 100.0d;
                                FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                                FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                                FormatAFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                                FormatAFragment.this.formatABottomsheetBinding.preview.setVisibility(0);
                                FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setText(string);
                                FormatAFragment.this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor(FormatAFragment.BLACK_COLOR));
                                FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setText(dRound3 + "KB");
                                FormatAFragment.this.formatABottomsheetBinding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (FormatAFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    FormatAFragment.this.formatABottomsheetBinding.preview.setVisibility(8);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
                                    FormatAFragment.this.showdialog("Alert", "PDF size exceeded 3MB limit.");
                                } else {
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.preview.setVisibility(0);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileName.setText(string);
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor(FormatAFragment.BLACK_COLOR));
                                    FormatAFragment.this.formatABottomsheetBinding.chooseFileNameSize.setText(dRound + "MB");
                                    FormatAFragment.this.formatABottomsheetBinding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            FormatAFragment.this.commonUtilClass.uploadToServer2(FormatAFragment.this.getContext(), FormatAFragment.this.stateCode, FormatAFragment.this.asmblyNO, FormatAFragment.this.partNo, FormatAFragment.this.filepathimg, FormatAFragment.this.saveImageFileName, FormatAFragment.this.token, "FormatAImage", FormatAFragment.this.atkband, FormatAFragment.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$7$$ExternalSyntheticLambda1
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$1(i2, str);
                                }
                            });
                            return;
                        }
                        FormatAFragment.this.showdialog("", "Please Select the correct format of file");
                        return;
                    } catch (Exception e3) {
                        Logger.d("CONTENT", e3.getMessage());
                        return;
                    }
                    FormatAFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                } catch (Throwable th4) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th4;
                }
            } catch (IOException e4) {
                byteArrayOutputStream = byteArrayOutputStream2;
                e = e4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1(int i, String str) {
            if (i == 401) {
                FormatAFragment.this.commonUtilClass.showMessageWithTitleOK(FormatAFragment.this.requireContext(), "Alert", FormatAFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
            } else {
                FormatAFragment.this.photoref = str;
                Logger.d("photoref------", FormatAFragment.this.photoref);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormatAFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormatAFragment.this.getContext()).setLocaleBool(false);
            FormatAFragment.this.startActivity(new Intent((Context) FormatAFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            this.alertDialog1.dismiss();
        }
        if (requestCode == 101 && resultCode == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.e("", e.getMessage());
            }
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image"), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                }
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                if (this.filesize < 1024) {
                    this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                    this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                    this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                    this.formatABottomsheetBinding.preview.setVisibility(0);
                    this.formatABottomsheetBinding.chooseFileName.setText(string);
                    this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor(BLACK_COLOR));
                    this.formatABottomsheetBinding.chooseFileNameSize.setText(this.filesize + "KB");
                    ImageView imageView = this.formatABottomsheetBinding.preview;
                    byte[] bArr = this.byteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                } else {
                    double dRound = Math.round(((double) ((float) (this.filesize / 1024.0d))) * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.formatABottomsheetBinding.preview.setVisibility(8);
                        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
                        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
                        this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
                        showdialog("Alert", "Image size exceeded 2MB limit.");
                    } else {
                        this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                        this.formatABottomsheetBinding.preview.setVisibility(0);
                        this.formatABottomsheetBinding.chooseFileName.setText(string);
                        this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor(BLACK_COLOR));
                        this.formatABottomsheetBinding.chooseFileNameSize.setText(dRound + "MB");
                        ImageView imageView2 = this.formatABottomsheetBinding.preview;
                        byte[] bArr2 = this.byteArray;
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                    }
                }
                this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, "FormatAImage", this.atkband, this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda11
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onActivityResult$11(i, str);
                    }
                });
                this.alertDialog1.dismiss();
            } catch (Exception e2) {
                Logger.d("CONTENT", e2.getMessage());
                this.alertDialog1.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$11(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.showMessageWithTitleOK(requireContext(), "Alert", SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$10(dialogInterface, i2);
                }
            });
        } else {
            this.photoref = str;
            Logger.d("photoref in camera------", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$10(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(getContext()).setIsLoggedIn(false);
        SharedPref.getInstance(getContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
