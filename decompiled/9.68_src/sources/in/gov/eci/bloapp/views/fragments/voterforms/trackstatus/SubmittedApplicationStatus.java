package in.gov.eci.bloapp.views.fragments.voterforms.trackstatus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentSubmittedApplicationStatusBinding;
import in.gov.eci.bloapp.databinding.BloTrackStatusRvItemBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class SubmittedApplicationStatus extends Fragment {
    String acNo;
    String accepted;
    String asmblyName;
    BloFragmentSubmittedApplicationStatusBinding binding;
    String bloAssigned;
    String currentStatus;
    String epicDispatchedDate;
    String epicNo;
    String erollUpdatedDate;
    String firstName;
    String formRefNo;
    String formType;
    String fvrSubmitted;
    String fvrSubmittedHearingScheduled;
    String hearingScheduled;
    String lastName;
    String rejected;
    String stateCode;
    String stateName;
    String submissionDate;
    String submitted;
    private final List<String> stageList6 = new ArrayList();
    private final List<String> stageList8 = new ArrayList();
    String formsubmit = "Form Submitted";
    String bloAssignedStr = "BLO Assigned";
    String fvrVerification = "FVR Verified";
    String hearingSchedule = "Hearing Scheduled";
    String acapted = "Accepted";

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        BloFragmentSubmittedApplicationStatusBinding bloFragmentSubmittedApplicationStatusBindingInflate = BloFragmentSubmittedApplicationStatusBinding.inflate(getLayoutInflater());
        this.binding = bloFragmentSubmittedApplicationStatusBindingInflate;
        bloFragmentSubmittedApplicationStatusBindingInflate.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.SubmittedApplicationStatus$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.stageList6.add(this.formsubmit);
        this.stageList6.add(this.bloAssignedStr);
        this.stageList6.add(this.fvrVerification);
        this.stageList6.add(this.hearingSchedule);
        this.stageList6.add(this.acapted);
        this.stageList6.add("EPIC Generated");
        this.stageList6.add("EPIC Dispatched");
        this.stageList8.add(this.formsubmit);
        this.stageList8.add(this.bloAssignedStr);
        this.stageList8.add(this.fvrVerification);
        this.stageList8.add(this.hearingSchedule);
        this.stageList8.add(this.acapted);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.firstName = arguments.getString(Constants.FIRST_NAME);
            this.lastName = arguments.getString(Constants.LAST_NAME);
            this.stateCode = arguments.getString("stateCode");
            this.acNo = arguments.getString("acNo");
            this.formRefNo = arguments.getString("formRefNo");
            this.formType = arguments.getString("formType");
            this.submissionDate = arguments.getString("submissionDate");
            this.currentStatus = arguments.getString("currentStatus");
            this.submitted = arguments.getString("submitted");
            this.bloAssigned = arguments.getString("bloAssigned");
            this.fvrSubmitted = arguments.getString("fvrSubmitted");
            this.epicNo = arguments.getString("epicNo");
            this.epicDispatchedDate = arguments.getString("epicDispatchedDate");
            this.hearingScheduled = arguments.getString("hearingScheduled");
            this.fvrSubmittedHearingScheduled = arguments.getString("fvrSubmittedHearingScheduled");
            this.accepted = arguments.getString("accepted");
            this.rejected = arguments.getString("rejected");
            this.erollUpdatedDate = arguments.getString("erollUpdatedDate");
        }
        this.binding.statusTv.setText(this.currentStatus);
        this.binding.refNoTv.setText(this.formRefNo);
        this.binding.firstNameTv.setText(this.firstName);
        this.binding.lastNameTv.setText(this.lastName);
        this.binding.stateTv.setText(this.stateName);
        this.binding.areaTv.setText(this.asmblyName);
        this.binding.formType.setText(this.formType);
        if (!this.submissionDate.equals("")) {
            byte b = 0;
            String strSubstring = this.submissionDate.substring(0, 2);
            int i = Integer.parseInt(strSubstring);
            if (i >= 11 && i <= 13) {
                strSubstring = strSubstring + "th";
            }
            int i2 = i % 10;
            if (i2 == 1) {
                str = strSubstring + "st";
            } else if (i2 == 2) {
                str = strSubstring + "nd";
            } else if (i2 != 3) {
                str = strSubstring + "th";
            } else {
                str = strSubstring + "rd";
            }
            String strSubstring2 = this.submissionDate.substring(3, 5);
            String strSubstring3 = this.submissionDate.substring(6, 10);
            strSubstring2.hashCode();
            switch (strSubstring2.hashCode()) {
                case 1537:
                    if (!strSubstring2.equals("01")) {
                        b = -1;
                    }
                    break;
                case 1538:
                    b = !strSubstring2.equals("02") ? (byte) -1 : (byte) 1;
                    break;
                case 1539:
                    b = !strSubstring2.equals("03") ? (byte) -1 : (byte) 2;
                    break;
                case 1540:
                    b = !strSubstring2.equals("04") ? (byte) -1 : (byte) 3;
                    break;
                case 1541:
                    b = !strSubstring2.equals("05") ? (byte) -1 : (byte) 4;
                    break;
                case 1542:
                    b = !strSubstring2.equals("06") ? (byte) -1 : (byte) 5;
                    break;
                case 1543:
                    b = !strSubstring2.equals("07") ? (byte) -1 : (byte) 6;
                    break;
                case 1544:
                    b = !strSubstring2.equals("08") ? (byte) -1 : (byte) 7;
                    break;
                case 1545:
                    b = !strSubstring2.equals("09") ? (byte) -1 : (byte) 8;
                    break;
                case 1567:
                    b = !strSubstring2.equals("10") ? (byte) -1 : (byte) 9;
                    break;
                case 1568:
                    b = !strSubstring2.equals("11") ? (byte) -1 : (byte) 10;
                    break;
                case 1569:
                    b = !strSubstring2.equals("12") ? (byte) -1 : (byte) 11;
                    break;
                default:
                    b = -1;
                    break;
            }
            String str2 = "January";
            switch (b) {
                case 1:
                    str2 = "February";
                    break;
                case 2:
                    str2 = "March";
                    break;
                case 3:
                    str2 = "April";
                    break;
                case 4:
                    str2 = "May";
                    break;
                case 5:
                    str2 = "June";
                    break;
                case 6:
                    str2 = "July";
                    break;
                case 7:
                    str2 = "August";
                    break;
                case 8:
                    str2 = "September";
                    break;
                case 9:
                    str2 = "October";
                    break;
                case 10:
                    str2 = "November";
                    break;
                case 11:
                    str2 = "December";
                    break;
            }
            this.binding.submissiondateTv.setText(str + StringUtils.SPACE + str2 + ", " + strSubstring3);
        } else {
            this.binding.submissiondateTv.setText(this.submissionDate);
        }
        if (this.formType.equals("FORM6")) {
            initRecyclerViewAdapter1();
        }
        if (this.formType.equals("FORM6A")) {
            initRecyclerViewAdapter1();
        }
        if (this.formType.equals("FORM7")) {
            initRecyclerViewAdapter4();
        }
        if (this.formType.equals("FORM8")) {
            initRecyclerViewAdapter4();
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    private void initRecyclerViewAdapter1() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.SubmittedApplicationStatus.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(SubmittedApplicationStatus.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line));
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals(SubmittedApplicationStatus.this.formsubmit) && SubmittedApplicationStatus.this.submitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals(SubmittedApplicationStatus.this.bloAssignedStr) && SubmittedApplicationStatus.this.bloAssigned.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals(SubmittedApplicationStatus.this.fvrVerification) && SubmittedApplicationStatus.this.fvrSubmitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals(SubmittedApplicationStatus.this.hearingSchedule) && SubmittedApplicationStatus.this.hearingScheduled.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals(SubmittedApplicationStatus.this.acapted) && SubmittedApplicationStatus.this.accepted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals(SubmittedApplicationStatus.this.acapted) && SubmittedApplicationStatus.this.rejected.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals("EPIC Generated") && !SubmittedApplicationStatus.this.epicNo.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(SubmittedApplicationStatus.this.epicNo);
                }
                if (((String) SubmittedApplicationStatus.this.stageList6.get(position)).equals("EPIC Dispatched") && !SubmittedApplicationStatus.this.epicDispatchedDate.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(SubmittedApplicationStatus.this.epicNo);
                }
                if (position == SubmittedApplicationStatus.this.stageList6.size() - 1) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
                ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) SubmittedApplicationStatus.this.stageList6.get(position));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return SubmittedApplicationStatus.this.stageList6.size();
            }
        });
        this.binding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }

    private void initRecyclerViewAdapter4() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.SubmittedApplicationStatus.2
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(SubmittedApplicationStatus.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) SubmittedApplicationStatus.this.stageList8.get(position));
                try {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line));
                    if (((String) SubmittedApplicationStatus.this.stageList8.get(position)).equals(SubmittedApplicationStatus.this.formsubmit) && SubmittedApplicationStatus.this.submitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) SubmittedApplicationStatus.this.stageList8.get(position)).equals(SubmittedApplicationStatus.this.bloAssignedStr) && SubmittedApplicationStatus.this.bloAssigned.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) SubmittedApplicationStatus.this.stageList8.get(position)).equals(SubmittedApplicationStatus.this.fvrVerification) && SubmittedApplicationStatus.this.fvrSubmitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) SubmittedApplicationStatus.this.stageList8.get(position)).equals(SubmittedApplicationStatus.this.hearingSchedule) && SubmittedApplicationStatus.this.hearingScheduled.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) SubmittedApplicationStatus.this.stageList8.get(position)).equals(SubmittedApplicationStatus.this.acapted) && SubmittedApplicationStatus.this.accepted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) SubmittedApplicationStatus.this.stageList8.get(position)).equals(SubmittedApplicationStatus.this.acapted) && SubmittedApplicationStatus.this.rejected.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(SubmittedApplicationStatus.this.getContext(), R.color.blo_line_green));
                        ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                    }
                } catch (Exception e) {
                    Logger.d("logTag", e.getMessage());
                }
                if (position == SubmittedApplicationStatus.this.stageList8.size() - 1) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return SubmittedApplicationStatus.this.stageList8.size();
            }
        });
        this.binding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }
}
