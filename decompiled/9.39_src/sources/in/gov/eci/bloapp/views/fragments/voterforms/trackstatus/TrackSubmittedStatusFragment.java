package in.gov.eci.bloapp.views.fragments.voterforms.trackstatus;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentTrackSubmittedStatusBinding;
import in.gov.eci.bloapp.databinding.BloSubmittedListRvItemBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TrackSubmittedStatusFragment extends Hilt_TrackSubmittedStatusFragment {
    GenericRecyclerView adapter;
    AlertDialog alertDialog;
    BloFragmentTrackSubmittedStatusBinding binding;
    final Retrofit.Builder builder1;
    Bundle bundle;
    final CommomUtility commomUtility;
    LayoutInflater inf;
    final OkHttpClient okHttpClient;
    JsonArray paylodJsonArray;
    final Retrofit retrofit;
    private String stateCode;
    final UserClient userClient;

    public TrackSubmittedStatusFragment() {
        CommomUtility commomUtility = new CommomUtility();
        this.commomUtility = commomUtility;
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.okHttpClient = okHttpClientBuild;
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild);
        this.builder1 = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.bundle = new Bundle();
        this.inf = null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentTrackSubmittedStatusBinding.inflate(getLayoutInflater());
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.inf = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            getTotalList();
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
        return this.binding.getRoot();
    }

    public void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass1(new GsonBuilder().setLenient().create()));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackSubmittedStatusFragment$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        final /* synthetic */ Gson val$gson;

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1(final Gson val$gson) {
            this.val$gson = val$gson;
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloSubmittedListRvItemBinding.inflate(TrackSubmittedStatusFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            JsonObject asJsonObject = this.val$gson.toJsonTree(TrackSubmittedStatusFragment.this.paylodJsonArray.get(position)).getAsJsonObject();
            ((BloSubmittedListRvItemBinding) holder.binding).firstNameTv.setText(String.valueOf(asJsonObject.get(Constants.FIRST_NAME)).replaceAll("^\"|\"$", "").replace("null", " ") + " " + String.valueOf(asJsonObject.get(Constants.LAST_NAME)).replaceAll("^\"|\"$", "").replace("null", " "));
            ((BloSubmittedListRvItemBinding) holder.binding).statusTv.setText(String.valueOf(asJsonObject.get("currentStatus")).replaceAll("^\"|\"$", "").replace("null", " "));
            ((BloSubmittedListRvItemBinding) holder.binding).refNoTv.setText(String.valueOf(asJsonObject.get("formRefNo")).replaceAll("^\"|\"$", "").replace("null", " "));
            ((BloSubmittedListRvItemBinding) holder.binding).formTypeTv.setText(String.valueOf(asJsonObject.get("formType")).replaceAll("^\"|\"$", "").replace("null", " "));
            ConstraintLayout constraintLayout = ((BloSubmittedListRvItemBinding) holder.binding).constraintLayout2;
            final Gson gson = this.val$gson;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackSubmittedStatusFragment$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(gson, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(Gson gson, int i, View view) {
            JsonObject asJsonObject = gson.toJsonTree(TrackSubmittedStatusFragment.this.paylodJsonArray.get(i)).getAsJsonObject();
            TrackSubmittedStatusFragment.this.bundle.putString(Constants.FIRST_NAME, String.valueOf(asJsonObject.get(Constants.FIRST_NAME)).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString(Constants.LAST_NAME, String.valueOf(asJsonObject.get(Constants.LAST_NAME)).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("formRefNo", String.valueOf(asJsonObject.get("formRefNo")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("formType", String.valueOf(asJsonObject.get("formType")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("submissionDate", String.valueOf(asJsonObject.get("submissionDate")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("currentStatus", String.valueOf(asJsonObject.get("currentStatus")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("submitted", String.valueOf(asJsonObject.get("submitted")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("bloAssigned", String.valueOf(asJsonObject.get("bloAssigned")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("fvrSubmitted", String.valueOf(asJsonObject.get("fvrSubmitted")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("epicNo", String.valueOf(asJsonObject.get("epicNo")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("epicDispatchedDate", String.valueOf(asJsonObject.get("epicDispatchedDate")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("hearingScheduled", String.valueOf(asJsonObject.get("hearingScheduled")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("fvrSubmittedHearingScheduled", String.valueOf(asJsonObject.get("fvrSubmittedHearingScheduled")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("accepted", String.valueOf(asJsonObject.get("accepted")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("rejected", String.valueOf(asJsonObject.get("rejected")).replaceAll("^\"|\"$", "").replace("null", " "));
            TrackSubmittedStatusFragment.this.bundle.putString("erollUpdatedDate", String.valueOf(asJsonObject.get("erollUpdatedDate")).replaceAll("^\"|\"$", "").replace("null", " "));
            SubmittedApplicationStatus submittedApplicationStatus = new SubmittedApplicationStatus();
            submittedApplicationStatus.setArguments(TrackSubmittedStatusFragment.this.bundle);
            TrackSubmittedStatusFragment.this.openFragment(submittedApplicationStatus);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return TrackSubmittedStatusFragment.this.paylodJsonArray.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, "All Status ");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    private void getTotalList() {
        System.out.println(SharedPref.getInstance(requireContext()).getStateCode() + "PPPPPPPPPPPPPPPPPPP222222" + SharedPref.getInstance(requireContext()).getAtknBnd() + "44444444444444444444444444444444" + SharedPref.getInstance(requireContext()).getRtknBnd());
        Call<JsonObject> callSubmittedtrackstatus = this.userClient.submittedtrackstatus(SharedPref.getInstance(requireContext()).getToken(), SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, "ANDROIDMOB");
        this.alertDialog.show();
        callSubmittedtrackstatus.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackSubmittedStatusFragment.2
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                TrackSubmittedStatusFragment.this.alertDialog.show();
                if (response.body() != null) {
                    TrackSubmittedStatusFragment.this.alertDialog.dismiss();
                    JsonObject jsonObject = (JsonObject) response.body();
                    try {
                        TrackSubmittedStatusFragment.this.paylodJsonArray = jsonObject.getAsJsonArray("payload");
                    } catch (JsonIOException e) {
                        Logger.d("", e.getMessage());
                    }
                    TrackSubmittedStatusFragment.this.initRecyclerViewAdapter();
                    TrackSubmittedStatusFragment.this.binding.allElectorRv.setLayoutManager(new GridLayoutManager(TrackSubmittedStatusFragment.this.getContext(), 1, 1, false));
                    TrackSubmittedStatusFragment.this.binding.allElectorRv.setAdapter(TrackSubmittedStatusFragment.this.adapter);
                    return;
                }
                TrackSubmittedStatusFragment.this.alertDialog.dismiss();
            }
        });
    }
}
