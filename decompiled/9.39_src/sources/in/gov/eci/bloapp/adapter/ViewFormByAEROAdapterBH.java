package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.entity.ViewFormByAEROVariables;
import in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAEROPage1BH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ViewFormByAEROAdapterBH extends RecyclerView.Adapter<holder> {
    ArrayList<ViewFormByAEROVariables> al;
    private Context context;
    ArrayList<ViewFormByAEROVariables> filteredAl = this.filteredAl;
    ArrayList<ViewFormByAEROVariables> filteredAl = this.filteredAl;

    public ViewFormByAEROAdapterBH(ArrayList<ViewFormByAEROVariables> al, Context context) {
        this.al = al;
        this.context = context;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_view_form_by_aero_bh, viewGroup, false));
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
        holder2.modifiedBy.setText(this.al.get(i).getModifiedBy().toUpperCase());
        Log.d("Test : ", this.al.get(i).getModifiedBy());
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ViewFormByAEROAdapterBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(ViewFormByAEROAdapterBH.this.context, (Class<?>) ViewFormByAEROPage1BH.class);
                intent.putExtra("dob", ViewFormByAEROAdapterBH.this.al.get(i).getDobVerified());
                intent.putExtra("epic", ViewFormByAEROAdapterBH.this.al.get(i).getEpicNo());
                intent.putExtra("acNo", ViewFormByAEROAdapterBH.this.al.get(i).getAcNo());
                intent.putExtra("partNo", ViewFormByAEROAdapterBH.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", ViewFormByAEROAdapterBH.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", ViewFormByAEROAdapterBH.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", ViewFormByAEROAdapterBH.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", ViewFormByAEROAdapterBH.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", ViewFormByAEROAdapterBH.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", ViewFormByAEROAdapterBH.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", ViewFormByAEROAdapterBH.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", ViewFormByAEROAdapterBH.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", ViewFormByAEROAdapterBH.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", ViewFormByAEROAdapterBH.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", ViewFormByAEROAdapterBH.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", ViewFormByAEROAdapterBH.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", ViewFormByAEROAdapterBH.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", ViewFormByAEROAdapterBH.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", ViewFormByAEROAdapterBH.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", ViewFormByAEROAdapterBH.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", ViewFormByAEROAdapterBH.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", ViewFormByAEROAdapterBH.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", ViewFormByAEROAdapterBH.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", ViewFormByAEROAdapterBH.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", ViewFormByAEROAdapterBH.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", ViewFormByAEROAdapterBH.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", ViewFormByAEROAdapterBH.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", ViewFormByAEROAdapterBH.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", ViewFormByAEROAdapterBH.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", ViewFormByAEROAdapterBH.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", ViewFormByAEROAdapterBH.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", ViewFormByAEROAdapterBH.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", ViewFormByAEROAdapterBH.this.al.get(i).getElectorName());
                intent.putExtra("bloOverridenFlg", ViewFormByAEROAdapterBH.this.al.get(i).getBloOverridenFlg());
                intent.putExtra("moldAcNo", ViewFormByAEROAdapterBH.this.al.get(i).getMoldAcNo());
                intent.putExtra("moldPartNo", ViewFormByAEROAdapterBH.this.al.get(i).getMoldPartNo());
                intent.putExtra("moldPslNo", ViewFormByAEROAdapterBH.this.al.get(i).getMoldPslNo());
                intent.putExtra("foldAcNo", ViewFormByAEROAdapterBH.this.al.get(i).getFoldAcNo());
                intent.putExtra("foldPartNo", ViewFormByAEROAdapterBH.this.al.get(i).getFoldPartNo());
                intent.putExtra("foldPslNo", ViewFormByAEROAdapterBH.this.al.get(i).getFoldPslNo());
                intent.putExtra("relationProofDocUrlPg1", ViewFormByAEROAdapterBH.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", ViewFormByAEROAdapterBH.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", ViewFormByAEROAdapterBH.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", ViewFormByAEROAdapterBH.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", ViewFormByAEROAdapterBH.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", ViewFormByAEROAdapterBH.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", ViewFormByAEROAdapterBH.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", ViewFormByAEROAdapterBH.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", ViewFormByAEROAdapterBH.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", ViewFormByAEROAdapterBH.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("modifiedBy", ViewFormByAEROAdapterBH.this.al.get(i).getModifiedBy());
                intent.putExtra("relativeEpic", ViewFormByAEROAdapterBH.this.al.get(i).getRelativeEpic());
                ViewFormByAEROAdapterBH.this.context.startActivity(intent);
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
        TextView modifiedBy;
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
            this.modifiedBy = (TextView) itemView.findViewById(R.id.modifiedBy);
        }
    }

    public void fun(ArrayList<ViewFormByAEROVariables> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
