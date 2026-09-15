package in.gov.eci.bloapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SIROfflineAdapter extends RecyclerView.Adapter<SIRViewHolder> {
    Context context;
    List<String> dbFiles = new ArrayList();
    List<SpecialSurveyRevisionModel> list;
    SIRDatabaseHelper sirDatabaseHelper;

    public SIROfflineAdapter(Context context, List<SpecialSurveyRevisionModel> list) {
        this.context = context;
        this.list = list;
        this.sirDatabaseHelper = SIRDatabaseHelper.getDB(context);
    }

    public SIRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SIRViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sir_offline_list, parent, false));
    }

    public void onBindViewHolder(SIRViewHolder holder, final int position) {
        final SpecialSurveyRevisionModel specialSurveyRevisionModel = this.list.get(position);
        holder.epicnumber.setText(specialSurveyRevisionModel.getEpic_no());
        holder.serialno.setText(specialSurveyRevisionModel.getPart_serial_no());
        if (!TextUtils.isEmpty(specialSurveyRevisionModel.getComments())) {
            holder.formStatus.setText("Failed");
            holder.reason.setText(specialSurveyRevisionModel.getComments());
            holder.reasonlayout.setVisibility(0);
        } else {
            holder.formStatus.setText("Pending");
            holder.reasonlayout.setVisibility(8);
        }
        if (specialSurveyRevisionModel.getRequestStatusCode() == 200 || specialSurveyRevisionModel.getRequestStatusCode() == 510 || specialSurveyRevisionModel.getRequestStatusCode() == 401) {
            holder.lv_delete.setVisibility(8);
        } else {
            holder.lv_delete.setVisibility(0);
        }
        if (specialSurveyRevisionModel.getTabName().equalsIgnoreCase("fillTab")) {
            holder.cardView.setBackgroundColor(Color.parseColor("#FEB139"));
        } else if (specialSurveyRevisionModel.getTabName().equalsIgnoreCase("Citizen")) {
            holder.cardView.setBackgroundColor(Color.parseColor("#FF8C8C"));
        } else if (specialSurveyRevisionModel.getTabName().equalsIgnoreCase("Reverify")) {
            holder.cardView.setBackgroundColor(Color.parseColor("#DBF7C4"));
        } else if (specialSurveyRevisionModel.getTabName().equalsIgnoreCase("sentBack")) {
            holder.cardView.setBackgroundColor(Color.parseColor("#ADD8E6"));
        }
        holder.lv_delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.SIROfflineAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SIROfflineAdapter.this.showDialog2("Alert", "Are you sure to Delete?", specialSurveyRevisionModel.getEpic_id(), position);
            }
        });
    }

    public int getItemCount() {
        return this.list.size();
    }

    static class SIRViewHolder extends RecyclerView.ViewHolder {
        LinearLayout cardView;
        TextView epicnumber;
        TextView formStatus;
        LinearLayout lv_delete;
        TextView reason;
        LinearLayout reasonlayout;
        TextView serialno;
        LinearLayout statuslayout;

        public SIRViewHolder(View itemView) {
            super(itemView);
            this.epicnumber = (TextView) itemView.findViewById(R.id.epic_offline_sir);
            this.serialno = (TextView) itemView.findViewById(R.id.serialNo_offline_sir);
            this.cardView = (LinearLayout) itemView.findViewById(R.id.cardOfflineDetails);
            this.formStatus = (TextView) itemView.findViewById(R.id.form_status_offline_sir);
            this.reason = (TextView) itemView.findViewById(R.id.failure_reason_offline_sir);
            this.statuslayout = (LinearLayout) itemView.findViewById(R.id.lv_status);
            this.reasonlayout = (LinearLayout) itemView.findViewById(R.id.lv_reason);
            this.lv_delete = (LinearLayout) itemView.findViewById(R.id.lv_delete);
        }
    }

    public void deleteLocalFolder() {
        if (this.sirDatabaseHelper.SpecialRevisionDao().getAllFormsFromDB() == 0) {
            File file = new File(this.context.getExternalFilesDir(null) + "GARUDA");
            if (isFolderSafeToDelete(file, this.sirDatabaseHelper)) {
                deleteFolder(file);
                Logger.d("Delete Files", "File deleted successfully");
            }
        }
    }

    private boolean isFolderSafeToDelete(File folder, SIRDatabaseHelper db) {
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file : fileArrListFiles) {
                if (!this.dbFiles.contains(file.getAbsolutePath())) {
                    return false;
                }
            }
        }
        return true;
    }

    private void deleteFolder(File folder) {
        if (folder == null || !folder.exists()) {
            return;
        }
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog2(String alertText, String message, final Long item, final int position) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.SIROfflineAdapter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$0(item, position, dialogInterface, i);
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.SIROfflineAdapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$0(Long l, int i, DialogInterface dialogInterface, int i2) {
        this.sirDatabaseHelper.SpecialRevisionDao().deleteSpecialSurveyRevisionDetails(l);
        this.list.remove(i);
        notifyItemChanged(i);
        dialogInterface.dismiss();
    }
}
