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
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDocumentsBH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormAdapterBH extends RecyclerView.Adapter<holder> {
    ArrayList<FormDataVariables> al;
    private Context context;
    ArrayList<FormDataVariables> filteredAl;

    public FormAdapterBH(ArrayList<FormDataVariables> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList<>(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_form_data_bh, viewGroup, false));
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
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.FormAdapterBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(FormAdapterBH.this.context, (Class<?>) FormDocumentsBH.class);
                intent.putExtra("dob", FormAdapterBH.this.al.get(i).getDobVerified());
                intent.putExtra("epic", FormAdapterBH.this.al.get(i).getEpicNo());
                intent.putExtra("acNo", FormAdapterBH.this.al.get(i).getAcNo());
                intent.putExtra("partNo", FormAdapterBH.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", FormAdapterBH.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", FormAdapterBH.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", FormAdapterBH.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", FormAdapterBH.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", FormAdapterBH.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", FormAdapterBH.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", FormAdapterBH.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", FormAdapterBH.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", FormAdapterBH.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", FormAdapterBH.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", FormAdapterBH.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", FormAdapterBH.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", FormAdapterBH.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", FormAdapterBH.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", FormAdapterBH.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", FormAdapterBH.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", FormAdapterBH.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", FormAdapterBH.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", FormAdapterBH.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", FormAdapterBH.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", FormAdapterBH.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", FormAdapterBH.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", FormAdapterBH.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", FormAdapterBH.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", FormAdapterBH.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", FormAdapterBH.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", FormAdapterBH.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", FormAdapterBH.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", FormAdapterBH.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", FormAdapterBH.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", FormAdapterBH.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", FormAdapterBH.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", FormAdapterBH.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", FormAdapterBH.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", FormAdapterBH.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", FormAdapterBH.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", FormAdapterBH.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", FormAdapterBH.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", FormAdapterBH.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", FormAdapterBH.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", FormAdapterBH.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", FormAdapterBH.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", FormAdapterBH.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", FormAdapterBH.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", FormAdapterBH.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", FormAdapterBH.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", FormAdapterBH.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", FormAdapterBH.this.al.get(i).getElectorName());
                intent.putExtra("relationProofDocUrlPg1", FormAdapterBH.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", FormAdapterBH.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", FormAdapterBH.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", FormAdapterBH.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", FormAdapterBH.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", FormAdapterBH.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", FormAdapterBH.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", FormAdapterBH.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", FormAdapterBH.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", FormAdapterBH.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("relativeEpic", FormAdapterBH.this.al.get(i).getRelativeEpic());
                FormAdapterBH.this.context.startActivity(intent);
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
