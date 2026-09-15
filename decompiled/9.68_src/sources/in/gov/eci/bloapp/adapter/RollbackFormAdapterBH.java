package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.entity.RollbackFormVariables;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage1BH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class RollbackFormAdapterBH extends RecyclerView.Adapter<holder> {
    ArrayList<RollbackFormVariables> al;
    private Context context;
    ArrayList<RollbackFormVariables> filteredAl;

    public RollbackFormAdapterBH(ArrayList<RollbackFormVariables> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList<>(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_rollback_form_bh, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.partNo.setText(this.al.get(i).getPartNo());
        holder2.electorName.setText(this.al.get(i).getElectorName());
        holder2.remarks.setText(this.al.get(i).getBackToBloRemarks());
        if (this.al.get(i).getDocumentUploadedFlg().equals("Y")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DBF7C4"));
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("N")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#f29ea3"));
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("D")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DAF0F7"));
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.RollbackFormAdapterBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(RollbackFormAdapterBH.this.context, (Class<?>) RollbackFormsPage1BH.class);
                intent.putExtra("dob", RollbackFormAdapterBH.this.al.get(i).getDobVerified());
                intent.putExtra("epic", RollbackFormAdapterBH.this.al.get(i).getEpicNo());
                intent.putExtra("acNo", RollbackFormAdapterBH.this.al.get(i).getAcNo());
                intent.putExtra("partNo", RollbackFormAdapterBH.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", RollbackFormAdapterBH.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", RollbackFormAdapterBH.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", RollbackFormAdapterBH.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", RollbackFormAdapterBH.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", RollbackFormAdapterBH.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", RollbackFormAdapterBH.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", RollbackFormAdapterBH.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", RollbackFormAdapterBH.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", RollbackFormAdapterBH.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", RollbackFormAdapterBH.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", RollbackFormAdapterBH.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", RollbackFormAdapterBH.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", RollbackFormAdapterBH.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", RollbackFormAdapterBH.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", RollbackFormAdapterBH.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", RollbackFormAdapterBH.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", RollbackFormAdapterBH.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", RollbackFormAdapterBH.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", RollbackFormAdapterBH.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", RollbackFormAdapterBH.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", RollbackFormAdapterBH.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", RollbackFormAdapterBH.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", RollbackFormAdapterBH.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", RollbackFormAdapterBH.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", RollbackFormAdapterBH.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", RollbackFormAdapterBH.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", RollbackFormAdapterBH.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", RollbackFormAdapterBH.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", RollbackFormAdapterBH.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", RollbackFormAdapterBH.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", RollbackFormAdapterBH.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", RollbackFormAdapterBH.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", RollbackFormAdapterBH.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", RollbackFormAdapterBH.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", RollbackFormAdapterBH.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", RollbackFormAdapterBH.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", RollbackFormAdapterBH.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", RollbackFormAdapterBH.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", RollbackFormAdapterBH.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", RollbackFormAdapterBH.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", RollbackFormAdapterBH.this.al.get(i).getElectorName());
                intent.putExtra("bloOverridenFlg", RollbackFormAdapterBH.this.al.get(i).getBloOverridenFlg());
                intent.putExtra("foldAcNo", RollbackFormAdapterBH.this.al.get(i).getFoldAcNo());
                intent.putExtra("foldPartNo", RollbackFormAdapterBH.this.al.get(i).getFoldPartNo());
                intent.putExtra("foldPslNo", RollbackFormAdapterBH.this.al.get(i).getFoldPslNo());
                intent.putExtra("moldAcNo", RollbackFormAdapterBH.this.al.get(i).getMoldAcNo());
                intent.putExtra("moldPartNo", RollbackFormAdapterBH.this.al.get(i).getMoldPartNo());
                intent.putExtra("moldPslNo", RollbackFormAdapterBH.this.al.get(i).getMoldPslNo());
                intent.putExtra("backToBlo", RollbackFormAdapterBH.this.al.get(i).getBackToBlo());
                intent.putExtra("backToBloRemarks", RollbackFormAdapterBH.this.al.get(i).getBackToBloRemarks());
                intent.putExtra("relationProofDocUrlPg1", RollbackFormAdapterBH.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", RollbackFormAdapterBH.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", RollbackFormAdapterBH.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", RollbackFormAdapterBH.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", RollbackFormAdapterBH.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", RollbackFormAdapterBH.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", RollbackFormAdapterBH.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", RollbackFormAdapterBH.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", RollbackFormAdapterBH.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", RollbackFormAdapterBH.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("relativeEpic", RollbackFormAdapterBH.this.al.get(i).getRelativeEpic());
                RollbackFormAdapterBH.this.context.startActivity(intent);
            }
        });
        if (SharedPref.getInstance(this.context.getApplicationContext()).getAlreadyFilledFormSentBackMarkUnButton().equalsIgnoreCase("Y")) {
            holder2.markUncollectable.setVisibility(0);
        } else {
            holder2.markUncollectable.setVisibility(8);
        }
        holder2.markUncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.RollbackFormAdapterBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(RollbackFormAdapterBH.this.context, (Class<?>) UncollectableSIRBH.class);
                intent.putExtra("epic", RollbackFormAdapterBH.this.al.get(i).getEpicNo());
                intent.putExtra("psl", RollbackFormAdapterBH.this.al.get(i).getPartSerialNo());
                intent.putExtra("flag", "RE");
                RollbackFormAdapterBH.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView acName;
        TextView address;
        LinearLayout cardViewLL;
        TextView documentSubmitted;
        TextView electorName;
        TextView epic;
        TextView markUncollectable;
        TextView partNo;
        TextView remarks;
        TextView serialNo;
        TextView state;
        TextView viewDetails;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.partNo = (TextView) itemView.findViewById(R.id.partNo);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.remarks = (TextView) itemView.findViewById(R.id.remarks);
            this.markUncollectable = (TextView) itemView.findViewById(R.id.markUncollectable);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
        }
    }

    public void fun(ArrayList<RollbackFormVariables> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
