package in.gov.eci.bloapp.views.fragments.voterforms.trackstatus;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentTrackRejectedBinding;
import in.gov.eci.bloapp.databinding.BloSubmittedListRvItemBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.MigrationCorrection;
import in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.NewVoter;
import in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TrackRejectedFragment extends Hilt_TrackRejectedFragment {
    FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    ArrayList<String> applicantNameList;
    BloFragmentTrackRejectedBinding binding;
    final Retrofit.Builder builder1;
    final CommomUtility commomUtility;
    Call<JsonObject> feedModelCall;
    ArrayList<String> formJsonStringList;
    ArrayList<String> formTypeNameList;
    GridLayoutManager gridLayoutManager;
    Gson gson;
    LayoutInflater inf;
    boolean loading;
    final OkHttpClient okHttpClient;
    int page;
    int pastVisiblesItems;
    JsonArray paylodJsonArray;
    ArrayList<String> referenceNoList;
    String rejectedStr;
    final Retrofit retrofit;
    private String stateCode;
    String status;
    ArrayList<String> statusList;
    private String token;
    int totalItemCount;
    final UserClient userClient;
    int visibleItemCount;

    public TrackRejectedFragment() {
        CommomUtility commomUtility = new CommomUtility();
        this.commomUtility = commomUtility;
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.okHttpClient = okHttpClientBuild;
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild);
        this.builder1 = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.status = "";
        this.rejectedStr = "Rejected";
        this.gson = new GsonBuilder().setLenient().create();
        this.inf = null;
        this.statusList = new ArrayList<>();
        this.formTypeNameList = new ArrayList<>();
        this.referenceNoList = new ArrayList<>();
        this.formJsonStringList = new ArrayList<>();
        this.applicantNameList = new ArrayList<>();
        this.page = 1;
        this.loading = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentTrackRejectedBinding.inflate(getLayoutInflater());
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.inf = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.paylodJsonArray = new JsonArray();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        getTotalList();
        observed();
        this.gridLayoutManager = new GridLayoutManager(getContext(), 1, 1, false);
        this.binding.allElectorRv.setLayoutManager(this.gridLayoutManager);
        this.binding.allElectorRv.setAdapter(this.adapter);
        setScrollListener();
        return this.binding.getRoot();
    }

    public void observed() {
        this.feedModelCall.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment.1
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String str;
                TrackRejectedFragment.this.alertDialog.show();
                if (response.body() != null) {
                    TrackRejectedFragment.this.alertDialog.dismiss();
                    TrackRejectedFragment.this.loading = true;
                    TrackRejectedFragment.this.paylodJsonArray = ((JsonObject) response.body()).getAsJsonArray("content");
                    for (int i = 0; i < TrackRejectedFragment.this.paylodJsonArray.size(); i++) {
                        JsonObject asJsonObject = TrackRejectedFragment.this.gson.toJsonTree(TrackRejectedFragment.this.paylodJsonArray.get(i)).getAsJsonObject();
                        TrackRejectedFragment.this.statusList.add(String.valueOf(asJsonObject.get("formStatus")).replaceAll("^\"|\"$", "").replace("null", " "));
                        TrackRejectedFragment.this.formTypeNameList.add(String.valueOf(asJsonObject.get("formType")).replaceAll("^\"|\"$", "").replace("null", " "));
                        TrackRejectedFragment.this.referenceNoList.add(String.valueOf(asJsonObject.get("formRefNumber")).replaceAll("^\"|\"$", "").replace("null", " "));
                        String strReplace = asJsonObject.get("formJsonString").toString().replace("\\\\n", "").replace("\\\\", "");
                        try {
                            str = "\\\\";
                            try {
                                JSONObject jSONObject = new JSONObject(strReplace.substring(1, strReplace.length() - 1));
                                if (String.valueOf(asJsonObject.get("formType")).replaceAll("^\"|\"$", "").replace("null", " ").equals("FORM7")) {
                                    if (jSONObject.has("lastnameApplicant")) {
                                        TrackRejectedFragment.this.applicantNameList.add(jSONObject.getString("firstNameApplicant") + " " + jSONObject.getString("lastnameApplicant"));
                                    } else {
                                        TrackRejectedFragment.this.applicantNameList.add(jSONObject.getString("firstNameApplicant"));
                                    }
                                } else if (jSONObject.has(Constants.LAST_NAME)) {
                                    TrackRejectedFragment.this.applicantNameList.add(jSONObject.getString(Constants.FIRST_NAME) + " " + jSONObject.getString(Constants.LAST_NAME));
                                } else {
                                    TrackRejectedFragment.this.applicantNameList.add(jSONObject.getString(Constants.FIRST_NAME));
                                }
                            } catch (JSONException e) {
                                e = e;
                                TrackRejectedFragment.this.applicantNameList.add("");
                                Logger.d("", e.getMessage());
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            str = "\\\\";
                        }
                        JsonObject asJsonObject2 = TrackRejectedFragment.this.gson.toJsonTree(TrackRejectedFragment.this.paylodJsonArray.get(i)).getAsJsonObject();
                        String str2 = str;
                        TrackRejectedFragment.this.formJsonStringList.add(asJsonObject2.get("formJsonString").toString().replace("\\\\n", "").replaceAll(str2, "").substring(1, asJsonObject2.get("formJsonString").toString().replace("\\\\n", "").replace(str2, "").length() - 1));
                    }
                    TrackRejectedFragment.this.initRecyclerViewAdapter();
                    TrackRejectedFragment.this.gridLayoutManager = new GridLayoutManager(TrackRejectedFragment.this.getContext(), 1, 1, false);
                    TrackRejectedFragment.this.binding.allElectorRv.setLayoutManager(TrackRejectedFragment.this.gridLayoutManager);
                    TrackRejectedFragment.this.binding.allElectorRv.setAdapter(TrackRejectedFragment.this.adapter);
                    return;
                }
                TrackRejectedFragment.this.alertDialog.dismiss();
            }
        });
        getTotalList();
    }

    private void setScrollListener() {
        this.binding.allElectorRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment.2
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    Logger.e("logTag", "reached the last element of recyclerview");
                    TrackRejectedFragment trackRejectedFragment = TrackRejectedFragment.this;
                    trackRejectedFragment.visibleItemCount = trackRejectedFragment.gridLayoutManager.getChildCount();
                    TrackRejectedFragment trackRejectedFragment2 = TrackRejectedFragment.this;
                    trackRejectedFragment2.totalItemCount = trackRejectedFragment2.gridLayoutManager.getItemCount();
                    TrackRejectedFragment trackRejectedFragment3 = TrackRejectedFragment.this;
                    trackRejectedFragment3.pastVisiblesItems = trackRejectedFragment3.gridLayoutManager.findFirstVisibleItemPosition();
                    if (!TrackRejectedFragment.this.loading || TrackRejectedFragment.this.visibleItemCount + TrackRejectedFragment.this.pastVisiblesItems < TrackRejectedFragment.this.totalItemCount) {
                        return;
                    }
                    TrackRejectedFragment.this.loading = false;
                    TrackRejectedFragment.this.fetchMoreData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchMoreData() {
        this.alertDialog.show();
        this.page++;
        getTotalList();
        observed();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment$3, reason: invalid class name */
    class AnonymousClass3 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return null;
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloSubmittedListRvItemBinding.inflate(TrackRejectedFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloSubmittedListRvItemBinding) holder.binding).refNoTv.setText(TrackRejectedFragment.this.referenceNoList.get(position));
            if (TrackRejectedFragment.this.statusList.get(position).equals("R")) {
                TrackRejectedFragment.this.status = "Rejected  for Validation";
                ((BloSubmittedListRvItemBinding) holder.binding).statusTv.setText(TrackRejectedFragment.this.status);
                ((BloSubmittedListRvItemBinding) holder.binding).statusTv.setTextColor(Color.parseColor("#FD2B2B"));
            }
            ((BloSubmittedListRvItemBinding) holder.binding).formTypeTv.setText(TrackRejectedFragment.this.formTypeNameList.get(position));
            ((BloSubmittedListRvItemBinding) holder.binding).firstNameTv.setText(TrackRejectedFragment.this.applicantNameList.get(position));
            ((BloSubmittedListRvItemBinding) holder.binding).constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
            if (TrackRejectedFragment.this.formTypeNameList.get(i).equals("FORM6")) {
                Bundle bundle = new Bundle();
                NewVoter newVoter = new NewVoter();
                bundle.putString("form", TrackRejectedFragment.this.rejectedStr);
                bundle.putString("FORM6", TrackRejectedFragment.this.formJsonStringList.get(i));
                newVoter.setArguments(bundle);
                TrackRejectedFragment.this.openFragment(newVoter, "FORM6");
                return;
            }
            if (TrackRejectedFragment.this.formTypeNameList.get(i).equals("FORM6A")) {
                Bundle bundle2 = new Bundle();
                OverseasVoter overseasVoter = new OverseasVoter();
                bundle2.putString("form", TrackRejectedFragment.this.rejectedStr);
                bundle2.putString("OverseasVoter", TrackRejectedFragment.this.formJsonStringList.get(i));
                overseasVoter.setArguments(bundle2);
                TrackRejectedFragment.this.openFragment(overseasVoter, "OverseasVoter");
                return;
            }
            if (TrackRejectedFragment.this.formTypeNameList.get(i).equals("FORM7")) {
                Bundle bundle3 = new Bundle();
                DeletionObjectionForm deletionObjectionForm = new DeletionObjectionForm();
                bundle3.putString("form", TrackRejectedFragment.this.rejectedStr);
                bundle3.putString("Deletion", TrackRejectedFragment.this.formJsonStringList.get(i));
                deletionObjectionForm.setArguments(bundle3);
                TrackRejectedFragment.this.openFragment(deletionObjectionForm, "Deletion");
                return;
            }
            if (TrackRejectedFragment.this.formTypeNameList.get(i).equals("FORM6B")) {
                Bundle bundle4 = new Bundle();
                AadhaarAuthenticationFormFragment aadhaarAuthenticationFormFragment = new AadhaarAuthenticationFormFragment();
                bundle4.putString("form", TrackRejectedFragment.this.rejectedStr);
                bundle4.putString("AadhaarAuthenticationFormFragment", TrackRejectedFragment.this.formJsonStringList.get(i));
                aadhaarAuthenticationFormFragment.setArguments(bundle4);
                TrackRejectedFragment.this.openFragment(aadhaarAuthenticationFormFragment, "AadhaarAuthenticationFormFragment");
                return;
            }
            if (TrackRejectedFragment.this.formTypeNameList.get(i).equals("FORM8")) {
                Bundle bundle5 = new Bundle();
                MigrationCorrection migrationCorrection = new MigrationCorrection();
                bundle5.putString("form", TrackRejectedFragment.this.rejectedStr);
                bundle5.putString("Migration_correction", TrackRejectedFragment.this.formJsonStringList.get(i));
                migrationCorrection.setArguments(bundle5);
                TrackRejectedFragment.this.openFragment(migrationCorrection, "Migration_correction");
            }
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return TrackRejectedFragment.this.formTypeNameList.size();
        }
    }

    public void initRecyclerViewAdapter() {
        this.adapter = new FilterableRecyclerView(new AnonymousClass3());
    }

    private void getTotalList() {
        this.feedModelCall = this.userClient.rejectedtrackstatus(this.token, "blo", this.stateCode, "ANDROIDMOB", this.page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (menuVisible) {
            setScrollListener();
            initRecyclerViewAdapter();
        }
    }
}
