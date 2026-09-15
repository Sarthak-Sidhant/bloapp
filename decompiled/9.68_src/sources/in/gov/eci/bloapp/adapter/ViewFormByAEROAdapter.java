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
import in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ViewFormByAEROAdapter extends RecyclerView.Adapter<holder> {
    ArrayList<ViewFormByAEROVariables> al;
    private Context context;
    ArrayList<ViewFormByAEROVariables> filteredAl = this.filteredAl;
    ArrayList<ViewFormByAEROVariables> filteredAl = this.filteredAl;

    public ViewFormByAEROAdapter(ArrayList<ViewFormByAEROVariables> al, Context context) {
        this.al = al;
        this.context = context;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_view_form_by_aero, viewGroup, false));
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
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ViewFormByAEROAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(ViewFormByAEROAdapter.this.context, (Class<?>) ViewFormByAEROPage1.class);
                intent.putExtra("dob", ViewFormByAEROAdapter.this.al.get(i).getDobVerified());
                intent.putExtra("epic", ViewFormByAEROAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("acNo", ViewFormByAEROAdapter.this.al.get(i).getAcNo());
                intent.putExtra("partNo", ViewFormByAEROAdapter.this.al.get(i).getPartNo());
                intent.putExtra("serialNo", ViewFormByAEROAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("houseNo", ViewFormByAEROAdapter.this.al.get(i).getHouseNo());
                intent.putExtra("aadharNo", ViewFormByAEROAdapter.this.al.get(i).getAadharNo());
                intent.putExtra("mobileNo", ViewFormByAEROAdapter.this.al.get(i).getMobileNo());
                intent.putExtra("fatherName", ViewFormByAEROAdapter.this.al.get(i).getFathersOrGuardianName());
                intent.putExtra("fatherEpic", ViewFormByAEROAdapter.this.al.get(i).getFathersOrGuardianEpicNo());
                intent.putExtra("motherName", ViewFormByAEROAdapter.this.al.get(i).getMothersName());
                intent.putExtra("motherEpic", ViewFormByAEROAdapter.this.al.get(i).getMothersEpicNo());
                intent.putExtra("spouseName", ViewFormByAEROAdapter.this.al.get(i).getSpouseName());
                intent.putExtra("spouseEpic", ViewFormByAEROAdapter.this.al.get(i).getSpouseEpicNo());
                intent.putExtra("photoUrl", ViewFormByAEROAdapter.this.al.get(i).getPhotoUrl());
                intent.putExtra("srFormPage1Url", ViewFormByAEROAdapter.this.al.get(i).getSrFormPage1Url());
                intent.putExtra("srFormPage2Url", ViewFormByAEROAdapter.this.al.get(i).getSrFormPage2Url());
                intent.putExtra("citizenshipType", ViewFormByAEROAdapter.this.al.get(i).getCitizenshipType());
                intent.putExtra("oldAcNo", ViewFormByAEROAdapter.this.al.get(i).getOldAcNo());
                intent.putExtra("oldPartNo", ViewFormByAEROAdapter.this.al.get(i).getOldPartNo());
                intent.putExtra("oldPslNo", ViewFormByAEROAdapter.this.al.get(i).getOldPslNo());
                intent.putExtra("list8Doc", ViewFormByAEROAdapter.this.al.get(i).getList8Doc());
                intent.putExtra("preRevisionVoterFlg", ViewFormByAEROAdapter.this.al.get(i).getPreRevisionVoterFlg());
                intent.putExtra("preRevisionVoterDocUrl", ViewFormByAEROAdapter.this.al.get(i).getPreRevisionVoterDocUrl());
                intent.putExtra("peRevisionVoterDocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getPreRevisionVoterDocUrlPg2());
                intent.putExtra("list6Doc", ViewFormByAEROAdapter.this.al.get(i).getList6Doc());
                intent.putExtra("list6DocUrl", ViewFormByAEROAdapter.this.al.get(i).getList6DocUrl());
                intent.putExtra("list6DocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getList6docUrlPg2());
                intent.putExtra("list7Doc", ViewFormByAEROAdapter.this.al.get(i).getList7Doc());
                intent.putExtra("list7DocUrl", ViewFormByAEROAdapter.this.al.get(i).getList7DocUrl());
                intent.putExtra("list7DocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getList7docUrlPg2());
                intent.putExtra("list1Doc", ViewFormByAEROAdapter.this.al.get(i).getList1Doc());
                intent.putExtra("list1DocUrl", ViewFormByAEROAdapter.this.al.get(i).getList1DocUrl());
                intent.putExtra("list1DocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getList1docUrlPg2());
                intent.putExtra("list3Doc", ViewFormByAEROAdapter.this.al.get(i).getList3Doc());
                intent.putExtra("list3DocUrl", ViewFormByAEROAdapter.this.al.get(i).getList3DocUrl());
                intent.putExtra("list3DocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getList3docUrlPg2());
                intent.putExtra("list4Doc", ViewFormByAEROAdapter.this.al.get(i).getList4Doc());
                intent.putExtra("list4DocUrl", ViewFormByAEROAdapter.this.al.get(i).getList4DocUrl());
                intent.putExtra("list4DocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getList4docUrlPg2());
                intent.putExtra("list5Doc", ViewFormByAEROAdapter.this.al.get(i).getList5Doc());
                intent.putExtra("list5DocUrl", ViewFormByAEROAdapter.this.al.get(i).getList5DocUrl());
                intent.putExtra("list5DocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getList5docUrlPg2());
                intent.putExtra("list5DocUrlPg3", ViewFormByAEROAdapter.this.al.get(i).getList5docUrlPg3());
                intent.putExtra("fathersNationality", ViewFormByAEROAdapter.this.al.get(i).getFathersNationality());
                intent.putExtra("mothersNationality", ViewFormByAEROAdapter.this.al.get(i).getMothersNationality());
                intent.putExtra("createdBy", ViewFormByAEROAdapter.this.al.get(i).getCreatedBy());
                intent.putExtra("citizenshipTypeCat", ViewFormByAEROAdapter.this.al.get(i).getCitizenshipTypeCat());
                intent.putExtra("documentUploadedFlg", ViewFormByAEROAdapter.this.al.get(i).getDocumentUploadedFlg());
                intent.putExtra("annexureCUrl", ViewFormByAEROAdapter.this.al.get(i).getAnnexureCUrl());
                intent.putExtra("surveyChannel", ViewFormByAEROAdapter.this.al.get(i).getSurveyChannel());
                intent.putExtra("electorName", ViewFormByAEROAdapter.this.al.get(i).getElectorName());
                intent.putExtra("bloOverridenFlg", ViewFormByAEROAdapter.this.al.get(i).getBloOverridenFlg());
                intent.putExtra("moldAcNo", ViewFormByAEROAdapter.this.al.get(i).getMoldAcNo());
                intent.putExtra("moldPartNo", ViewFormByAEROAdapter.this.al.get(i).getMoldPartNo());
                intent.putExtra("moldPslNo", ViewFormByAEROAdapter.this.al.get(i).getMoldPslNo());
                intent.putExtra("foldAcNo", ViewFormByAEROAdapter.this.al.get(i).getFoldAcNo());
                intent.putExtra("foldPartNo", ViewFormByAEROAdapter.this.al.get(i).getFoldPartNo());
                intent.putExtra("foldPslNo", ViewFormByAEROAdapter.this.al.get(i).getFoldPslNo());
                intent.putExtra("relationProofDocUrlPg1", ViewFormByAEROAdapter.this.al.get(i).getRelationProofDocUrlPg1());
                intent.putExtra("relationProofDocUrlPg2", ViewFormByAEROAdapter.this.al.get(i).getRelationProofDocUrlPg2());
                intent.putExtra("relationType", ViewFormByAEROAdapter.this.al.get(i).getRelationType());
                intent.putExtra("relationOldAcNo", ViewFormByAEROAdapter.this.al.get(i).getRelationOldAcNo());
                intent.putExtra("relationOldPartNo", ViewFormByAEROAdapter.this.al.get(i).getRelationOldPartNo());
                intent.putExtra("relationOldPartSerialNo", ViewFormByAEROAdapter.this.al.get(i).getRelationOldPslNo());
                intent.putExtra("relationList8DocsPage1", ViewFormByAEROAdapter.this.al.get(i).getRelationDocUrlPg1());
                intent.putExtra("relationList8DocsPage2", ViewFormByAEROAdapter.this.al.get(i).getRelationDocUrlPg2());
                intent.putExtra("relationListList8DocCode", ViewFormByAEROAdapter.this.al.get(i).getRelationDocType());
                intent.putExtra("relation2003YesOrNo", ViewFormByAEROAdapter.this.al.get(i).getIsRelativePreVoterFlg());
                intent.putExtra("modifiedBy", ViewFormByAEROAdapter.this.al.get(i).getModifiedBy());
                intent.putExtra("relativeEpic", ViewFormByAEROAdapter.this.al.get(i).getRelativeEpic());
                ViewFormByAEROAdapter.this.context.startActivity(intent);
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
