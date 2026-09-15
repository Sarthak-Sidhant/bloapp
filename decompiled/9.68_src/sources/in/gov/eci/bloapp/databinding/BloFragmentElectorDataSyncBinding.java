package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentElectorDataSyncBinding implements ViewBinding {
    public final LinearLayout constituencyLayout;
    public final Button dataSyncVerified;
    public final Button h2hSurveyButton;
    public final LinearLayout h2hSurveyStatusLayout;
    public final TextView h2hSurveySyncDate;
    public final TextView lastH2hSurveyStatus;
    public final TextView lastVerifiedDetailSyncStatus;
    public final Button offlineButton;
    public final Button onlineButton;
    public final LinearLayout onlineOfflineLayout;
    public final ImageView peopleImage;
    public final ImageView peopleImage1;
    public final ImageView peopleImage2;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final ConstraintLayout scrollLayout;
    public final TextView textViewConstituencyDetails;
    public final TextView textViewConstituencyHeader;
    public final TextView totalData;
    public final Button totalElectorDataSync;
    public final TextView totalElectorsSyncDate;
    public final TextView totalElectorsSyncStatus;
    public final TextView totalElectorsTextView;
    public final LinearLayout totalElectorsTextViewLayout;
    public final TextView totalH2hSurveyStatus;
    public final TextView totalHouseVerified;
    public final LinearLayout totalHouseVerifiedLayout;
    public final TextView totalView;
    public final TextView totalView1;
    public final TextView totalView2;
    public final TextView verifiedSyncDate;

    private BloFragmentElectorDataSyncBinding(ConstraintLayout rootView, LinearLayout constituencyLayout, Button dataSyncVerified, Button h2hSurveyButton, LinearLayout h2hSurveyStatusLayout, TextView h2hSurveySyncDate, TextView lastH2hSurveyStatus, TextView lastVerifiedDetailSyncStatus, Button offlineButton, Button onlineButton, LinearLayout onlineOfflineLayout, ImageView peopleImage, ImageView peopleImage1, ImageView peopleImage2, ProgressBar progressBar, ConstraintLayout scrollLayout, TextView textViewConstituencyDetails, TextView textViewConstituencyHeader, TextView totalData, Button totalElectorDataSync, TextView totalElectorsSyncDate, TextView totalElectorsSyncStatus, TextView totalElectorsTextView, LinearLayout totalElectorsTextViewLayout, TextView totalH2hSurveyStatus, TextView totalHouseVerified, LinearLayout totalHouseVerifiedLayout, TextView totalView, TextView totalView1, TextView totalView2, TextView verifiedSyncDate) {
        this.rootView = rootView;
        this.constituencyLayout = constituencyLayout;
        this.dataSyncVerified = dataSyncVerified;
        this.h2hSurveyButton = h2hSurveyButton;
        this.h2hSurveyStatusLayout = h2hSurveyStatusLayout;
        this.h2hSurveySyncDate = h2hSurveySyncDate;
        this.lastH2hSurveyStatus = lastH2hSurveyStatus;
        this.lastVerifiedDetailSyncStatus = lastVerifiedDetailSyncStatus;
        this.offlineButton = offlineButton;
        this.onlineButton = onlineButton;
        this.onlineOfflineLayout = onlineOfflineLayout;
        this.peopleImage = peopleImage;
        this.peopleImage1 = peopleImage1;
        this.peopleImage2 = peopleImage2;
        this.progressBar = progressBar;
        this.scrollLayout = scrollLayout;
        this.textViewConstituencyDetails = textViewConstituencyDetails;
        this.textViewConstituencyHeader = textViewConstituencyHeader;
        this.totalData = totalData;
        this.totalElectorDataSync = totalElectorDataSync;
        this.totalElectorsSyncDate = totalElectorsSyncDate;
        this.totalElectorsSyncStatus = totalElectorsSyncStatus;
        this.totalElectorsTextView = totalElectorsTextView;
        this.totalElectorsTextViewLayout = totalElectorsTextViewLayout;
        this.totalH2hSurveyStatus = totalH2hSurveyStatus;
        this.totalHouseVerified = totalHouseVerified;
        this.totalHouseVerifiedLayout = totalHouseVerifiedLayout;
        this.totalView = totalView;
        this.totalView1 = totalView1;
        this.totalView2 = totalView2;
        this.verifiedSyncDate = verifiedSyncDate;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentElectorDataSyncBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentElectorDataSyncBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_elector_data_sync, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentElectorDataSyncBinding bind(View rootView) {
        int i = R.id.constituencyLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.constituencyLayout);
        if (linearLayout != null) {
            i = R.id.dataSyncVerified;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.dataSyncVerified);
            if (button != null) {
                i = R.id.h2hSurveyButton;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.h2hSurveyButton);
                if (button2 != null) {
                    i = R.id.h2hSurveyStatusLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.h2hSurveyStatusLayout);
                    if (linearLayout2 != null) {
                        i = R.id.h2hSurveySyncDate;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.h2hSurveySyncDate);
                        if (textView != null) {
                            i = R.id.lastH2hSurveyStatus;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lastH2hSurveyStatus);
                            if (textView2 != null) {
                                i = R.id.lastVerifiedDetailSyncStatus;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lastVerifiedDetailSyncStatus);
                                if (textView3 != null) {
                                    i = R.id.offlineButton;
                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.offlineButton);
                                    if (button3 != null) {
                                        i = R.id.onlineButton;
                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.onlineButton);
                                        if (button4 != null) {
                                            i = R.id.onlineOfflineLayout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.onlineOfflineLayout);
                                            if (linearLayout3 != null) {
                                                i = R.id.peopleImage;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.peopleImage);
                                                if (imageView != null) {
                                                    i = R.id.peopleImage1;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.peopleImage1);
                                                    if (imageView2 != null) {
                                                        i = R.id.peopleImage2;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.peopleImage2);
                                                        if (imageView3 != null) {
                                                            i = R.id.progress_bar;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                                                            if (progressBar != null) {
                                                                i = R.id.scrollLayout;
                                                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.scrollLayout);
                                                                if (constraintLayoutFindChildViewById != null) {
                                                                    i = R.id.textView_constituency_details;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_constituency_details);
                                                                    if (textView4 != null) {
                                                                        i = R.id.textView_constituency_header;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_constituency_header);
                                                                        if (textView5 != null) {
                                                                            i = R.id.totalData;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalData);
                                                                            if (textView6 != null) {
                                                                                i = R.id.totalElectorDataSync;
                                                                                Button button5 = (Button) ViewBindings.findChildViewById(rootView, R.id.totalElectorDataSync);
                                                                                if (button5 != null) {
                                                                                    i = R.id.totalElectorsSyncDate;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalElectorsSyncDate);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.totalElectorsSyncStatus;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalElectorsSyncStatus);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.totalElectorsTextView;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalElectorsTextView);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.totalElectorsTextViewLayout;
                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalElectorsTextViewLayout);
                                                                                                if (linearLayout4 != null) {
                                                                                                    i = R.id.totalH2hSurveyStatus;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalH2hSurveyStatus);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.totalHouseVerified;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalHouseVerified);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.totalHouseVerifiedLayout;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalHouseVerifiedLayout);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i = R.id.totalView;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalView);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.totalView1;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalView1);
                                                                                                                    if (textView13 != null) {
                                                                                                                        i = R.id.totalView2;
                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalView2);
                                                                                                                        if (textView14 != null) {
                                                                                                                            i = R.id.verifiedSyncDate;
                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.verifiedSyncDate);
                                                                                                                            if (textView15 != null) {
                                                                                                                                return new BloFragmentElectorDataSyncBinding((ConstraintLayout) rootView, linearLayout, button, button2, linearLayout2, textView, textView2, textView3, button3, button4, linearLayout3, imageView, imageView2, imageView3, progressBar, constraintLayoutFindChildViewById, textView4, textView5, textView6, button5, textView7, textView8, textView9, linearLayout4, textView10, textView11, linearLayout5, textView12, textView13, textView14, textView15);
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
