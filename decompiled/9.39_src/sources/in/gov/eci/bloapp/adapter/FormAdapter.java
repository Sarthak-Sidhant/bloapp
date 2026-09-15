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
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormAdapter extends RecyclerView.Adapter<holder> {
    ArrayList<FormDataVariables> al;
    private Context context;
    ArrayList<FormDataVariables> filteredAl;

    public FormAdapter(ArrayList<FormDataVariables> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList<>(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_form_data, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.acName.setText(this.al.get(i).getAcNo());
        holder2.partNo.setText(this.al.get(i).getPartNo());
        holder2.serialNo.setText(this.al.get(i).getPartSerialNo());
        holder2.address.setText(this.al.get(i).getHouseNo());
        holder2.electorName.setText(this.al.get(i).getElectorName());
        if (this.al.get(i).getDocumentUploadedFlg().equals("Y")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DBF7C4"));
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("N")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#f29ea3"));
        } else if (this.al.get(i).getDocumentUploadedFlg().equals("D")) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DAF0F7"));
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.FormAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(FormAdapter.this.context, (Class<?>) FormDocuments.class);
                intent.putExtra("dob", FormAdapter.this.al.get(i).getDobVerified());
                intent.putExtra("epic", FormAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("epicId", FormAdapter.this.al.get(i).getEpicId());
                intent.putExtra("acNo", FormAdapter.this.al.get(i).getAcNo());
                intent.putExtra("partNo", FormAdapter.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", FormAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", FormAdapter.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", FormAdapter.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", FormAdapter.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", FormAdapter.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", FormAdapter.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", FormAdapter.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", FormAdapter.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", FormAdapter.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", FormAdapter.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", FormAdapter.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", FormAdapter.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", FormAdapter.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", FormAdapter.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", FormAdapter.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", FormAdapter.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", FormAdapter.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", FormAdapter.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", FormAdapter.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", FormAdapter.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", FormAdapter.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", FormAdapter.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", FormAdapter.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", FormAdapter.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", FormAdapter.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", FormAdapter.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", FormAdapter.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", FormAdapter.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", FormAdapter.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", FormAdapter.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", FormAdapter.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", FormAdapter.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", FormAdapter.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", FormAdapter.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", FormAdapter.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", FormAdapter.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", FormAdapter.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", FormAdapter.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", FormAdapter.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", FormAdapter.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", FormAdapter.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", FormAdapter.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", FormAdapter.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", FormAdapter.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", FormAdapter.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", FormAdapter.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", FormAdapter.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", FormAdapter.this.al.get(i).getElectorName());
                intent.putExtra("relationProofDocUrlPg1", FormAdapter.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", FormAdapter.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", FormAdapter.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", FormAdapter.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", FormAdapter.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", FormAdapter.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", FormAdapter.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", FormAdapter.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", FormAdapter.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", FormAdapter.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("relativeEpic", FormAdapter.this.al.get(i).getRelativeEpic());
                intent.putExtra("oldStateCd", FormAdapter.this.al.get(i).getOldStateCd());
                intent.putExtra("relationOldStateCd", FormAdapter.this.al.get(i).getRelationOldStateCd());
                intent.putExtra("isThisYouRel", FormAdapter.this.al.get(i).getIsThisYouRel());
                intent.putExtra("isThisYou", FormAdapter.this.al.get(i).getIsThisYou());
                intent.putExtra("erollAge", FormAdapter.this.al.get(i).getErollAge());
                FormAdapter.this.context.startActivity(intent);
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
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.serialNo = (TextView) itemView.findViewById(R.id.serialNo);
            this.partNo = (TextView) itemView.findViewById(R.id.partNo);
            this.acName = (TextView) itemView.findViewById(R.id.acName);
            this.state = (TextView) itemView.findViewById(R.id.state);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
        }
    }

    public void fun(ArrayList<FormDataVariables> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
