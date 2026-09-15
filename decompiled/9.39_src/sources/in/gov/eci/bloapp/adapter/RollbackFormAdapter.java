package in.gov.eci.bloapp.adapter;

import android.app.Activity;
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
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.RollbackFormsPage1;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class RollbackFormAdapter extends RecyclerView.Adapter<holder> {
    ArrayList<RollbackFormVariables> al;
    private Context context;
    ArrayList<RollbackFormVariables> filteredAl;

    public RollbackFormAdapter(ArrayList<RollbackFormVariables> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList<>(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_rollback_form, viewGroup, false));
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
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.RollbackFormAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(RollbackFormAdapter.this.context, (Class<?>) RollbackFormsPage1.class);
                intent.putExtra("dob", RollbackFormAdapter.this.al.get(i).getDobVerified());
                intent.putExtra("epic", RollbackFormAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("epicId", RollbackFormAdapter.this.al.get(i).getEpicId());
                intent.putExtra("acNo", RollbackFormAdapter.this.al.get(i).getAcNo());
                intent.putExtra("partNo", RollbackFormAdapter.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", RollbackFormAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", RollbackFormAdapter.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", RollbackFormAdapter.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", RollbackFormAdapter.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", RollbackFormAdapter.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", RollbackFormAdapter.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", RollbackFormAdapter.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", RollbackFormAdapter.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", RollbackFormAdapter.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", RollbackFormAdapter.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", RollbackFormAdapter.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", RollbackFormAdapter.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", RollbackFormAdapter.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", RollbackFormAdapter.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", RollbackFormAdapter.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", RollbackFormAdapter.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", RollbackFormAdapter.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", RollbackFormAdapter.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", RollbackFormAdapter.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", RollbackFormAdapter.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", RollbackFormAdapter.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", RollbackFormAdapter.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", RollbackFormAdapter.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", RollbackFormAdapter.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", RollbackFormAdapter.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", RollbackFormAdapter.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", RollbackFormAdapter.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", RollbackFormAdapter.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", RollbackFormAdapter.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", RollbackFormAdapter.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", RollbackFormAdapter.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", RollbackFormAdapter.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", RollbackFormAdapter.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", RollbackFormAdapter.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", RollbackFormAdapter.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", RollbackFormAdapter.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", RollbackFormAdapter.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", RollbackFormAdapter.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", RollbackFormAdapter.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", RollbackFormAdapter.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", RollbackFormAdapter.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", RollbackFormAdapter.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", RollbackFormAdapter.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", RollbackFormAdapter.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", RollbackFormAdapter.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", RollbackFormAdapter.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", RollbackFormAdapter.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", RollbackFormAdapter.this.al.get(i).getElectorName());
                intent.putExtra("bloOverridenFlg", RollbackFormAdapter.this.al.get(i).getBloOverridenFlg());
                intent.putExtra("foldAcNo", RollbackFormAdapter.this.al.get(i).getFoldAcNo());
                intent.putExtra("foldPartNo", RollbackFormAdapter.this.al.get(i).getFoldPartNo());
                intent.putExtra("foldPslNo", RollbackFormAdapter.this.al.get(i).getFoldPslNo());
                intent.putExtra("moldAcNo", RollbackFormAdapter.this.al.get(i).getMoldAcNo());
                intent.putExtra("moldPartNo", RollbackFormAdapter.this.al.get(i).getMoldPartNo());
                intent.putExtra("moldPslNo", RollbackFormAdapter.this.al.get(i).getMoldPslNo());
                intent.putExtra("backToBlo", RollbackFormAdapter.this.al.get(i).getBackToBlo());
                intent.putExtra("backToBloRemarks", RollbackFormAdapter.this.al.get(i).getBackToBloRemarks());
                intent.putExtra("relationProofDocUrlPg1", RollbackFormAdapter.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", RollbackFormAdapter.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", RollbackFormAdapter.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", RollbackFormAdapter.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", RollbackFormAdapter.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", RollbackFormAdapter.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", RollbackFormAdapter.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", RollbackFormAdapter.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", RollbackFormAdapter.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", RollbackFormAdapter.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("relativeEpic", RollbackFormAdapter.this.al.get(i).getRelativeEpic());
                intent.putExtra("oldStateCd", RollbackFormAdapter.this.al.get(i).getOldStateCd());
                intent.putExtra("relationOldStateCd", RollbackFormAdapter.this.al.get(i).getRelationOldStateCd());
                intent.putExtra("isThisYouRel", RollbackFormAdapter.this.al.get(i).getIsThisYouRel());
                intent.putExtra("isThisYou", RollbackFormAdapter.this.al.get(i).getIsThisYou());
                intent.putExtra("erollAge", RollbackFormAdapter.this.al.get(i).getErollAge());
                RollbackFormAdapter.this.context.startActivity(intent);
            }
        });
        if (SharedPref.getInstance(this.context.getApplicationContext()).getAlreadyFilledFormSentBackMarkUnButton().equalsIgnoreCase("Y")) {
            holder2.markUncollectable.setVisibility(0);
        } else {
            holder2.markUncollectable.setVisibility(8);
        }
        holder2.markUncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.RollbackFormAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(RollbackFormAdapter.this.context, (Class<?>) UncollectableSIR.class);
                intent.putExtra("epic", RollbackFormAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("psl", RollbackFormAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("flag", "RE");
                intent.putExtra("epicId", RollbackFormAdapter.this.al.get(i).getEpicId());
                RollbackFormAdapter.this.context.startActivity(intent);
                ((Activity) RollbackFormAdapter.this.context).finish();
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
