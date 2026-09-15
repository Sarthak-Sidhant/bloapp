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
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormDataFoBloModificationAdapterBH extends RecyclerView.Adapter<holder> {
    ArrayList<FormDataForBloModificationVariables> al;
    private Context context;
    ArrayList<FormDataForBloModificationVariables> filteredAl;

    public FormDataFoBloModificationAdapterBH(ArrayList<FormDataForBloModificationVariables> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList<>(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_form_data_modified_by_blo_bh, viewGroup, false));
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
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.FormDataFoBloModificationAdapterBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(FormDataFoBloModificationAdapterBH.this.context, (Class<?>) FormDataForBloModificationPage1BH.class);
                intent.putExtra("dob", FormDataFoBloModificationAdapterBH.this.al.get(i).getDobVerified());
                intent.putExtra("epic", FormDataFoBloModificationAdapterBH.this.al.get(i).getEpicNo());
                intent.putExtra("acNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getAcNo());
                intent.putExtra("partNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", FormDataFoBloModificationAdapterBH.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", FormDataFoBloModificationAdapterBH.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", FormDataFoBloModificationAdapterBH.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", FormDataFoBloModificationAdapterBH.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", FormDataFoBloModificationAdapterBH.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", FormDataFoBloModificationAdapterBH.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", FormDataFoBloModificationAdapterBH.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", FormDataFoBloModificationAdapterBH.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", FormDataFoBloModificationAdapterBH.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", FormDataFoBloModificationAdapterBH.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", FormDataFoBloModificationAdapterBH.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", FormDataFoBloModificationAdapterBH.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", FormDataFoBloModificationAdapterBH.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", FormDataFoBloModificationAdapterBH.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", FormDataFoBloModificationAdapterBH.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", FormDataFoBloModificationAdapterBH.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", FormDataFoBloModificationAdapterBH.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", FormDataFoBloModificationAdapterBH.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", FormDataFoBloModificationAdapterBH.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", FormDataFoBloModificationAdapterBH.this.al.get(i).getElectorName());
                intent.putExtra("bloOverridenFlg", FormDataFoBloModificationAdapterBH.this.al.get(i).getBloOverridenFlg());
                intent.putExtra("moldAcNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getMoldAcNo());
                intent.putExtra("moldPartNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getMoldPartNo());
                intent.putExtra("moldPslNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getMoldPslNo());
                intent.putExtra("foldAcNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getFoldAcNo());
                intent.putExtra("foldPartNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getFoldPartNo());
                intent.putExtra("foldPslNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getFoldPslNo());
                intent.putExtra("relationProofDocUrlPg1", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", FormDataFoBloModificationAdapterBH.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("relativeEpic", FormDataFoBloModificationAdapterBH.this.al.get(i).getRelativeEpic());
                FormDataFoBloModificationAdapterBH.this.context.startActivity(intent);
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
