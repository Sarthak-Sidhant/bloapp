package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityFormDocumentsBinding implements ViewBinding {
    public final TextView annexure;
    public final ImageView annexureUrl;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final TextView electorPhoto;
    public final TextView enumeration;
    public final TextView father;
    public final TextView indianCitizen;
    public final ImageView list1DocUrl;
    public final ImageView list1DocUrl2;
    public final ImageView list3DocUrl;
    public final ImageView list3DocUrl2;
    public final ImageView list4DocUrl;
    public final ImageView list4DocUrl2;
    public final TextView list5;
    public final ImageView list5DocUrl;
    public final ImageView list5DocUrl2;
    public final ImageView list5DocUrl3;
    public final ImageView list6DocUrl;
    public final ImageView list6docUrl2;
    public final ImageView list7DocUr2;
    public final ImageView list7DocUrl;
    public final LinearLayout main;
    public final TextView mother;
    public final TextView noDocumentsAvailable;
    public final TextView notBorn;
    public final AppCompatButton notRecommended;
    public final TextView orAnnex;
    public final TextView orAnnex2;
    public final ImageView photoUrl;
    public final TextView preRevision;
    public final ImageView preRevisionVoterDocUrl;
    public final ImageView preRevisionVoterDocUrl2;
    private final LinearLayout rootView;
    public final TextView self;
    public final ImageView srFormPage1Url;
    public final ImageView srFormPage2Url;
    public final AppCompatButton submitButtonRec;
    public final LinearLayout submitLayout;
    public final TextView textView3;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView toolbarTitle;
    public final AppCompatButton updateData;

    private ActivityFormDocumentsBinding(LinearLayout rootView, TextView annexure, ImageView annexureUrl, ImageView backBtnIv, ConstraintLayout blaTopLayout, TextView electorPhoto, TextView enumeration, TextView father, TextView indianCitizen, ImageView list1DocUrl, ImageView list1DocUrl2, ImageView list3DocUrl, ImageView list3DocUrl2, ImageView list4DocUrl, ImageView list4DocUrl2, TextView list5, ImageView list5DocUrl, ImageView list5DocUrl2, ImageView list5DocUrl3, ImageView list6DocUrl, ImageView list6docUrl2, ImageView list7DocUr2, ImageView list7DocUrl, LinearLayout main, TextView mother, TextView noDocumentsAvailable, TextView notBorn, AppCompatButton notRecommended, TextView orAnnex, TextView orAnnex2, ImageView photoUrl, TextView preRevision, ImageView preRevisionVoterDocUrl, ImageView preRevisionVoterDocUrl2, TextView self, ImageView srFormPage1Url, ImageView srFormPage2Url, AppCompatButton submitButtonRec, LinearLayout submitLayout, TextView textView3, Toolbar toolbar, ImageView toolbarButton, TextView toolbarTitle, AppCompatButton updateData) {
        this.rootView = rootView;
        this.annexure = annexure;
        this.annexureUrl = annexureUrl;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.electorPhoto = electorPhoto;
        this.enumeration = enumeration;
        this.father = father;
        this.indianCitizen = indianCitizen;
        this.list1DocUrl = list1DocUrl;
        this.list1DocUrl2 = list1DocUrl2;
        this.list3DocUrl = list3DocUrl;
        this.list3DocUrl2 = list3DocUrl2;
        this.list4DocUrl = list4DocUrl;
        this.list4DocUrl2 = list4DocUrl2;
        this.list5 = list5;
        this.list5DocUrl = list5DocUrl;
        this.list5DocUrl2 = list5DocUrl2;
        this.list5DocUrl3 = list5DocUrl3;
        this.list6DocUrl = list6DocUrl;
        this.list6docUrl2 = list6docUrl2;
        this.list7DocUr2 = list7DocUr2;
        this.list7DocUrl = list7DocUrl;
        this.main = main;
        this.mother = mother;
        this.noDocumentsAvailable = noDocumentsAvailable;
        this.notBorn = notBorn;
        this.notRecommended = notRecommended;
        this.orAnnex = orAnnex;
        this.orAnnex2 = orAnnex2;
        this.photoUrl = photoUrl;
        this.preRevision = preRevision;
        this.preRevisionVoterDocUrl = preRevisionVoterDocUrl;
        this.preRevisionVoterDocUrl2 = preRevisionVoterDocUrl2;
        this.self = self;
        this.srFormPage1Url = srFormPage1Url;
        this.srFormPage2Url = srFormPage2Url;
        this.submitButtonRec = submitButtonRec;
        this.submitLayout = submitLayout;
        this.textView3 = textView3;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.toolbarTitle = toolbarTitle;
        this.updateData = updateData;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFormDocumentsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFormDocumentsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_form_documents, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFormDocumentsBinding bind(View rootView) {
        int i = R.id.annexure;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.annexure);
        if (textView != null) {
            i = R.id.annexureUrl;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.annexureUrl);
            if (imageView != null) {
                i = R.id.back_btn_iv;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView2 != null) {
                    i = R.id.bla_top_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.electorPhoto;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorPhoto);
                        if (textView2 != null) {
                            i = R.id.enumeration;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumeration);
                            if (textView3 != null) {
                                i = R.id.father;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.father);
                                if (textView4 != null) {
                                    i = R.id.indianCitizen;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indianCitizen);
                                    if (textView5 != null) {
                                        i = R.id.list1DocUrl;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list1DocUrl);
                                        if (imageView3 != null) {
                                            i = R.id.list1DocUrl2;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list1DocUrl2);
                                            if (imageView4 != null) {
                                                i = R.id.list3DocUrl;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list3DocUrl);
                                                if (imageView5 != null) {
                                                    i = R.id.list3DocUrl2;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list3DocUrl2);
                                                    if (imageView6 != null) {
                                                        i = R.id.list4DocUrl;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list4DocUrl);
                                                        if (imageView7 != null) {
                                                            i = R.id.list4DocUrl2;
                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list4DocUrl2);
                                                            if (imageView8 != null) {
                                                                i = R.id.list5;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.list5);
                                                                if (textView6 != null) {
                                                                    i = R.id.list5DocUrl;
                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list5DocUrl);
                                                                    if (imageView9 != null) {
                                                                        i = R.id.list5DocUrl2;
                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list5DocUrl2);
                                                                        if (imageView10 != null) {
                                                                            i = R.id.list5DocUrl3;
                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list5DocUrl3);
                                                                            if (imageView11 != null) {
                                                                                i = R.id.list6DocUrl;
                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list6DocUrl);
                                                                                if (imageView12 != null) {
                                                                                    i = R.id.list6docUrl2;
                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list6docUrl2);
                                                                                    if (imageView13 != null) {
                                                                                        i = R.id.list7DocUr2;
                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list7DocUr2);
                                                                                        if (imageView14 != null) {
                                                                                            i = R.id.list7DocUrl;
                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.list7DocUrl);
                                                                                            if (imageView15 != null) {
                                                                                                LinearLayout linearLayout = (LinearLayout) rootView;
                                                                                                i = R.id.mother;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mother);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.noDocumentsAvailable;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noDocumentsAvailable);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.notBorn;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notBorn);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.notRecommended;
                                                                                                            AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.notRecommended);
                                                                                                            if (appCompatButtonFindChildViewById != null) {
                                                                                                                i = R.id.orAnnex;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orAnnex);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.orAnnex2;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orAnnex2);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.photoUrl;
                                                                                                                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photoUrl);
                                                                                                                        if (imageView16 != null) {
                                                                                                                            i = R.id.preRevision;
                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.preRevision);
                                                                                                                            if (textView12 != null) {
                                                                                                                                i = R.id.preRevisionVoterDocUrl;
                                                                                                                                ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preRevisionVoterDocUrl);
                                                                                                                                if (imageView17 != null) {
                                                                                                                                    i = R.id.preRevisionVoterDocUrl2;
                                                                                                                                    ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preRevisionVoterDocUrl2);
                                                                                                                                    if (imageView18 != null) {
                                                                                                                                        i = R.id.self;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i = R.id.srFormPage1Url;
                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.srFormPage1Url);
                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                i = R.id.srFormPage2Url;
                                                                                                                                                ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.srFormPage2Url);
                                                                                                                                                if (imageView20 != null) {
                                                                                                                                                    i = R.id.submitButtonRec;
                                                                                                                                                    AppCompatButton appCompatButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.submitButtonRec);
                                                                                                                                                    if (appCompatButtonFindChildViewById2 != null) {
                                                                                                                                                        i = R.id.submitLayout;
                                                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submitLayout);
                                                                                                                                                        if (linearLayout2 != null) {
                                                                                                                                                            i = R.id.textView3;
                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                i = R.id.toolbar;
                                                                                                                                                                Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                                                                                                                                                if (toolbarFindChildViewById != null) {
                                                                                                                                                                    i = R.id.toolbar_button;
                                                                                                                                                                    ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                                                    if (imageView21 != null) {
                                                                                                                                                                        i = R.id.toolbar_title;
                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbar_title);
                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                            i = R.id.updateData;
                                                                                                                                                                            AppCompatButton appCompatButtonFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.updateData);
                                                                                                                                                                            if (appCompatButtonFindChildViewById3 != null) {
                                                                                                                                                                                return new ActivityFormDocumentsBinding(linearLayout, textView, imageView, imageView2, constraintLayoutFindChildViewById, textView2, textView3, textView4, textView5, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, textView6, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, linearLayout, textView7, textView8, textView9, appCompatButtonFindChildViewById, textView10, textView11, imageView16, textView12, imageView17, imageView18, textView13, imageView19, imageView20, appCompatButtonFindChildViewById2, linearLayout2, textView14, toolbarFindChildViewById, imageView21, textView15, appCompatButtonFindChildViewById3);
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
