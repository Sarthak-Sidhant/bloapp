package in.gov.eci.bloapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.model.SIR.EfTrackerListModel;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EfTrackerAdapter extends RecyclerView.Adapter<ViewHolder> {
    int acNo;
    private String atkband;
    private Context context;
    ArrayList<EfTrackerListModel> datalist;
    private String rtkband;
    ArrayList<EfTrackerListModel> searchList;
    UserClient service;
    private String state;
    private String token;

    public EfTrackerAdapter(ArrayList<EfTrackerListModel> datalist, Context context, String token, String state, String atkband, String rtkband, int acNo) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.acNo = acNo;
        this.service = (UserClient) ApiClient.getClient2(context).create(UserClient.class);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton BtepicMached;
        TextView EpicText;
        TextView NameText;
        LinearLayout cardView;
        TextView collected;
        TextView disributed;
        TextView serialText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.collected = (TextView) itemView.findViewById(R.id.fill_pending_sir);
            this.disributed = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
            this.cardView = (LinearLayout) itemView.findViewById(R.id.ccEf);
            this.BtepicMached = itemView.findViewById(R.id.bt_epic_matched);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ef_tracker_list_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final EfTrackerListModel efTrackerListModel = this.datalist.get(i);
        viewHolder.EpicText.setText(efTrackerListModel.getEpicNo());
        viewHolder.serialText.setText(efTrackerListModel.getSerialNo());
        viewHolder.NameText.setText(efTrackerListModel.getName());
        Log.d("Adapter", "Binding" + efTrackerListModel.getEpicNo());
        Log.d("CheckingEFTRACKEr", efTrackerListModel.getIsDelivered() + StringUtils.SPACE + efTrackerListModel.getIsUncollectable() + StringUtils.SPACE + efTrackerListModel.getIsCollected());
        String isDelivered = efTrackerListModel.getIsDelivered();
        String isUncollectable = efTrackerListModel.getIsUncollectable();
        String isCollected = efTrackerListModel.getIsCollected();
        if (isDelivered.equalsIgnoreCase("N") && isUncollectable.equalsIgnoreCase("N") && isCollected.equalsIgnoreCase("N")) {
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#FF8C8C"));
            viewHolder.disributed.setVisibility(0);
            if (efTrackerListModel.getEpicMatch() == 1) {
                viewHolder.BtepicMached.setVisibility(0);
                viewHolder.collected.setVisibility(0);
            } else {
                viewHolder.BtepicMached.setVisibility(8);
                viewHolder.collected.setVisibility(8);
            }
        } else if (isDelivered.equalsIgnoreCase("Y") && isCollected.equalsIgnoreCase("N") && isUncollectable.equalsIgnoreCase("N")) {
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#ADD8E6"));
            viewHolder.disributed.setVisibility(8);
            if (efTrackerListModel.getEpicMatch() == 1) {
                viewHolder.BtepicMached.setVisibility(0);
                viewHolder.collected.setVisibility(0);
            } else {
                viewHolder.BtepicMached.setVisibility(8);
                viewHolder.collected.setVisibility(8);
            }
        } else if ((isDelivered.equalsIgnoreCase("Y") || isDelivered.equalsIgnoreCase("N")) && isCollected.equalsIgnoreCase("Y") && isUncollectable.equalsIgnoreCase("N")) {
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#DBF7C4"));
            viewHolder.disributed.setVisibility(8);
            viewHolder.collected.setVisibility(8);
            if (efTrackerListModel.getEpicMatch() == 1) {
                viewHolder.BtepicMached.setVisibility(0);
            } else {
                viewHolder.BtepicMached.setVisibility(8);
            }
        } else if (isDelivered.equalsIgnoreCase("Y") && isCollected.equalsIgnoreCase("N") && isUncollectable.equalsIgnoreCase("Y")) {
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#FEB139"));
            viewHolder.disributed.setVisibility(8);
            viewHolder.collected.setVisibility(8);
            if (efTrackerListModel.getEpicMatch() == 1) {
                viewHolder.BtepicMached.setVisibility(0);
            } else {
                viewHolder.BtepicMached.setVisibility(8);
            }
        }
        viewHolder.collected.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EfTrackerAdapter.this.showDialog2("Alert", "Please take the duly filled and signed Enumeration Form from the elector.", efTrackerListModel, i, "Mark Collected");
            }
        });
        viewHolder.BtepicMached.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EfTrackerAdapter.this.callVerifyRelativeApi(efTrackerListModel);
            }
        });
        viewHolder.disributed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EfTrackerAdapter.this.showDialog2("Alert", "Are you sure to mark Distributed ?", efTrackerListModel, i, "Mark Distributed");
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<EfTrackerListModel> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }

    private void getAllPendingList(EfTrackerListModel item, final String IsDelivered, final String IsCollected, final int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("epicNo", item.getEpicNo());
        map2.put("epicId", item.getEpicId());
        if (!TextUtils.isEmpty(item.getSerialNo().trim()) && item.getSerialNo().trim().length() > 0) {
            map2.put("partSerialNo", Integer.valueOf(item.getSerialNo()));
        } else {
            map2.put("partSerialNo", 0);
        }
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("isDelivered", IsDelivered);
        map2.put("isCollected", IsCollected);
        this.service.updateEfFlagSIR(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter.4
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(EfTrackerAdapter.this.context, "Success", 1).show();
                    if (!TextUtils.isEmpty(IsDelivered) && IsDelivered.equalsIgnoreCase("Y")) {
                        EfTrackerAdapter.this.updateItemFlag(i, "Y");
                    }
                    if (TextUtils.isEmpty(IsCollected) || !IsCollected.equalsIgnoreCase("Y")) {
                        return;
                    }
                    EfTrackerAdapter.this.updateCollectedFlag(i, "Y");
                    return;
                }
                if (response.code() != 400) {
                    response.code();
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("efTrackerGhosh", t.getMessage());
            }
        });
    }

    public void updateItemFlag(int position, String isFlag) {
        this.datalist.get(position).setIsDelivered(isFlag);
        notifyItemChanged(position);
    }

    public void updateCollectedFlag(int position, String isFlag) {
        this.datalist.get(position).setIsCollected(isFlag);
        notifyItemChanged(position);
    }

    public String getcountCardView() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.datalist.size(); i5++) {
            if (this.datalist.get(i5).getIsDelivered().equalsIgnoreCase("N") && this.datalist.get(i5).getIsUncollectable().equalsIgnoreCase("N") && this.datalist.get(i5).getIsCollected().equalsIgnoreCase("N")) {
                i++;
            }
            if (this.datalist.get(i5).getIsDelivered().equalsIgnoreCase("Y") && this.datalist.get(i5).getIsCollected().equalsIgnoreCase("N") && this.datalist.get(i5).getIsUncollectable().equalsIgnoreCase("N")) {
                i2++;
            }
            if ((this.datalist.get(i5).getIsDelivered().equalsIgnoreCase("Y") || this.datalist.get(i5).getIsDelivered().equalsIgnoreCase("N")) && this.datalist.get(i5).getIsCollected().equalsIgnoreCase("Y") && this.datalist.get(i5).getIsUncollectable().equalsIgnoreCase("N")) {
                i3++;
            }
            if (this.datalist.get(i5).getIsDelivered().equalsIgnoreCase("Y") && this.datalist.get(i5).getIsCollected().equalsIgnoreCase("N") && this.datalist.get(i5).getIsUncollectable().equalsIgnoreCase("Y")) {
                i4++;
            }
        }
        return "" + i + "," + i2 + "," + i3 + "," + i4 + "," + (i + i2 + i3 + i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog2(String alertText, String message, final EfTrackerListModel item, final int i, final String type) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$showDialog2$0(type, item, i, dialogInterface, i2);
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$0(String str, EfTrackerListModel efTrackerListModel, int i, DialogInterface dialogInterface, int i2) {
        if (str.equalsIgnoreCase("Mark Distributed")) {
            getAllPendingList(efTrackerListModel, "Y", "N", i);
        } else if (str.equalsIgnoreCase("Mark Collected")) {
            getAllPendingList(efTrackerListModel, "Y", "Y", i);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertDialog_ef(String oldName, String epicNumber, String oldRelativeFullName, String relationType, String partNumber, String partName, String acNo1, String acName, String stateName, String oldPsl) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.ef_tracker_match_epic_alert, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.txtName);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.txtEpic);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.txtRelativeName);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.txtTypeRelation);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.txtPartNumber);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.txtPartName);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.txtAcPartSerialNumber);
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.txtAcPartSerialName);
        TextView textView9 = (TextView) viewInflate.findViewById(R.id.txtAcPartStateName);
        TextView textView10 = (TextView) viewInflate.findViewById(R.id.txtPsl);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.cross);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(false);
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        textView.setText(oldName);
        textView2.setText(epicNumber);
        textView3.setText(oldRelativeFullName);
        textView5.setText(partNumber);
        textView6.setText(partName);
        textView7.setText(acNo1);
        textView8.setText(acName);
        textView9.setText(stateName);
        textView10.setText(oldPsl);
        if (!TextUtils.isEmpty(relationType)) {
            if (relationType.equals("GMTH")) {
                textView4.setText("Grand Mother");
            } else if (relationType.equals("GFTH")) {
                textView4.setText("Grand Father");
            } else if (relationType.equals("MTHR")) {
                textView4.setText("Mother");
            } else if (relationType.equals("FTHR") || relationType.equals("F")) {
                textView4.setText("Father");
            } else if (relationType.equals("HSBN") || relationType.equals("H")) {
                textView4.setText("Husband");
            } else if (relationType.equals("OTHR")) {
                textView4.setText("Other");
            } else if (TextUtils.isEmpty(relationType)) {
                textView4.setText("");
            } else {
                textView4.setText(relationType);
            }
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Log.d("Cross", "CrossWorking");
                alertDialogCreate.dismiss();
            }
        });
        alertDialogCreate.show();
    }

    void callVerifyRelativeApi(EfTrackerListModel item) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("Content-Type", "application/json");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("currentEpicNo", item.getEpicNo());
        this.service.get2003DataByEpic(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter.6
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        JSONObject jSONObject = new JSONArray(new GsonBuilder().setLenient().create().toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        String strOptString = jSONObject.optString("oldFullName", null);
                        String strOptString2 = jSONObject.optString("oldEpicNumber", null);
                        String strOptString3 = jSONObject.optString("oldRelativeFullName", null);
                        String strOptString4 = jSONObject.optString("relationType", null);
                        String strOptString5 = jSONObject.optString("oldPartNumber", null);
                        String strOptString6 = jSONObject.optString("oldPartName", null);
                        String strOptString7 = jSONObject.optString("oldAcNo", null);
                        String strOptString8 = jSONObject.optString("oldAcName", null);
                        String strOptString9 = jSONObject.optString("oldStateName", null);
                        String strOptString10 = jSONObject.optString("oldPartSerialNo", null);
                        EfTrackerAdapter.this.alertDialog_ef(TextUtils.isEmpty(strOptString) ? "" : strOptString, TextUtils.isEmpty(strOptString2) ? "" : strOptString2, TextUtils.isEmpty(strOptString3) ? "" : strOptString3, TextUtils.isEmpty(strOptString4) ? "" : strOptString4, TextUtils.isEmpty(strOptString5) ? "" : strOptString5, TextUtils.isEmpty(strOptString6) ? "" : strOptString6, TextUtils.isEmpty(strOptString7) ? "" : strOptString7, TextUtils.isEmpty(strOptString8) ? "" : strOptString8, TextUtils.isEmpty(strOptString9) ? "" : strOptString9, TextUtils.isEmpty(strOptString10) ? "" : strOptString10);
                        return;
                    } catch (JSONException e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(EfTrackerAdapter.this.context, "Something went wrong", 1).show();
                        return;
                    }
                }
                try {
                    EfTrackerAdapter.this.showAlertDialog("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog(String alertText, String message) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(this.context.getResources().getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.EfTrackerAdapter$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }
}
