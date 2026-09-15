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
import in.gov.eci.bloapp.entity.FormDataForBloModificationVariables;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormDataFoBloModificationAdapter extends RecyclerView.Adapter<holder> {
    ArrayList<FormDataForBloModificationVariables> al;
    private Context context;
    ArrayList<FormDataForBloModificationVariables> filteredAl;

    public FormDataFoBloModificationAdapter(ArrayList<FormDataForBloModificationVariables> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList<>(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_form_data_modified_by_blo, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        String str;
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.partNo.setText(this.al.get(i).getPartSerialNo());
        TextView textView = holder2.documentSubmitted;
        if (this.al.get(i).getDocumentUploadedFlg().equals("Y")) {
            str = "Yes";
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("N")) {
            str = "No";
        } else {
            str = this.al.get(i).getDocumentUploadedFlg().equals("D") ? "Partial" : "NA";
        }
        textView.setText(str);
        holder2.electorName.setText(this.al.get(i).getElectorName());
        if (this.al.get(i).getDocumentUploadedFlg().equals("Y")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DBF7C4"));
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("N")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#f29ea3"));
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("D")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DAF0F7"));
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.FormDataFoBloModificationAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(FormDataFoBloModificationAdapter.this.context, (Class<?>) FormDataForBloModificationPage1.class);
                intent.putExtra("dob", FormDataFoBloModificationAdapter.this.al.get(i).getDobVerified());
                intent.putExtra("epic", FormDataFoBloModificationAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("epicId", FormDataFoBloModificationAdapter.this.al.get(i).getEpicId());
                intent.putExtra("acNo", FormDataFoBloModificationAdapter.this.al.get(i).getAcNo());
                intent.putExtra("partNo", FormDataFoBloModificationAdapter.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", FormDataFoBloModificationAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", FormDataFoBloModificationAdapter.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", FormDataFoBloModificationAdapter.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", FormDataFoBloModificationAdapter.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", FormDataFoBloModificationAdapter.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", FormDataFoBloModificationAdapter.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", FormDataFoBloModificationAdapter.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", FormDataFoBloModificationAdapter.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", FormDataFoBloModificationAdapter.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", FormDataFoBloModificationAdapter.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", FormDataFoBloModificationAdapter.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", FormDataFoBloModificationAdapter.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", FormDataFoBloModificationAdapter.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", FormDataFoBloModificationAdapter.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", FormDataFoBloModificationAdapter.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", FormDataFoBloModificationAdapter.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", FormDataFoBloModificationAdapter.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", FormDataFoBloModificationAdapter.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", FormDataFoBloModificationAdapter.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", FormDataFoBloModificationAdapter.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", FormDataFoBloModificationAdapter.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", FormDataFoBloModificationAdapter.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", FormDataFoBloModificationAdapter.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", FormDataFoBloModificationAdapter.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", FormDataFoBloModificationAdapter.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", FormDataFoBloModificationAdapter.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", FormDataFoBloModificationAdapter.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", FormDataFoBloModificationAdapter.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", FormDataFoBloModificationAdapter.this.al.get(i).getElectorName());
                intent.putExtra("bloOverridenFlg", FormDataFoBloModificationAdapter.this.al.get(i).getBloOverridenFlg());
                intent.putExtra("moldAcNo", FormDataFoBloModificationAdapter.this.al.get(i).getMoldAcNo());
                intent.putExtra("moldPartNo", FormDataFoBloModificationAdapter.this.al.get(i).getMoldPartNo());
                intent.putExtra("moldPslNo", FormDataFoBloModificationAdapter.this.al.get(i).getMoldPslNo());
                intent.putExtra("foldAcNo", FormDataFoBloModificationAdapter.this.al.get(i).getFoldAcNo());
                intent.putExtra("foldPartNo", FormDataFoBloModificationAdapter.this.al.get(i).getFoldPartNo());
                intent.putExtra("foldPslNo", FormDataFoBloModificationAdapter.this.al.get(i).getFoldPslNo());
                intent.putExtra("relationProofDocUrlPg1", FormDataFoBloModificationAdapter.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", FormDataFoBloModificationAdapter.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", FormDataFoBloModificationAdapter.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", FormDataFoBloModificationAdapter.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", FormDataFoBloModificationAdapter.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", FormDataFoBloModificationAdapter.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", FormDataFoBloModificationAdapter.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", FormDataFoBloModificationAdapter.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", FormDataFoBloModificationAdapter.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", FormDataFoBloModificationAdapter.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("relativeEpic", FormDataFoBloModificationAdapter.this.al.get(i).getRelativeEpic());
                intent.putExtra("isThisYouRel", FormDataFoBloModificationAdapter.this.al.get(i).getIsThisYouRel());
                intent.putExtra("isThisYou", FormDataFoBloModificationAdapter.this.al.get(i).getIsThisYou());
                intent.putExtra("relationOldStateCd", FormDataFoBloModificationAdapter.this.al.get(i).getRelationOldStateCd());
                intent.putExtra("erollAge", FormDataFoBloModificationAdapter.this.al.get(i).getErollAge());
                FormDataFoBloModificationAdapter.this.context.startActivity(intent);
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
        TextView partNo;
        TextView serialNo;
        TextView state;
        TextView viewDetails;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.partNo = (TextView) itemView.findViewById(R.id.partNo);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.documentSubmitted = (TextView) itemView.findViewById(R.id.documentSubmitted);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
        }
    }

    public void fun(ArrayList<FormDataForBloModificationVariables> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
