package in.gov.eci.bloapp.views.fragments.blonotification;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBlonotificationrecBinding;
import in.gov.eci.bloapp.databinding.BloFragmentBloNotificationBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.BloNotificationViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class BloNotificationFragment extends BaseFragment {
    private static final String MESSAGE = "message";
    private static final String NOTIFICATION_ERROR = "Notification Error - ";
    private static final String SEND_DATE = "sendDate";
    private String acNo;
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog;
    BloFragmentBloNotificationBinding binding;
    private String partNo;
    private String refreshToken;
    private String stateCode;
    private String token;
    private BloNotificationViewModel viewModel;
    private final CommomUtility commonUtilClass = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentBloNotificationBinding.inflate(getLayoutInflater());
        this.viewModel = (BloNotificationViewModel) new ViewModelProvider(requireActivity()).get(BloNotificationViewModel.class);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.alertDialog.show();
        getNotification(this.stateCode, this.token, this.acNo);
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        final /* synthetic */ JsonArray val$notificationList;

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1(final JsonArray val$notificationList) {
            this.val$notificationList = val$notificationList;
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloBlonotificationrecBinding.inflate(BloNotificationFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
            final JsonObject asJsonObject = BloNotificationFragment.this.gson.toJsonTree(this.val$notificationList.get(position)).getAsJsonObject();
            ((BloBlonotificationrecBinding) holder.binding).textViewMediaForms.setText(asJsonObject.get("subject").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""));
            ((BloBlonotificationrecBinding) holder.binding).newTextForms.setText(asJsonObject.get(BloNotificationFragment.MESSAGE).toString().replace(RegexMatcher.JSON_STRING_REGEX, ""));
            ((BloBlonotificationrecBinding) holder.binding).newTextFormsLarge.setVisibility(8);
            ((BloBlonotificationrecBinding) holder.binding).textViewMediaFormsNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BloNotificationFragment.AnonymousClass1.lambda$onBindViewHolder$0(holder, asJsonObject, view);
                }
            });
            try {
                int iLastIndexOf = asJsonObject.get(BloNotificationFragment.SEND_DATE).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").lastIndexOf(StringUtils.SPACE);
                ((BloBlonotificationrecBinding) holder.binding).newTextFormsBuilder.setText(BloNotificationFragment.this.format.format(BloNotificationFragment.this.simpleDateFormat1.parse(asJsonObject.get(BloNotificationFragment.SEND_DATE).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").substring(0, iLastIndexOf))) + " | " + asJsonObject.get(BloNotificationFragment.SEND_DATE).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").substring(iLastIndexOf, asJsonObject.get(BloNotificationFragment.SEND_DATE).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").lastIndexOf(".")));
            } catch (ParseException e) {
                Logger.d("BloNotificationFragment", e.toString());
            }
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, JsonObject jsonObject, View view) {
            if (((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextForms.getVisibility() == 0) {
                ((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextFormsLarge.setVisibility(0);
                ((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextForms.setVisibility(8);
                ((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextFormsLarge.setText(jsonObject.get(BloNotificationFragment.MESSAGE).toString().replace(RegexMatcher.JSON_STRING_REGEX, ""));
            } else if (((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextFormsLarge.getVisibility() == 0) {
                ((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextFormsLarge.setVisibility(8);
                ((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextForms.setVisibility(0);
                ((BloBlonotificationrecBinding) recyclerViewHolder.binding).newTextFormsLarge.setText(jsonObject.get(BloNotificationFragment.MESSAGE).toString().replace(RegexMatcher.JSON_STRING_REGEX, ""));
            }
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return this.val$notificationList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter1(JsonArray notificationList) {
        this.adapter = new GenericRecyclerView(new AnonymousClass1(notificationList));
    }

    public void getNotification(String stateCode, String Token, String acNo) {
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getNotification(Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", "ANDROIDMOB", acNo, "blo").enqueue(new AnonymousClass2(stateCode, acNo));
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$acNo;
        final /* synthetic */ String val$stateCode;

        AnonymousClass2(final String val$stateCode, final String val$acNo) {
            this.val$stateCode = val$stateCode;
            this.val$acNo = val$acNo;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                int count = BloNotificationFragment.this.viewModel.getCount(BloNotificationFragment.this.partNo);
                if (count != 0) {
                    BloNotificationFragment.this.binding.count.setText("New Notifications : " + Math.abs(((JsonObject) response.body()).get("maxCount").getAsInt() - count));
                } else {
                    BloNotificationFragment.this.binding.count.setText("New Notifications : " + count);
                }
                BloNotificationFragment.this.viewModel.updateCount(BloNotificationFragment.this.partNo, ((JsonObject) response.body()).get("maxCount").getAsInt());
                if (!((JsonObject) response.body()).get("payload").isJsonNull()) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    BloNotificationFragment.this.binding.count.setText("New Notifications : " + asJsonArray.size());
                    BloNotificationFragment.this.initRecyclerViewAdapter1(asJsonArray);
                    BloNotificationFragment.this.binding.newVoterRecycler.setLayoutManager(new GridLayoutManager(BloNotificationFragment.this.requireContext(), 1, 1, false));
                    BloNotificationFragment.this.binding.newVoterRecycler.setAdapter(BloNotificationFragment.this.adapter);
                } else {
                    BloNotificationFragment.this.binding.count.setText("New Notifications : 0");
                    BloNotificationFragment.this.commonUtilClass.showMessageWithTitleOK(BloNotificationFragment.this.requireContext(), "Message", ((JsonObject) response.body()).get(BloNotificationFragment.MESSAGE).toString().replace(RegexMatcher.JSON_STRING_REGEX, ""), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
                BloNotificationFragment.this.alertDialog.dismiss();
                return;
            }
            BloNotificationFragment.this.alertDialog.dismiss();
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(BloNotificationFragment.MESSAGE);
                if (response.code() == 401) {
                    CommomUtility commomUtility = BloNotificationFragment.this.commonUtilClass;
                    Context contextRequireContext = BloNotificationFragment.this.requireContext();
                    String str = BloNotificationFragment.this.refreshToken;
                    final String str2 = this.val$stateCode;
                    final String str3 = this.val$acNo;
                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda4
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str4, String str5) {
                            this.f$0.lambda$onResponse$2(str2, str3, i, str4, str5);
                        }
                    });
                } else {
                    BloNotificationFragment.this.commonUtilClass.showMessageWithTitleOK(BloNotificationFragment.this.requireContext(), BloNotificationFragment.NOTIFICATION_ERROR + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$3(dialogInterface, i);
                        }
                    });
                }
            } catch (IOException | JSONException e) {
                if (response.code() == 401) {
                    CommomUtility commomUtility2 = BloNotificationFragment.this.commonUtilClass;
                    Context contextRequireContext2 = BloNotificationFragment.this.requireContext();
                    String str4 = BloNotificationFragment.this.refreshToken;
                    final String str5 = this.val$stateCode;
                    final String str6 = this.val$acNo;
                    commomUtility2.getRefreshToken(contextRequireContext2, str4, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda6
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str7, String str8) {
                            this.f$0.lambda$onResponse$5(str5, str6, i, str7, str8);
                        }
                    });
                } else {
                    BloNotificationFragment.this.commonUtilClass.showMessageWithTitleOK(BloNotificationFragment.this.requireContext(), BloNotificationFragment.NOTIFICATION_ERROR + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda7
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                }
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            BloNotificationFragment.this.startActivity(new Intent((Context) BloNotificationFragment.this.getActivity(), (Class<?>) MainActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2, int i, String str3, String str4) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                BloNotificationFragment.this.commonUtilClass.showMessageOK(BloNotificationFragment.this.getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            BloNotificationFragment.this.token = "Bearer " + str3;
            BloNotificationFragment.this.refreshToken = str4;
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setRefreshToken(str4);
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setToken("Bearer " + str3);
            BloNotificationFragment bloNotificationFragment = BloNotificationFragment.this;
            bloNotificationFragment.getNotification(str, bloNotificationFragment.token, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setLocaleBool(false);
            BloNotificationFragment.this.startActivity(new Intent((Context) BloNotificationFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
            BloNotificationFragment.this.startActivity(new Intent((Context) BloNotificationFragment.this.getActivity(), (Class<?>) MainActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(String str, String str2, int i, String str3, String str4) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                BloNotificationFragment.this.commonUtilClass.showMessageOK(BloNotificationFragment.this.getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$4(dialogInterface, i2);
                    }
                });
                return;
            }
            BloNotificationFragment.this.token = "Bearer " + str3;
            BloNotificationFragment.this.refreshToken = str4;
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setRefreshToken(str4);
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setToken("Bearer " + str3);
            BloNotificationFragment bloNotificationFragment = BloNotificationFragment.this;
            bloNotificationFragment.getNotification(str, bloNotificationFragment.token, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BloNotificationFragment.this.requireContext()).setLocaleBool(false);
            BloNotificationFragment.this.startActivity(new Intent((Context) BloNotificationFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            BloNotificationFragment.this.alertDialog.dismiss();
            BloNotificationFragment.this.commonUtilClass.showMessageWithTitleOK(BloNotificationFragment.this.requireContext(), BloNotificationFragment.NOTIFICATION_ERROR, "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blonotification.BloNotificationFragment$2$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
