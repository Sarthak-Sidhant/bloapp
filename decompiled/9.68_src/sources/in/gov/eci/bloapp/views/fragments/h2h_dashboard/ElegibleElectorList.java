package in.gov.eci.bloapp.views.fragments.h2h_dashboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentElegibleElectorListBinding;
import in.gov.eci.bloapp.databinding.BloSurveylistRvBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.SurveyPreview;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ElegibleElectorList extends BaseFragment {
    private GenericRecyclerView adapter;
    BloFragmentElegibleElectorListBinding binding;
    Retrofit.Builder builder;
    JsonArray paylodJsonArray;
    Retrofit retrofit;
    String blopartNumber = "";
    String bloStatecode = "";
    String bloassemcode = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public ElegibleElectorList() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentElegibleElectorListBinding.inflate(getLayoutInflater());
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloStatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.blopartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.paylodJsonArray = new JsonArray();
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList.1
            public void handleOnBackPressed() {
                ElegibleElectorList.this.openFragment(new H2HDashboardFragment());
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        eroHouseFetch();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        openFragment(new H2HDashboardFragment());
    }

    public void eroHouseFetch() {
        showProgressVisible();
        HashMap map = new HashMap();
        map.put("stateCd", this.bloStatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartNumber);
        this.commomUtility.getRetrofitClient(getContext(), SharedPref.getInstance(getContext()).getToken(), SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).surveyFetch(SharedPref.getInstance(requireContext()).getToken(), "blo", this.bloStatecode, "application/json", "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList.2
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() == null) {
                    ElegibleElectorList.this.showProgressInVisible();
                    try {
                        ElegibleElectorList.this.showDialog(response.code() + "  " + new JSONObject(response.errorBody().string()).optString("message"));
                        return;
                    } catch (Exception e) {
                        Logger.d("", e.getMessage());
                        return;
                    }
                }
                ElegibleElectorList.this.paylodJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                if (ElegibleElectorList.this.paylodJsonArray.size() > 0) {
                    ElegibleElectorList.this.showProgressInVisible();
                    ElegibleElectorList.this.initRecyclerViewAdapter();
                    ElegibleElectorList.this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(ElegibleElectorList.this.requireContext(), 1, 1, false));
                    ElegibleElectorList.this.binding.allAppsRv.setAdapter(ElegibleElectorList.this.adapter);
                    return;
                }
                ElegibleElectorList.this.showProgressInVisible();
                ElegibleElectorList.this.showDialog("No Data Found");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList$3, reason: invalid class name */
    class AnonymousClass3 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloSurveylistRvBinding.inflate(ElegibleElectorList.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            final JsonObject asJsonObject = ElegibleElectorList.this.gson.toJsonTree(ElegibleElectorList.this.paylodJsonArray.get(position)).getAsJsonObject();
            ((BloSurveylistRvBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloSurveylistRvBinding) holder.binding).applicantTv.setText(String.valueOf(asJsonObject.get(Constants.FIRST_NAME)).replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE) + StringUtils.SPACE + String.valueOf(asJsonObject.get(Constants.LAST_NAME)).replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
            ((BloSurveylistRvBinding) holder.binding).ageTv.setText(String.valueOf(ElegibleElectorList.this.calculateage(String.valueOf(asJsonObject.get("dob")).replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE))));
            ((BloSurveylistRvBinding) holder.binding).housetv.setText(String.valueOf(asJsonObject.get("houseNo")).replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
            ((BloSurveylistRvBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.ElegibleElectorList$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(asJsonObject, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(JsonObject jsonObject, View view) {
            Intent intent = new Intent(view.getContext(), (Class<?>) SurveyPreview.class);
            try {
                intent.putExtra("json", String.valueOf(jsonObject));
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            ElegibleElectorList.this.startActivity(intent);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ElegibleElectorList.this.paylodJsonArray.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass3());
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateage(String dobdate) {
        if (dobdate.isEmpty()) {
            return 0;
        }
        LocalDate localDate = LocalDate.parse(dobdate);
        LocalDate localDateNow = LocalDate.now();
        if (localDate == null || localDateNow == null) {
            return 0;
        }
        return Period.between(localDate, localDateNow).getYears();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
