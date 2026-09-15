package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityFormTypesBinding implements ViewBinding {
    public final TextView additionalTab;
    public final LinearLayout additionalTabLL;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout efDashboard;
    public final TextView efDashboardTab;
    public final LinearLayout efTracker;
    public final TextView efTrackerTab;
    public final LinearLayout efuploadAttendence;
    public final TextView efuploadAttendenceTab;
    public final TextView enumerationForm;
    public final LinearLayout fillEFLayout;
    public final LinearLayout filledBLO;
    public final TextView filledBLOTv;
    public final TextView filledForm;
    public final LinearLayout llDeceasedElectors;
    public final LinearLayout llDelivery;
    public final LinearLayout llDuplicateVerification;
    public final LinearLayout llPostAnomaly;
    public final LinearLayout llUpdateBloBla;
    public final LinearLayout llanomaly;
    public final LinearLayout lldraftlist;
    public final LinearLayout llnomapping;
    public final LinearLayout llpseverification;
    public final LinearLayout llselectPhoto;
    public final LinearLayout llupdatemobile;
    public final LinearLayout main;
    public final LinearLayout migratedElector;
    public final TextView migratedElectorTv;
    public final TextView noteOpen;
    public final LinearLayout offlineLL;
    public final TextView offlineTab;
    public final TextView ofllineDisclaimer;
    public final LinearLayout pendingElector;
    public final TextView pendingElectorTv;
    public final TextView pendingElectorTvepicmatch;
    public final LinearLayout pendingElectorepicmatch;
    public final TextView postTV;
    public final TextView preTV;
    public final LinearLayout rollBack;
    public final TextView rollBackTv;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final TextView textView5;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView tvDecesed;
    public final TextView tvDelivery;
    public final TextView tvDuplicateVerification;
    public final LinearLayout uncollectableEFLL;
    public final TextView uploadUncollectableEfTv;
    public final LinearLayout verifyElectors;
    public final LinearLayout viewDocuments;
    public final TextView viewFormByAero;
    public final LinearLayout viewFormByAeroLL;
    public final TextView viewdocuemnts;

    private ActivityFormTypesBinding(LinearLayout rootView, TextView additionalTab, LinearLayout additionalTabLL, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout efDashboard, TextView efDashboardTab, LinearLayout efTracker, TextView efTrackerTab, LinearLayout efuploadAttendence, TextView efuploadAttendenceTab, TextView enumerationForm, LinearLayout fillEFLayout, LinearLayout filledBLO, TextView filledBLOTv, TextView filledForm, LinearLayout llDeceasedElectors, LinearLayout llDelivery, LinearLayout llDuplicateVerification, LinearLayout llPostAnomaly, LinearLayout llUpdateBloBla, LinearLayout llanomaly, LinearLayout lldraftlist, LinearLayout llnomapping, LinearLayout llpseverification, LinearLayout llselectPhoto, LinearLayout llupdatemobile, LinearLayout main, LinearLayout migratedElector, TextView migratedElectorTv, TextView noteOpen, LinearLayout offlineLL, TextView offlineTab, TextView ofllineDisclaimer, LinearLayout pendingElector, TextView pendingElectorTv, TextView pendingElectorTvepicmatch, LinearLayout pendingElectorepicmatch, TextView postTV, TextView preTV, LinearLayout rollBack, TextView rollBackTv, TextView textView3, TextView textView5, Toolbar toolbar, ImageView toolbarButton, TextView tvDecesed, TextView tvDelivery, TextView tvDuplicateVerification, LinearLayout uncollectableEFLL, TextView uploadUncollectableEfTv, LinearLayout verifyElectors, LinearLayout viewDocuments, TextView viewFormByAero, LinearLayout viewFormByAeroLL, TextView viewdocuemnts) {
        this.rootView = rootView;
        this.additionalTab = additionalTab;
        this.additionalTabLL = additionalTabLL;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.efDashboard = efDashboard;
        this.efDashboardTab = efDashboardTab;
        this.efTracker = efTracker;
        this.efTrackerTab = efTrackerTab;
        this.efuploadAttendence = efuploadAttendence;
        this.efuploadAttendenceTab = efuploadAttendenceTab;
        this.enumerationForm = enumerationForm;
        this.fillEFLayout = fillEFLayout;
        this.filledBLO = filledBLO;
        this.filledBLOTv = filledBLOTv;
        this.filledForm = filledForm;
        this.llDeceasedElectors = llDeceasedElectors;
        this.llDelivery = llDelivery;
        this.llDuplicateVerification = llDuplicateVerification;
        this.llPostAnomaly = llPostAnomaly;
        this.llUpdateBloBla = llUpdateBloBla;
        this.llanomaly = llanomaly;
        this.lldraftlist = lldraftlist;
        this.llnomapping = llnomapping;
        this.llpseverification = llpseverification;
        this.llselectPhoto = llselectPhoto;
        this.llupdatemobile = llupdatemobile;
        this.main = main;
        this.migratedElector = migratedElector;
        this.migratedElectorTv = migratedElectorTv;
        this.noteOpen = noteOpen;
        this.offlineLL = offlineLL;
        this.offlineTab = offlineTab;
        this.ofllineDisclaimer = ofllineDisclaimer;
        this.pendingElector = pendingElector;
        this.pendingElectorTv = pendingElectorTv;
        this.pendingElectorTvepicmatch = pendingElectorTvepicmatch;
        this.pendingElectorepicmatch = pendingElectorepicmatch;
        this.postTV = postTV;
        this.preTV = preTV;
        this.rollBack = rollBack;
        this.rollBackTv = rollBackTv;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.tvDecesed = tvDecesed;
        this.tvDelivery = tvDelivery;
        this.tvDuplicateVerification = tvDuplicateVerification;
        this.uncollectableEFLL = uncollectableEFLL;
        this.uploadUncollectableEfTv = uploadUncollectableEfTv;
        this.verifyElectors = verifyElectors;
        this.viewDocuments = viewDocuments;
        this.viewFormByAero = viewFormByAero;
        this.viewFormByAeroLL = viewFormByAeroLL;
        this.viewdocuemnts = viewdocuemnts;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFormTypesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFormTypesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_form_types, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFormTypesBinding bind(View rootView) {
        int i = R.id.additionalTab;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.additionalTab);
        if (textView != null) {
            i = R.id.additionalTabLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.additionalTabLL);
            if (linearLayout != null) {
                i = R.id.back_btn_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView != null) {
                    i = R.id.bla_top_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.efDashboard;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.efDashboard);
                        if (linearLayout2 != null) {
                            i = R.id.efDashboardTab;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.efDashboardTab);
                            if (textView2 != null) {
                                i = R.id.efTracker;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.efTracker);
                                if (linearLayout3 != null) {
                                    i = R.id.efTrackerTab;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.efTrackerTab);
                                    if (textView3 != null) {
                                        i = R.id.efuploadAttendence;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.efuploadAttendence);
                                        if (linearLayout4 != null) {
                                            i = R.id.efuploadAttendenceTab;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.efuploadAttendenceTab);
                                            if (textView4 != null) {
                                                i = R.id.enumerationForm;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationForm);
                                                if (textView5 != null) {
                                                    i = R.id.fillEFLayout;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fillEFLayout);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.filledBLO;
                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.filledBLO);
                                                        if (linearLayout6 != null) {
                                                            i = R.id.filledBLO_tv;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filledBLO_tv);
                                                            if (textView6 != null) {
                                                                i = R.id.filledForm;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filledForm);
                                                                if (textView7 != null) {
                                                                    i = R.id.ll_deceased_electors;
                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_deceased_electors);
                                                                    if (linearLayout7 != null) {
                                                                        i = R.id.ll_delivery;
                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_delivery);
                                                                        if (linearLayout8 != null) {
                                                                            i = R.id.ll_duplicate_verification;
                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_duplicate_verification);
                                                                            if (linearLayout9 != null) {
                                                                                i = R.id.llPostAnomaly;
                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llPostAnomaly);
                                                                                if (linearLayout10 != null) {
                                                                                    i = R.id.ll_update_blo_bla;
                                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_update_blo_bla);
                                                                                    if (linearLayout11 != null) {
                                                                                        i = R.id.llanomaly;
                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llanomaly);
                                                                                        if (linearLayout12 != null) {
                                                                                            i = R.id.lldraftlist;
                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lldraftlist);
                                                                                            if (linearLayout13 != null) {
                                                                                                i = R.id.llnomapping;
                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llnomapping);
                                                                                                if (linearLayout14 != null) {
                                                                                                    i = R.id.llpseverification;
                                                                                                    LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llpseverification);
                                                                                                    if (linearLayout15 != null) {
                                                                                                        i = R.id.llselectPhoto;
                                                                                                        LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llselectPhoto);
                                                                                                        if (linearLayout16 != null) {
                                                                                                            i = R.id.llupdatemobile;
                                                                                                            LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llupdatemobile);
                                                                                                            if (linearLayout17 != null) {
                                                                                                                LinearLayout linearLayout18 = (LinearLayout) rootView;
                                                                                                                i = R.id.migratedElector;
                                                                                                                LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.migratedElector);
                                                                                                                if (linearLayout19 != null) {
                                                                                                                    i = R.id.migratedElector_tv;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.migratedElector_tv);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.noteOpen;
                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteOpen);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i = R.id.offlineLL;
                                                                                                                            LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.offlineLL);
                                                                                                                            if (linearLayout20 != null) {
                                                                                                                                i = R.id.offlineTab;
                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.offlineTab);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    i = R.id.ofllineDisclaimer;
                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ofllineDisclaimer);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i = R.id.pendingElector;
                                                                                                                                        LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingElector);
                                                                                                                                        if (linearLayout21 != null) {
                                                                                                                                            i = R.id.pendingElector_tv;
                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pendingElector_tv);
                                                                                                                                            if (textView12 != null) {
                                                                                                                                                i = R.id.pendingElector_tvepicmatch;
                                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pendingElector_tvepicmatch);
                                                                                                                                                if (textView13 != null) {
                                                                                                                                                    i = R.id.pendingElectorepicmatch;
                                                                                                                                                    LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingElectorepicmatch);
                                                                                                                                                    if (linearLayout22 != null) {
                                                                                                                                                        i = R.id.postTV;
                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postTV);
                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                            i = R.id.preTV;
                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.preTV);
                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                i = R.id.rollBack;
                                                                                                                                                                LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rollBack);
                                                                                                                                                                if (linearLayout23 != null) {
                                                                                                                                                                    i = R.id.rollBack_tv;
                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rollBack_tv);
                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                        i = R.id.textView3;
                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                            i = R.id.textView5;
                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                i = R.id.toolbar;
                                                                                                                                                                                Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                                                                                                                                                                if (toolbarFindChildViewById != null) {
                                                                                                                                                                                    i = R.id.toolbar_button;
                                                                                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                                                                    if (imageView2 != null) {
                                                                                                                                                                                        i = R.id.tv_decesed;
                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_decesed);
                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                            i = R.id.tv_delivery;
                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_delivery);
                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                i = R.id.tv_duplicate_verification;
                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_duplicate_verification);
                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                    i = R.id.uncollectableEF_LL;
                                                                                                                                                                                                    LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.uncollectableEF_LL);
                                                                                                                                                                                                    if (linearLayout24 != null) {
                                                                                                                                                                                                        i = R.id.uploadUncollectableEf_tv;
                                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadUncollectableEf_tv);
                                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                                            i = R.id.verifyElectors;
                                                                                                                                                                                                            LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verifyElectors);
                                                                                                                                                                                                            if (linearLayout25 != null) {
                                                                                                                                                                                                                i = R.id.view_documents;
                                                                                                                                                                                                                LinearLayout linearLayout26 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.view_documents);
                                                                                                                                                                                                                if (linearLayout26 != null) {
                                                                                                                                                                                                                    i = R.id.viewFormByAero;
                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewFormByAero);
                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                        i = R.id.viewFormByAeroLL;
                                                                                                                                                                                                                        LinearLayout linearLayout27 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.viewFormByAeroLL);
                                                                                                                                                                                                                        if (linearLayout27 != null) {
                                                                                                                                                                                                                            i = R.id.viewdocuemnts;
                                                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewdocuemnts);
                                                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                                                return new ActivityFormTypesBinding(linearLayout18, textView, linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout2, textView2, linearLayout3, textView3, linearLayout4, textView4, textView5, linearLayout5, linearLayout6, textView6, textView7, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, linearLayout14, linearLayout15, linearLayout16, linearLayout17, linearLayout18, linearLayout19, textView8, textView9, linearLayout20, textView10, textView11, linearLayout21, textView12, textView13, linearLayout22, textView14, textView15, linearLayout23, textView16, textView17, textView18, toolbarFindChildViewById, imageView2, textView19, textView20, textView21, linearLayout24, textView22, linearLayout25, linearLayout26, textView23, linearLayout27, textView24);
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
