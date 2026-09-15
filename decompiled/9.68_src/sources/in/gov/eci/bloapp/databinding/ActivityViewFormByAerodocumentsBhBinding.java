package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityViewFormByAerodocumentsBhBinding implements ViewBinding {
    public final TextView annexure;
    public final LinearLayout annexureLL;
    public final ImageView annexureUrl;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final TextView electorPhoto;
    public final LinearLayout electorPhotoLL;
    public final TextView enumeration;
    public final LinearLayout enumerationLL;
    public final TextView father;
    public final LinearLayout fatherLL;
    public final TextView indianCitizen;
    public final LinearLayout indianCitizenLL;
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
    public final LinearLayout list5LL;
    public final ImageView list6DocUrl;
    public final ImageView list6docUrl2;
    public final ImageView list7DocUr2;
    public final ImageView list7DocUrl;
    public final LinearLayout main;
    public final TextView mother;
    public final LinearLayout motherLL;
    public final TextView noDocumentsAvailable;
    public final TextView notBorn;
    public final LinearLayout notBornLL;
    public final Button notRecommended;
    public final TextView orAnnex;
    public final TextView orAnnex2;
    public final ImageView photoUrl;
    public final TextView preRevision;
    public final LinearLayout preRevisionLL;
    public final ImageView preRevisionVoterDocUrl;
    public final ImageView preRevisionVoterDocUrl2;
    public final ImageView relationProofDocUrl;
    public final ImageView relationProofDocUrlPg2;
    public final TextView relationProofText;
    public final LinearLayout relationProofTextLL;
    public final TextView relationSuppText;
    public final LinearLayout relationSuppTextLL;
    public final ImageView relationSupportingDocUrl;
    public final ImageView relationSupportingDocUrlPg2;
    private final LinearLayout rootView;
    public final TextView self;
    public final LinearLayout selfLL;
    public final ImageView srFormPage1Url;
    public final ImageView srFormPage2Url;
    public final Button submitButtonRec;
    public final LinearLayout submitLayout;
    public final TextView textView3;
    public final Button updateData;

    private ActivityViewFormByAerodocumentsBhBinding(LinearLayout rootView, TextView annexure, LinearLayout annexureLL, ImageView annexureUrl, ImageView backBtnIv, ConstraintLayout blaTopLayout, TextView electorPhoto, LinearLayout electorPhotoLL, TextView enumeration, LinearLayout enumerationLL, TextView father, LinearLayout fatherLL, TextView indianCitizen, LinearLayout indianCitizenLL, ImageView list1DocUrl, ImageView list1DocUrl2, ImageView list3DocUrl, ImageView list3DocUrl2, ImageView list4DocUrl, ImageView list4DocUrl2, TextView list5, ImageView list5DocUrl, ImageView list5DocUrl2, ImageView list5DocUrl3, LinearLayout list5LL, ImageView list6DocUrl, ImageView list6docUrl2, ImageView list7DocUr2, ImageView list7DocUrl, LinearLayout main, TextView mother, LinearLayout motherLL, TextView noDocumentsAvailable, TextView notBorn, LinearLayout notBornLL, Button notRecommended, TextView orAnnex, TextView orAnnex2, ImageView photoUrl, TextView preRevision, LinearLayout preRevisionLL, ImageView preRevisionVoterDocUrl, ImageView preRevisionVoterDocUrl2, ImageView relationProofDocUrl, ImageView relationProofDocUrlPg2, TextView relationProofText, LinearLayout relationProofTextLL, TextView relationSuppText, LinearLayout relationSuppTextLL, ImageView relationSupportingDocUrl, ImageView relationSupportingDocUrlPg2, TextView self, LinearLayout selfLL, ImageView srFormPage1Url, ImageView srFormPage2Url, Button submitButtonRec, LinearLayout submitLayout, TextView textView3, Button updateData) {
        this.rootView = rootView;
        this.annexure = annexure;
        this.annexureLL = annexureLL;
        this.annexureUrl = annexureUrl;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.electorPhoto = electorPhoto;
        this.electorPhotoLL = electorPhotoLL;
        this.enumeration = enumeration;
        this.enumerationLL = enumerationLL;
        this.father = father;
        this.fatherLL = fatherLL;
        this.indianCitizen = indianCitizen;
        this.indianCitizenLL = indianCitizenLL;
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
        this.list5LL = list5LL;
        this.list6DocUrl = list6DocUrl;
        this.list6docUrl2 = list6docUrl2;
        this.list7DocUr2 = list7DocUr2;
        this.list7DocUrl = list7DocUrl;
        this.main = main;
        this.mother = mother;
        this.motherLL = motherLL;
        this.noDocumentsAvailable = noDocumentsAvailable;
        this.notBorn = notBorn;
        this.notBornLL = notBornLL;
        this.notRecommended = notRecommended;
        this.orAnnex = orAnnex;
        this.orAnnex2 = orAnnex2;
        this.photoUrl = photoUrl;
        this.preRevision = preRevision;
        this.preRevisionLL = preRevisionLL;
        this.preRevisionVoterDocUrl = preRevisionVoterDocUrl;
        this.preRevisionVoterDocUrl2 = preRevisionVoterDocUrl2;
        this.relationProofDocUrl = relationProofDocUrl;
        this.relationProofDocUrlPg2 = relationProofDocUrlPg2;
        this.relationProofText = relationProofText;
        this.relationProofTextLL = relationProofTextLL;
        this.relationSuppText = relationSuppText;
        this.relationSuppTextLL = relationSuppTextLL;
        this.relationSupportingDocUrl = relationSupportingDocUrl;
        this.relationSupportingDocUrlPg2 = relationSupportingDocUrlPg2;
        this.self = self;
        this.selfLL = selfLL;
        this.srFormPage1Url = srFormPage1Url;
        this.srFormPage2Url = srFormPage2Url;
        this.submitButtonRec = submitButtonRec;
        this.submitLayout = submitLayout;
        this.textView3 = textView3;
        this.updateData = updateData;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityViewFormByAerodocumentsBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityViewFormByAerodocumentsBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_view_form_by_aerodocuments_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityViewFormByAerodocumentsBhBinding bind(View rootView) {
        int i = R.id.annexure;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.annexure);
        if (textView != null) {
            i = R.id.annexureLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexureLL);
            if (linearLayout != null) {
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
                                i = R.id.electorPhotoLL;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorPhotoLL);
                                if (linearLayout2 != null) {
                                    i = R.id.enumeration;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumeration);
                                    if (textView3 != null) {
                                        i = R.id.enumerationLL;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationLL);
                                        if (linearLayout3 != null) {
                                            i = R.id.father;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.father);
                                            if (textView4 != null) {
                                                i = R.id.fatherLL;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fatherLL);
                                                if (linearLayout4 != null) {
                                                    i = R.id.indianCitizen;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indianCitizen);
                                                    if (textView5 != null) {
                                                        i = R.id.indianCitizenLL;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.indianCitizenLL);
                                                        if (linearLayout5 != null) {
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
                                                                                                    i = R.id.list5LL;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.list5LL);
                                                                                                    if (linearLayout6 != null) {
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
                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) rootView;
                                                                                                                        i = R.id.mother;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mother);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i = R.id.motherLL;
                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.motherLL);
                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                i = R.id.noDocumentsAvailable;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noDocumentsAvailable);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.notBorn;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notBorn);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.notBornLL;
                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.notBornLL);
                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                            i = R.id.notRecommended;
                                                                                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.notRecommended);
                                                                                                                                            if (button != null) {
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
                                                                                                                                                                i = R.id.preRevisionLL;
                                                                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.preRevisionLL);
                                                                                                                                                                if (linearLayout10 != null) {
                                                                                                                                                                    i = R.id.preRevisionVoterDocUrl;
                                                                                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preRevisionVoterDocUrl);
                                                                                                                                                                    if (imageView17 != null) {
                                                                                                                                                                        i = R.id.preRevisionVoterDocUrl2;
                                                                                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preRevisionVoterDocUrl2);
                                                                                                                                                                        if (imageView18 != null) {
                                                                                                                                                                            i = R.id.relationProofDocUrl;
                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.relationProofDocUrl);
                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                i = R.id.relationProofDocUrlPg2;
                                                                                                                                                                                ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.relationProofDocUrlPg2);
                                                                                                                                                                                if (imageView20 != null) {
                                                                                                                                                                                    i = R.id.relationProofText;
                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationProofText);
                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                        i = R.id.relationProofTextLL;
                                                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relationProofTextLL);
                                                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                                                            i = R.id.relationSuppText;
                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationSuppText);
                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                i = R.id.relationSuppTextLL;
                                                                                                                                                                                                LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relationSuppTextLL);
                                                                                                                                                                                                if (linearLayout12 != null) {
                                                                                                                                                                                                    i = R.id.relationSupportingDocUrl;
                                                                                                                                                                                                    ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.relationSupportingDocUrl);
                                                                                                                                                                                                    if (imageView21 != null) {
                                                                                                                                                                                                        i = R.id.relationSupportingDocUrlPg2;
                                                                                                                                                                                                        ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.relationSupportingDocUrlPg2);
                                                                                                                                                                                                        if (imageView22 != null) {
                                                                                                                                                                                                            i = R.id.self;
                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                i = R.id.selfLL;
                                                                                                                                                                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.selfLL);
                                                                                                                                                                                                                if (linearLayout13 != null) {
                                                                                                                                                                                                                    i = R.id.srFormPage1Url;
                                                                                                                                                                                                                    ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.srFormPage1Url);
                                                                                                                                                                                                                    if (imageView23 != null) {
                                                                                                                                                                                                                        i = R.id.srFormPage2Url;
                                                                                                                                                                                                                        ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.srFormPage2Url);
                                                                                                                                                                                                                        if (imageView24 != null) {
                                                                                                                                                                                                                            i = R.id.submitButtonRec;
                                                                                                                                                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submitButtonRec);
                                                                                                                                                                                                                            if (button2 != null) {
                                                                                                                                                                                                                                i = R.id.submitLayout;
                                                                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submitLayout);
                                                                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                                                                    i = R.id.textView3;
                                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                                        i = R.id.updateData;
                                                                                                                                                                                                                                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.updateData);
                                                                                                                                                                                                                                        if (button3 != null) {
                                                                                                                                                                                                                                            return new ActivityViewFormByAerodocumentsBhBinding(linearLayout7, textView, linearLayout, imageView, imageView2, constraintLayoutFindChildViewById, textView2, linearLayout2, textView3, linearLayout3, textView4, linearLayout4, textView5, linearLayout5, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, textView6, imageView9, imageView10, imageView11, linearLayout6, imageView12, imageView13, imageView14, imageView15, linearLayout7, textView7, linearLayout8, textView8, textView9, linearLayout9, button, textView10, textView11, imageView16, textView12, linearLayout10, imageView17, imageView18, imageView19, imageView20, textView13, linearLayout11, textView14, linearLayout12, imageView21, imageView22, textView15, linearLayout13, imageView23, imageView24, button2, linearLayout14, textView16, button3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
