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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloRegisterDraftListRvItemBinding implements ViewBinding {
    public final TextView ageHeader;
    public final TextView ageValue;
    public final TextView applicantNameHeader;
    public final TextView applicantNameValue;
    public final TextView deleteIcon;
    public final TextView deleteTV;
    public final LinearLayout deletionLayout;
    public final TextView epicNumberHeader;
    public final TextView epicNumberValue;
    public final RelativeLayout layout;
    public final LinearLayout layoutFrame1;
    public final LinearLayout layoutFrame2;
    public final TextView relativeNameHeader;
    public final TextView relativeNameValue;
    private final LinearLayout rootView;
    public final TextView sectionNoHeader;
    public final TextView sectionNoValue;
    public final TextView serialNo;
    public final TextView submissionIcon;
    public final LinearLayout submissionLayout;
    public final TextView submissionTV;
    public final View viewLine;

    private BloRegisterDraftListRvItemBinding(LinearLayout rootView, TextView ageHeader, TextView ageValue, TextView applicantNameHeader, TextView applicantNameValue, TextView deleteIcon, TextView deleteTV, LinearLayout deletionLayout, TextView epicNumberHeader, TextView epicNumberValue, RelativeLayout layout, LinearLayout layoutFrame1, LinearLayout layoutFrame2, TextView relativeNameHeader, TextView relativeNameValue, TextView sectionNoHeader, TextView sectionNoValue, TextView serialNo, TextView submissionIcon, LinearLayout submissionLayout, TextView submissionTV, View viewLine) {
        this.rootView = rootView;
        this.ageHeader = ageHeader;
        this.ageValue = ageValue;
        this.applicantNameHeader = applicantNameHeader;
        this.applicantNameValue = applicantNameValue;
        this.deleteIcon = deleteIcon;
        this.deleteTV = deleteTV;
        this.deletionLayout = deletionLayout;
        this.epicNumberHeader = epicNumberHeader;
        this.epicNumberValue = epicNumberValue;
        this.layout = layout;
        this.layoutFrame1 = layoutFrame1;
        this.layoutFrame2 = layoutFrame2;
        this.relativeNameHeader = relativeNameHeader;
        this.relativeNameValue = relativeNameValue;
        this.sectionNoHeader = sectionNoHeader;
        this.sectionNoValue = sectionNoValue;
        this.serialNo = serialNo;
        this.submissionIcon = submissionIcon;
        this.submissionLayout = submissionLayout;
        this.submissionTV = submissionTV;
        this.viewLine = viewLine;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloRegisterDraftListRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloRegisterDraftListRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_register_draft_list_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloRegisterDraftListRvItemBinding bind(View rootView) {
        int i = R.id.ageHeader;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ageHeader);
        if (textView != null) {
            i = R.id.ageValue;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ageValue);
            if (textView2 != null) {
                i = R.id.applicantNameHeader;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantNameHeader);
                if (textView3 != null) {
                    i = R.id.applicantNameValue;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantNameValue);
                    if (textView4 != null) {
                        i = R.id.deleteIcon;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deleteIcon);
                        if (textView5 != null) {
                            i = R.id.deleteTV;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deleteTV);
                            if (textView6 != null) {
                                i = R.id.deletionLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletionLayout);
                                if (linearLayout != null) {
                                    i = R.id.epicNumberHeader;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicNumberHeader);
                                    if (textView7 != null) {
                                        i = R.id.epicNumberValue;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicNumberValue);
                                        if (textView8 != null) {
                                            i = 2131364291;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, 2131364291);
                                            if (relativeLayout != null) {
                                                i = R.id.layout_frame1;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame1);
                                                if (linearLayout2 != null) {
                                                    i = R.id.layout_frame2;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame2);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.relativeNameHeader;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeNameHeader);
                                                        if (textView9 != null) {
                                                            i = R.id.relativeNameValue;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeNameValue);
                                                            if (textView10 != null) {
                                                                i = R.id.sectionNoHeader;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionNoHeader);
                                                                if (textView11 != null) {
                                                                    i = R.id.sectionNoValue;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionNoValue);
                                                                    if (textView12 != null) {
                                                                        i = R.id.serialNo;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo);
                                                                        if (textView13 != null) {
                                                                            i = R.id.submissionIcon;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submissionIcon);
                                                                            if (textView14 != null) {
                                                                                i = R.id.submissionLayout;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submissionLayout);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.submissionTV;
                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submissionTV);
                                                                                    if (textView15 != null) {
                                                                                        i = R.id.view_line;
                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_line);
                                                                                        if (viewFindChildViewById != null) {
                                                                                            return new BloRegisterDraftListRvItemBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, linearLayout, textView7, textView8, relativeLayout, linearLayout2, linearLayout3, textView9, textView10, textView11, textView12, textView13, textView14, linearLayout4, textView15, viewFindChildViewById);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
