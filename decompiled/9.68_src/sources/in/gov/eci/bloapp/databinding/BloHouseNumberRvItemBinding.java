package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloHouseNumberRvItemBinding implements ViewBinding {
    public final TextView AgeET;
    public final TextView EpicEt;
    public final TextView RelativeNameET;
    public final TextView SectionEt;
    public final TextView SerialNoTv;
    public final TextView VerifiedTickTv;
    public final TextView VerifiedTv;
    public final TextView applicantET;
    public final TextView applicantName;
    public final TextView formStatus;
    public final TextView generatedReferenceNumber;
    public final RelativeLayout layout;
    public final LinearLayout layoutFrame1;
    public final LinearLayout layoutFrame2;
    public final TextView referenceNo;
    public final TextView remark;
    private final LinearLayout rootView;
    public final TextView submissionDate;
    public final TextView typeOfRequest;
    public final View viewLine;

    private BloHouseNumberRvItemBinding(LinearLayout rootView, TextView AgeET, TextView EpicEt, TextView RelativeNameET, TextView SectionEt, TextView SerialNoTv, TextView VerifiedTickTv, TextView VerifiedTv, TextView applicantET, TextView applicantName, TextView formStatus, TextView generatedReferenceNumber, RelativeLayout layout, LinearLayout layoutFrame1, LinearLayout layoutFrame2, TextView referenceNo, TextView remark, TextView submissionDate, TextView typeOfRequest, View viewLine) {
        this.rootView = rootView;
        this.AgeET = AgeET;
        this.EpicEt = EpicEt;
        this.RelativeNameET = RelativeNameET;
        this.SectionEt = SectionEt;
        this.SerialNoTv = SerialNoTv;
        this.VerifiedTickTv = VerifiedTickTv;
        this.VerifiedTv = VerifiedTv;
        this.applicantET = applicantET;
        this.applicantName = applicantName;
        this.formStatus = formStatus;
        this.generatedReferenceNumber = generatedReferenceNumber;
        this.layout = layout;
        this.layoutFrame1 = layoutFrame1;
        this.layoutFrame2 = layoutFrame2;
        this.referenceNo = referenceNo;
        this.remark = remark;
        this.submissionDate = submissionDate;
        this.typeOfRequest = typeOfRequest;
        this.viewLine = viewLine;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloHouseNumberRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloHouseNumberRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_house_number_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloHouseNumberRvItemBinding bind(View rootView) {
        int i = R.id.AgeET;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AgeET);
        if (textView != null) {
            i = R.id.EpicEt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.EpicEt);
            if (textView2 != null) {
                i = R.id.RelativeNameET;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.RelativeNameET);
                if (textView3 != null) {
                    i = R.id.SectionEt;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.SectionEt);
                    if (textView4 != null) {
                        i = R.id.SerialNoTv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.SerialNoTv);
                        if (textView5 != null) {
                            i = R.id.Verified_tick_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Verified_tick_tv);
                            if (textView6 != null) {
                                i = R.id.VerifiedTv;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.VerifiedTv);
                                if (textView7 != null) {
                                    i = R.id.applicantET;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantET);
                                    if (textView8 != null) {
                                        i = R.id.applicant_name;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name);
                                        if (textView9 != null) {
                                            i = R.id.form_status;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_status);
                                            if (textView10 != null) {
                                                i = R.id.generatedReferenceNumber;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.generatedReferenceNumber);
                                                if (textView11 != null) {
                                                    i = 2131364428;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                                                    if (relativeLayout != null) {
                                                        i = R.id.layout_frame1;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame1);
                                                        if (linearLayout != null) {
                                                            i = R.id.layout_frame2;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame2);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.reference_no;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reference_no);
                                                                if (textView12 != null) {
                                                                    i = R.id.remark;
                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remark);
                                                                    if (textView13 != null) {
                                                                        i = R.id.submission_date;
                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submission_date);
                                                                        if (textView14 != null) {
                                                                            i = R.id.type_of_request;
                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type_of_request);
                                                                            if (textView15 != null) {
                                                                                i = R.id.view_line;
                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_line);
                                                                                if (viewFindChildViewById != null) {
                                                                                    return new BloHouseNumberRvItemBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, relativeLayout, linearLayout, linearLayout2, textView12, textView13, textView14, textView15, viewFindChildViewById);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
