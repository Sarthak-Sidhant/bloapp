package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloPwdRequestRvItemBinding implements ViewBinding {
    public final TextView applicantName;
    public final TextView applicantNameValue;
    public final TextView formStatus;
    public final TextView formStatusValue;
    public final TextView generatedReferenceNumber;
    public final LinearLayout layoutFrame1;
    public final LinearLayout layoutFrame2;
    public final LinearLayout pwdRequestRvItem;
    public final TextView referenceNo;
    public final TextView referenceNoValue;
    public final TextView remark;
    public final TextView requestProcessedDate;
    public final TextView requestProcessedDateValue;
    private final LinearLayout rootView;
    public final TextView sNo;
    public final TextView submissionDate;
    public final TextView submissionDateValue;
    public final TextView typeOfRequest;
    public final TextView typeOfRequestValue;
    public final View viewLine;

    private BloPwdRequestRvItemBinding(LinearLayout rootView, TextView applicantName, TextView applicantNameValue, TextView formStatus, TextView formStatusValue, TextView generatedReferenceNumber, LinearLayout layoutFrame1, LinearLayout layoutFrame2, LinearLayout pwdRequestRvItem, TextView referenceNo, TextView referenceNoValue, TextView remark, TextView requestProcessedDate, TextView requestProcessedDateValue, TextView sNo, TextView submissionDate, TextView submissionDateValue, TextView typeOfRequest, TextView typeOfRequestValue, View viewLine) {
        this.rootView = rootView;
        this.applicantName = applicantName;
        this.applicantNameValue = applicantNameValue;
        this.formStatus = formStatus;
        this.formStatusValue = formStatusValue;
        this.generatedReferenceNumber = generatedReferenceNumber;
        this.layoutFrame1 = layoutFrame1;
        this.layoutFrame2 = layoutFrame2;
        this.pwdRequestRvItem = pwdRequestRvItem;
        this.referenceNo = referenceNo;
        this.referenceNoValue = referenceNoValue;
        this.remark = remark;
        this.requestProcessedDate = requestProcessedDate;
        this.requestProcessedDateValue = requestProcessedDateValue;
        this.sNo = sNo;
        this.submissionDate = submissionDate;
        this.submissionDateValue = submissionDateValue;
        this.typeOfRequest = typeOfRequest;
        this.typeOfRequestValue = typeOfRequestValue;
        this.viewLine = viewLine;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloPwdRequestRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPwdRequestRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_pwd_request_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPwdRequestRvItemBinding bind(View rootView) {
        int i = R.id.applicant_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name);
        if (textView != null) {
            i = R.id.applicant_name_value;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_value);
            if (textView2 != null) {
                i = R.id.form_status;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_status);
                if (textView3 != null) {
                    i = R.id.form_status_value;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_status_value);
                    if (textView4 != null) {
                        i = R.id.generatedReferenceNumber;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.generatedReferenceNumber);
                        if (textView5 != null) {
                            i = R.id.layout_frame1;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame1);
                            if (linearLayout != null) {
                                i = R.id.layout_frame2;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame2);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) rootView;
                                    i = R.id.reference_no;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reference_no);
                                    if (textView6 != null) {
                                        i = R.id.reference_no_value;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reference_no_value);
                                        if (textView7 != null) {
                                            i = R.id.remark;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remark);
                                            if (textView8 != null) {
                                                i = R.id.request_processed_date;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_processed_date);
                                                if (textView9 != null) {
                                                    i = R.id.request_processed_date_value;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_processed_date_value);
                                                    if (textView10 != null) {
                                                        i = R.id.sNo;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sNo);
                                                        if (textView11 != null) {
                                                            i = R.id.submission_date;
                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submission_date);
                                                            if (textView12 != null) {
                                                                i = R.id.submission_date_value;
                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submission_date_value);
                                                                if (textView13 != null) {
                                                                    i = R.id.type_of_request;
                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type_of_request);
                                                                    if (textView14 != null) {
                                                                        i = R.id.type_of_request_value;
                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type_of_request_value);
                                                                        if (textView15 != null) {
                                                                            i = R.id.view_line;
                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_line);
                                                                            if (viewFindChildViewById != null) {
                                                                                return new BloPwdRequestRvItemBinding(linearLayout3, textView, textView2, textView3, textView4, textView5, linearLayout, linearLayout2, linearLayout3, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, viewFindChildViewById);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
