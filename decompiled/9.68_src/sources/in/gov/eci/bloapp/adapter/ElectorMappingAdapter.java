package in.gov.eci.bloapp.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.model.SIR.ElectorMappingListModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.ElectorMapDetails;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ElectorMappingAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String atkband;
    private Context context;
    ArrayList<ElectorMappingListModel> datalist;
    String epicNumber;
    String pestatecd;
    String prvsAcNo;
    String prvsPartNumber;
    String prvsSLNo;
    ArrayList<String> relationCodeList;
    ArrayList<String> relationNameList;
    private String rtkband;
    ArrayList<ElectorMappingListModel> searchList;
    UserClient service;
    private String state;
    private String token;
    ArrayList<String> progenyEpicList = new ArrayList<>();
    ArrayList<String> progenyEpicName = new ArrayList<>();
    ArrayList<Integer> progenyEpicId = new ArrayList<>();
    boolean isUserAction = false;
    Gson gson = new GsonBuilder().setLenient().create();
    String selectRelationType = "Select Relation Type";
    String releationCode = "";

    public ElectorMappingAdapter(ArrayList<ElectorMappingListModel> datalist, Context context, String token, String state, String atkband, String rtkband) {
        this.relationNameList = new ArrayList<>();
        this.relationCodeList = new ArrayList<>();
        this.datalist = datalist;
        this.context = context;
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.service = (UserClient) ApiClient.getClient(context).create(UserClient.class);
        this.relationNameList = SharedPref.getInstance(context).getRelativeListCode(Constants.RELATIVE_MAPPING_LIST_NAME);
        this.relationCodeList = SharedPref.getInstance(context).getRelativeListName(Constants.RELATIVE_MAPPING_LIST_CODE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView deleteBtn;
        LinearLayout electorMAppingLL;
        ImageView iv_verified;
        TextView mapElectorBtn;
        TextView serialText;
        TextView txt_map_progny;
        TextView txt_view_progny;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_elector_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_elector_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_elector_sir);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.txtDeleteElector);
            this.txt_map_progny = (TextView) itemView.findViewById(R.id.txt_map_progny);
            this.mapElectorBtn = (TextView) itemView.findViewById(R.id.txt_map_elector);
            this.electorMAppingLL = (LinearLayout) itemView.findViewById(R.id.electorMapingLL);
            this.iv_verified = (ImageView) itemView.findViewById(R.id.iv_verified);
            this.txt_view_progny = (TextView) itemView.findViewById(R.id.txt_view_progny);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elector_mapping_list_sir_items, parent, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final ElectorMappingListModel electorMappingListModel = this.datalist.get(i);
        viewHolder.EpicText.setText(electorMappingListModel.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(electorMappingListModel.getCurrentSerialNo()));
        viewHolder.NameText.setText(electorMappingListModel.getName());
        if (electorMappingListModel.getAc() != 0 && electorMappingListModel.getPart() != 0 && electorMappingListModel.getSerialNo() != 0 && !TextUtils.isEmpty(electorMappingListModel.getModifiedBy()) && !electorMappingListModel.getModifiedBy().equalsIgnoreCase("System") && !electorMappingListModel.getModifiedBy().equalsIgnoreCase("BLO")) {
            viewHolder.deleteBtn.setVisibility(0);
            viewHolder.mapElectorBtn.setVisibility(8);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.color_mapping));
            viewHolder.txt_map_progny.setVisibility(0);
            viewHolder.txt_map_progny.setText(this.context.getResources().getString(R.string.btn_progny));
            if (electorMappingListModel.getProgencyCount() == 0) {
                viewHolder.txt_view_progny.setVisibility(8);
            } else {
                viewHolder.txt_view_progny.setVisibility(0);
                viewHolder.txt_view_progny.setText(this.context.getResources().getString(R.string.btn_view_progny) + " ( " + electorMappingListModel.getProgencyCount() + " )");
            }
            viewHolder.deleteBtn.setText("Unmap Elector");
            viewHolder.iv_verified.setVisibility(0);
        } else if (electorMappingListModel.getAc() != 0 && electorMappingListModel.getPart() != 0 && electorMappingListModel.getSerialNo() != 0 && !TextUtils.isEmpty(electorMappingListModel.getModifiedBy()) && (electorMappingListModel.getModifiedBy().equalsIgnoreCase("System") || electorMappingListModel.getModifiedBy().equalsIgnoreCase("BLO"))) {
            viewHolder.deleteBtn.setVisibility(0);
            viewHolder.mapElectorBtn.setVisibility(8);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.color_unmapping));
            viewHolder.txt_map_progny.setVisibility(8);
            viewHolder.txt_view_progny.setVisibility(8);
            viewHolder.deleteBtn.setText("Verify/Unmap Elector");
            viewHolder.iv_verified.setVisibility(8);
        } else {
            viewHolder.deleteBtn.setVisibility(8);
            viewHolder.mapElectorBtn.setVisibility(0);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.cardview_light_background));
            viewHolder.txt_map_progny.setVisibility(8);
            viewHolder.txt_view_progny.setVisibility(8);
            viewHolder.iv_verified.setVisibility(8);
        }
        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMappingAdapter.this.showDialog1(electorMappingListModel.getName(), electorMappingListModel.getPreviousElectorName(), electorMappingListModel.getRelativeName(), electorMappingListModel.getRelativeCurrentName(), electorMappingListModel.getErollRelationType(), electorMappingListModel.getOldEpic(), electorMappingListModel.getAc(), electorMappingListModel.getPart(), electorMappingListModel.getSerialNo(), electorMappingListModel.getEpicNo(), electorMappingListModel.getCurrentAc(), electorMappingListModel.getCurrentPart(), electorMappingListModel.getCurrentSerialNo(), i, electorMappingListModel.getId());
            }
        });
        viewHolder.txt_map_progny.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMappingAdapter.this.showDialogAddProgny(electorMappingListModel, i);
            }
        });
        viewHolder.txt_view_progny.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ElectorMappingAdapter.this.datalist.get(i).getProgencyCount() == 0) {
                    Toast.makeText(ElectorMappingAdapter.this.context, ElectorMappingAdapter.this.context.getText(R.string.no_record), 1).show();
                } else {
                    ElectorMappingAdapter.this.viewProgeny(electorMappingListModel.getEpicNo(), i);
                }
            }
        });
        viewHolder.mapElectorBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                viewHolder.getAdapterPosition();
                Intent intent = new Intent(ElectorMappingAdapter.this.context, (Class<?>) ElectorMapDetails.class);
                intent.putExtra("epic", electorMappingListModel.getEpicNo());
                intent.putExtra("name", electorMappingListModel.getName());
                intent.putExtra("relativeName", electorMappingListModel.getRelativeCurrentName());
                intent.putExtra("psl", String.valueOf(electorMappingListModel.getCurrentSerialNo()));
                intent.putExtra("id", String.valueOf(electorMappingListModel.getId()));
                intent.putExtra("ac", String.valueOf(electorMappingListModel.getCurrentAc()));
                intent.putExtra("part", String.valueOf(electorMappingListModel.getCurrentPart()));
                intent.putExtra("state", electorMappingListModel.getStateCode());
                intent.putExtra("currentAge", electorMappingListModel.getCurrentAge());
                ElectorMappingAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<ElectorMappingListModel> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }

    public void resetElector(String epic, int ac, int part, int psl, final int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("stateCd", this.state);
        map2.put("acNo", Integer.valueOf(ac));
        map2.put("partNo", Integer.valueOf(part));
        map2.put("serialNo", Integer.valueOf(psl));
        map2.put("epicNo", epic);
        this.service.resetErollData(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.5
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.code() == 200) {
                        Toast.makeText(ElectorMappingAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                        ElectorMappingAdapter.this.datalist.get(pos).setAc(0);
                        ElectorMappingAdapter.this.datalist.get(pos).setPart(0);
                        ElectorMappingAdapter.this.datalist.get(pos).setSerialNo(0);
                        ElectorMappingAdapter.this.notifyItemChanged(pos);
                        return;
                    }
                    Toast.makeText(ElectorMappingAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    return;
                }
                try {
                    if (response.errorBody() != null) {
                        Toast.makeText(ElectorMappingAdapter.this.context, new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                    }
                } catch (Exception e) {
                    Logger.d("Elector Mapping adapter", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d("Elector Mapping adapter", t.toString());
            }
        });
    }

    public void verifyElector(String epic, int iD, final int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        this.service.vewrifyErollData(map, iD).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.6
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.code() == 200) {
                        ElectorMappingAdapter.this.datalist.get(pos).setModifiedBy("keyclock");
                        ElectorMappingAdapter.this.notifyItemChanged(pos);
                        Toast.makeText(ElectorMappingAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                        return;
                    }
                    Toast.makeText(ElectorMappingAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    return;
                }
                try {
                    if (response.errorBody() != null) {
                        Toast.makeText(ElectorMappingAdapter.this.context, new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                    }
                } catch (Exception e) {
                    Logger.d("Elector Mapping adapter", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d("Elector Mapping adapter", t.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String name, String previousElectorName, String relativeName, String currentRelativeName, String typeRelation, String epic, int oldAc, int oldPart, int oldPsl, final String correntEpic, final int ac, final int part, final int psl, final int pos, final int iD) {
        final Dialog dialog = new Dialog(this.context);
        dialog.setContentView(R.layout.dialog_unmapped_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(true);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        Button button3 = (Button) dialog.findViewById(R.id.btnVerify);
        TextView textView = (TextView) dialog.findViewById(R.id.txtName);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtRelativeName);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtOldAc);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtOldPart);
        TextView textView5 = (TextView) dialog.findViewById(R.id.txtEpic);
        TextView textView6 = (TextView) dialog.findViewById(R.id.txtPsl);
        TextView textView7 = (TextView) dialog.findViewById(R.id.CurrentName);
        TextView textView8 = (TextView) dialog.findViewById(R.id.txtCurrentRelativeName);
        TextView textView9 = (TextView) dialog.findViewById(R.id.currentAC);
        TextView textView10 = (TextView) dialog.findViewById(R.id.currentPart);
        TextView textView11 = (TextView) dialog.findViewById(R.id.CurrentEpic);
        TextView textView12 = (TextView) dialog.findViewById(R.id.currentSerial);
        TextView textView13 = (TextView) dialog.findViewById(R.id.txtHeading);
        TextView textView14 = (TextView) dialog.findViewById(R.id.txtConfirm);
        if (!this.datalist.get(pos).getModifiedBy().equalsIgnoreCase("System") && !this.datalist.get(pos).getModifiedBy().equalsIgnoreCase("BLO")) {
            textView13.setText("Unmap Elector Details");
            button3.setVisibility(8);
            textView14.setVisibility(0);
        } else {
            textView13.setText("Verify/Unmap Elector Details ");
            button3.setVisibility(0);
            textView14.setVisibility(8);
        }
        if (!TextUtils.isEmpty(previousElectorName)) {
            textView.setText(previousElectorName);
        }
        if (!TextUtils.isEmpty(relativeName)) {
            textView2.setText(relativeName);
        }
        textView3.setText("AC : " + String.valueOf(oldAc));
        textView4.setText("Part : " + String.valueOf(oldPart));
        if (!TextUtils.isEmpty(epic)) {
            textView5.setText(epic);
        }
        textView6.setText("Part Serial No : " + String.valueOf(oldPsl));
        if (!TextUtils.isEmpty(name)) {
            textView7.setText(name);
        }
        if (!TextUtils.isEmpty(currentRelativeName)) {
            textView8.setText(currentRelativeName);
        }
        textView9.setText("AC : " + String.valueOf(ac));
        textView10.setText("Part : " + String.valueOf(part));
        if (!TextUtils.isEmpty(correntEpic)) {
            textView11.setText(correntEpic);
        }
        textView12.setText("Part Serial No : " + String.valueOf(psl));
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMappingAdapter.this.resetElector(correntEpic, ac, part, psl, pos);
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMappingAdapter.this.verifyElector(correntEpic, iD, pos);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogAddProgny(final ElectorMappingListModel item, final int i) {
        this.releationCode = "";
        final Dialog dialog = new Dialog(this.context);
        dialog.setContentView(R.layout.add_progny);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        Button button3 = (Button) dialog.findViewById(R.id.btnsubmit);
        final Button button4 = (Button) dialog.findViewById(R.id.btncancel);
        final EditText editText = (EditText) dialog.findViewById(R.id.search);
        final LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.lv_verify_details);
        final TextView textView = (TextView) dialog.findViewById(R.id.tv_elector_name);
        final TextView textView2 = (TextView) dialog.findViewById(R.id.tv_elector_age);
        final TextView textView3 = (TextView) dialog.findViewById(R.id.tv_elector_gender);
        final TextView textView4 = (TextView) dialog.findViewById(R.id.tv_elector_relation_type);
        final TextView textView5 = (TextView) dialog.findViewById(R.id.tv_elector_relative_fullname);
        final Spinner spinner = (Spinner) dialog.findViewById(R.id.sp_elector_relative);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.context, R.layout.blo_spinner_dropdown, this.relationNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ElectorMappingAdapter electorMappingAdapter = ElectorMappingAdapter.this;
                electorMappingAdapter.releationCode = electorMappingAdapter.relationCodeList.get(position);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showDialogAddProgny$1(editText, item, textView, textView2, textView3, textView4, textView5, linearLayout, button4, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showDialogAddProgny$2(spinner, dialog, item, i, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogAddProgny$1(final EditText editText, final ElectorMappingListModel electorMappingListModel, final TextView textView, final TextView textView2, final TextView textView3, final TextView textView4, final TextView textView5, final LinearLayout linearLayout, final Button button, View view) {
        new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showDialogAddProgny$0(editText, electorMappingListModel, textView, textView2, textView3, textView4, textView5, linearLayout, button);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogAddProgny$0(EditText editText, ElectorMappingListModel electorMappingListModel, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, Button button) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            checkEpicNumber(electorMappingListModel.getId(), editText.getText().toString(), textView, textView2, textView3, textView4, textView5, linearLayout, button);
        } else {
            Toast.makeText(this.context, "Please enter EPIC number", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogAddProgny$2(Spinner spinner, Dialog dialog, ElectorMappingListModel electorMappingListModel, int i, View view) {
        if (spinner.getSelectedItem().toString().equalsIgnoreCase(this.selectRelationType)) {
            Toast.makeText(this.context, "Please select relation Type", 0).show();
        } else if (TextUtils.isEmpty(this.releationCode)) {
            Toast.makeText(this.context, "Please select relation Type", 0).show();
        } else {
            dialog.dismiss();
            addProgeny(electorMappingListModel.getId(), this.pestatecd, this.prvsAcNo, this.prvsPartNumber, this.prvsSLNo, this.epicNumber, this.releationCode, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogViewProgny(final int i) {
        final Dialog dialog = new Dialog(this.context);
        dialog.setContentView(R.layout.view_progny);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ((ListView) dialog.findViewById(R.id.viewProgenyListView)).setAdapter((ListAdapter) new DialogListAdapter(this.context, this.progenyEpicList, this.progenyEpicName, this.progenyEpicId, this.token, this.state, this.atkband, this.rtkband, i, new DialogListAdapter.onItemDeletedListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$$ExternalSyntheticLambda4
            @Override // in.gov.eci.bloapp.adapter.DialogListAdapter.onItemDeletedListener
            public final void onItemDeleted(int i2, int i3) {
                this.f$0.lambda$showDialogViewProgny$3(i, i2, i3);
            }
        }));
        dialog.show();
        ((Button) dialog.findViewById(R.id.btncancel)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogViewProgny$3(int i, int i2, int i3) {
        this.datalist.get(i).setProgencyCount(i3);
        notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewProgeny(String currentEpic, final int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("currentEpic", currentEpic);
        this.service.getProgeny(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.14
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        Toast.makeText(ElectorMappingAdapter.this.context, new JSONObject(response.errorBody().string()).getString("message"), 1).show();
                        return;
                    }
                    if (!response.isSuccessful() || response.body() == null) {
                        return;
                    }
                    String json = ElectorMappingAdapter.this.gson.toJson(((JsonObject) response.body()).get("payload"));
                    try {
                        if (TextUtils.isEmpty(json)) {
                            Toast.makeText(ElectorMappingAdapter.this.context, response.message(), 1).show();
                        }
                        JSONArray jSONArray = new JSONArray(json);
                        ElectorMappingAdapter.this.progenyEpicList.clear();
                        ElectorMappingAdapter.this.progenyEpicId.clear();
                        ElectorMappingAdapter.this.progenyEpicName.clear();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            int iOptInt = jSONObject.optInt("id", 0);
                            String strOptString = jSONObject.optString("progenyEpicNo", null);
                            String strOptString2 = jSONObject.optString("progenyFullName", null);
                            if (TextUtils.isEmpty(strOptString2)) {
                                strOptString2 = "";
                            }
                            ElectorMappingAdapter.this.progenyEpicList.add(strOptString);
                            ElectorMappingAdapter.this.progenyEpicName.add(strOptString + "  " + strOptString2);
                            ElectorMappingAdapter.this.progenyEpicId.add(Integer.valueOf(iOptInt));
                        }
                        ElectorMappingAdapter.this.showDialogViewProgny(pos);
                    } catch (Exception e) {
                        Logger.d("Elector Mapping", e.toString());
                    }
                } catch (Exception e2) {
                    Logger.d("Elector Mapping", e2.toString());
                }
            }
        });
    }

    private void addProgeny(int id, String progenyStateCd, String progenyAcNo, String progenyPartNo, String progenyPartSerialNo, String progenyEpicNo, String progenyRelationType, final int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("ccode", Integer.valueOf(id));
        map2.put("progenyStateCd", progenyStateCd);
        map2.put("progenyAcNo", progenyAcNo);
        map2.put("progenyPartNo", progenyPartNo);
        map2.put("progenyPartSerialNo", progenyPartSerialNo);
        map2.put("progenyEpicNo", progenyEpicNo);
        map2.put("progenyRelationType", progenyRelationType);
        this.service.addProgency(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter.15
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        Toast.makeText(ElectorMappingAdapter.this.context, new JSONObject(response.errorBody().string()).getString("message"), 1).show();
                    } else {
                        ElectorMappingAdapter.this.datalist.get(pos).setProgencyCount(ElectorMappingAdapter.this.datalist.get(pos).getProgencyCount() + 1);
                        ElectorMappingAdapter.this.notifyItemChanged(pos);
                        Toast.makeText(ElectorMappingAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void checkEpicNumber(int id, String epic, TextView tv_elector_name, TextView tv_elector_age, TextView tv_elector_gender, TextView tv_elector_relation_type, TextView tv_elector_relative_fullname, LinearLayout lv_verify_details, Button btncancel) {
        CommomUtility commomUtility = new CommomUtility();
        HashMap map = new HashMap();
        map.put("epicNumber", epic);
        map.put("isActive", "Y");
        ((UserClient) ApiClient.getClient(this.context).create(UserClient.class)).getEpicForForm8(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass16(tv_elector_name, tv_elector_age, tv_elector_gender, tv_elector_relative_fullname, tv_elector_relation_type, lv_verify_details, btncancel, commomUtility));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonArray> {
        final /* synthetic */ Button val$btncancel;
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ LinearLayout val$lv_verify_details;
        final /* synthetic */ TextView val$tv_elector_age;
        final /* synthetic */ TextView val$tv_elector_gender;
        final /* synthetic */ TextView val$tv_elector_name;
        final /* synthetic */ TextView val$tv_elector_relation_type;
        final /* synthetic */ TextView val$tv_elector_relative_fullname;

        public void onFailure(Call<JsonArray> call, Throwable t) {
        }

        AnonymousClass16(final TextView val$tv_elector_name, final TextView val$tv_elector_age, final TextView val$tv_elector_gender, final TextView val$tv_elector_relative_fullname, final TextView val$tv_elector_relation_type, final LinearLayout val$lv_verify_details, final Button val$btncancel, final CommomUtility val$commonUtilClass) {
            this.val$tv_elector_name = val$tv_elector_name;
            this.val$tv_elector_age = val$tv_elector_age;
            this.val$tv_elector_gender = val$tv_elector_gender;
            this.val$tv_elector_relative_fullname = val$tv_elector_relative_fullname;
            this.val$tv_elector_relation_type = val$tv_elector_relation_type;
            this.val$lv_verify_details = val$lv_verify_details;
            this.val$btncancel = val$btncancel;
            this.val$commonUtilClass = val$commonUtilClass;
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.code() == 200 && response.body() != null) {
                JsonArray jsonArray = (JsonArray) response.body();
                if (!jsonArray.isEmpty()) {
                    JsonObject jsonObject = jsonArray.get(0).getAsJsonObject().get("content");
                    String str = "";
                    ElectorMappingAdapter.this.pestatecd = String.valueOf(jsonObject.get("stateCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ElectorMappingAdapter.this.prvsPartNumber = String.valueOf(jsonObject.get("partNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ElectorMappingAdapter.this.prvsAcNo = String.valueOf(jsonObject.get("acNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ElectorMappingAdapter.this.prvsSLNo = String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ElectorMappingAdapter.this.epicNumber = String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    String strReplace = String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    String strReplace2 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    String strReplace3 = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    String strReplace4 = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    String strReplace5 = String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    String strReplace6 = String.valueOf(jsonObject.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (strReplace3.equals("null")) {
                        return;
                    }
                    if (Integer.parseInt(strReplace3) > 40) {
                        ElectorMappingAdapter.this.showAlertDialog("Alert", "Age of the entered elector is greater than 40. To add progeny the age of the progeny elector should be less than or equal to 40.");
                        return;
                    }
                    if (strReplace5.equals("null")) {
                        strReplace5 = "";
                    }
                    if (strReplace4.equals("null")) {
                        strReplace4 = "";
                    } else {
                        if (strReplace4.equalsIgnoreCase("M")) {
                            strReplace4 = "Male";
                        }
                        if (strReplace4.equalsIgnoreCase("F")) {
                            strReplace4 = "Female";
                        }
                        if (strReplace4.equalsIgnoreCase("T")) {
                            strReplace4 = "Third gender";
                        }
                    }
                    if (strReplace.equals("null")) {
                        strReplace = "";
                    }
                    if (strReplace2.equals("null")) {
                        strReplace2 = "";
                    }
                    String str2 = strReplace + StringUtils.SPACE + strReplace2;
                    if (strReplace3.equals("null")) {
                        strReplace3 = "";
                    }
                    if (!strReplace6.equals("null")) {
                        if (strReplace6.equalsIgnoreCase("GMTH")) {
                            str = "Grand Mother";
                        } else if (strReplace6.equalsIgnoreCase("GFTH")) {
                            str = "Grand Father";
                        } else if (strReplace6.equalsIgnoreCase("MTHR")) {
                            str = "Mother";
                        } else if (strReplace6.equalsIgnoreCase("FTHR") || strReplace6.equalsIgnoreCase("F") || strReplace6.equalsIgnoreCase("FATHER")) {
                            str = "Father";
                        } else if (strReplace6.equals("HSBN") || strReplace6.equals("H") || strReplace6.equalsIgnoreCase("HUSBAND")) {
                            str = "Husband";
                        } else {
                            str = strReplace6.equalsIgnoreCase("OTHR") ? "Other" : strReplace6;
                        }
                    }
                    this.val$tv_elector_name.setText(str2);
                    this.val$tv_elector_age.setText(strReplace3);
                    this.val$tv_elector_gender.setText(strReplace4);
                    this.val$tv_elector_relative_fullname.setText(strReplace5);
                    this.val$tv_elector_relation_type.setText(str);
                    this.val$lv_verify_details.setVisibility(0);
                    this.val$btncancel.setVisibility(8);
                    return;
                }
                Toast.makeText(ElectorMappingAdapter.this.context, "Please check EPIC number", 0).show();
                this.val$lv_verify_details.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                this.val$commonUtilClass.showMessageOK(ElectorMappingAdapter.this.context, "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$16$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            } else if (response.code() == 400) {
                ElectorMappingAdapter.this.showAlertDialog("Alert", "Bad Request");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorMappingAdapter.this.context).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorMappingAdapter.this.context).setLocaleBool(false);
            ElectorMappingAdapter.this.context.startActivity(new Intent(ElectorMappingAdapter.this.context, (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog(String alertText, String message) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(this.context.getResources().getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ElectorMappingAdapter$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }
}
