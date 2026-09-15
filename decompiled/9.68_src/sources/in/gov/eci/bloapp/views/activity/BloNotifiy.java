package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.NotificationAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloActivityBloNotifiyBinding;
import in.gov.eci.bloapp.model.app_model.NotificationItem;
import in.gov.eci.bloapp.model.app_model.NotificationRoot;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloNotifiy extends Hilt_BloNotifiy {
    private String acNo;
    AlertDialog alertDialog;
    private String atkband;
    private BloActivityBloNotifiyBinding binding;
    NotificationAdapter notificationAdapter;
    List<NotificationItem> notificationItemList;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    private String state;
    private String token;
    String SESSION = "";
    CommomUtility commomUtility = new CommomUtility();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        BloActivityBloNotifiyBinding bloActivityBloNotifiyBindingInflate = BloActivityBloNotifiyBinding.inflate(getLayoutInflater());
        this.binding = bloActivityBloNotifiyBindingInflate;
        setContentView(bloActivityBloNotifiyBindingInflate.getRoot());
        this.binding.recyclerViewNoti.setLayoutManager(new LinearLayoutManager(this));
        this.SESSION = getString(R.string.sessionMsg);
        this.binding.textView5.setText(BuildConfig.VERSION_NAME);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.alertDialog.show();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.BloNotifiy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BloNotifiy.this.startActivity(new Intent(BloNotifiy.this.getApplicationContext(), (Class<?>) MainActivity.class));
            }
        });
        this.binding.toolbarButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.BloNotifiy.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BloNotifiy.this.startActivity(new Intent(BloNotifiy.this.getApplicationContext(), (Class<?>) MainActivity.class));
            }
        });
        getNotificationList();
    }

    public void getNotificationList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        Call<NotificationRoot> allNotification = ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).getAllNotification(map);
        this.alertDialog.show();
        allNotification.enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.BloNotifiy$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<NotificationRoot> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.BloNotifiy] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<NotificationRoot> call, Response<NotificationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                BloNotifiy.this.alertDialog.dismiss();
                if (BloNotifiy.this.notificationItemList != null && !BloNotifiy.this.notificationItemList.isEmpty()) {
                    BloNotifiy.this.notificationItemList.clear();
                }
                BloNotifiy.this.notificationItemList = ((NotificationRoot) response.body()).payload;
                if (BloNotifiy.this.notificationItemList == null || BloNotifiy.this.notificationItemList.isEmpty()) {
                    BloNotifiy bloNotifiy = BloNotifiy.this;
                    bloNotifiy.showDialog2(bloNotifiy.getResources().getString(R.string.alertMsg), "No record found");
                    return;
                } else {
                    BloNotifiy.this.notificationAdapter = new NotificationAdapter(BloNotifiy.this.notificationItemList, new NotificationAdapter.Listener() { // from class: in.gov.eci.bloapp.views.activity.BloNotifiy.3.1
                        @Override // in.gov.eci.bloapp.adapter.NotificationAdapter.Listener
                        public void onItemClicked(NotificationItem item, int position) {
                        }

                        @Override // in.gov.eci.bloapp.adapter.NotificationAdapter.Listener
                        public void onReadMoreClicked(NotificationItem item, boolean willExpand) {
                            if (TextUtils.isEmpty(item.getId())) {
                                return;
                            }
                            "N".equalsIgnoreCase(item.isSeen());
                        }
                    });
                    BloNotifiy.this.binding.recyclerViewNoti.setAdapter(BloNotifiy.this.notificationAdapter);
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = BloNotifiy.this.commomUtility;
                ?? r4 = BloNotifiy.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.BloNotifiy$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) BloNotifiy.this, (CharSequence) strOptString, 1).show();
                Logger.e("TAG", strOptString);
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloNotifiy.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BloNotifiy.this.getApplicationContext()).setLocaleBool(false);
            BloNotifiy.this.startActivity(new Intent(BloNotifiy.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<NotificationRoot> call, Throwable t) {
            if (BloNotifiy.this.alertDialog != null) {
                BloNotifiy.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    private void setReadApiCall(String id) {
        Logger.d("ID", id);
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("isSeenId", id);
        map2.put("isSeenFlag", "Y");
        ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).setReadNotification(map, map2).enqueue(new AnonymousClass4(id));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.BloNotifiy$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$id;

        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass4(final String val$id) {
            this.val$id = val$id;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.BloNotifiy] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d("submitStatement4Data -> code : ", "" + response.code());
            if (response.code() == 200) {
                BloNotifiy.this.notificationAdapter.markSeen(this.val$id);
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = BloNotifiy.this.commomUtility;
                ?? r4 = BloNotifiy.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.BloNotifiy$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) BloNotifiy.this, (CharSequence) strOptString, 1).show();
                Logger.e("TAG", strOptString);
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (BloNotifiy.this.alertDialog != null) {
                    BloNotifiy.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloNotifiy.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BloNotifiy.this.getApplicationContext()).setLocaleBool(false);
            BloNotifiy.this.startActivity(new Intent(BloNotifiy.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.BloNotifiy$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$0(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }
}
