package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class FormAddDocBinding implements ViewBinding {
    public final LinearLayout addDocCerti;
    public final TextView addDocChooseFile;
    public final ImageView addDocDelete;
    public final ImageView addDocPhoto;
    public final TextView addDocPhotoname;
    public final TextView addDocSize;
    public final LinearLayout addDocState1Layout;
    public final NoDefaultSpinner addDocumentSpinner;
    public final LinearLayout annexureD;
    public final LinearLayout bottomMainLayout;
    public final CardView cvAddDoc;
    private final ConstraintLayout rootView;
    public final UploadFormAddDocBinding uploadDocIncludedLayout;
    public final View viewAddDocSpinner;

    private FormAddDocBinding(ConstraintLayout rootView, LinearLayout addDocCerti, TextView addDocChooseFile, ImageView addDocDelete, ImageView addDocPhoto, TextView addDocPhotoname, TextView addDocSize, LinearLayout addDocState1Layout, NoDefaultSpinner addDocumentSpinner, LinearLayout annexureD, LinearLayout bottomMainLayout, CardView cvAddDoc, UploadFormAddDocBinding uploadDocIncludedLayout, View viewAddDocSpinner) {
        this.rootView = rootView;
        this.addDocCerti = addDocCerti;
        this.addDocChooseFile = addDocChooseFile;
        this.addDocDelete = addDocDelete;
        this.addDocPhoto = addDocPhoto;
        this.addDocPhotoname = addDocPhotoname;
        this.addDocSize = addDocSize;
        this.addDocState1Layout = addDocState1Layout;
        this.addDocumentSpinner = addDocumentSpinner;
        this.annexureD = annexureD;
        this.bottomMainLayout = bottomMainLayout;
        this.cvAddDoc = cvAddDoc;
        this.uploadDocIncludedLayout = uploadDocIncludedLayout;
        this.viewAddDocSpinner = viewAddDocSpinner;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FormAddDocBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FormAddDocBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.form_add_doc, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FormAddDocBinding bind(View rootView) {
        int i = R.id.add_doc_certi;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.add_doc_certi);
        if (linearLayout != null) {
            i = R.id.add_doc_choose_file;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc_choose_file);
            if (textView != null) {
                i = R.id.add_doc_delete;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc_delete);
                if (imageView != null) {
                    i = R.id.add_doc_photo;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc_photo);
                    if (imageView2 != null) {
                        i = R.id.add_doc_photoname;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc_photoname);
                        if (textView2 != null) {
                            i = R.id.add_doc_size;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc_size);
                            if (textView3 != null) {
                                i = R.id.add_doc_state1_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.add_doc_state1_layout);
                                if (linearLayout2 != null) {
                                    i = R.id.add_document_spinner;
                                    NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.add_document_spinner);
                                    if (noDefaultSpinner != null) {
                                        i = R.id.annexureD;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexureD);
                                        if (linearLayout3 != null) {
                                            i = R.id.bottom_main_layout;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottom_main_layout);
                                            if (linearLayout4 != null) {
                                                i = R.id.cv_add_doc;
                                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cv_add_doc);
                                                if (cardViewFindChildViewById != null) {
                                                    i = R.id.uploadDocIncludedLayout;
                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.uploadDocIncludedLayout);
                                                    if (viewFindChildViewById != null) {
                                                        UploadFormAddDocBinding uploadFormAddDocBindingBind = UploadFormAddDocBinding.bind(viewFindChildViewById);
                                                        i = R.id.view_add_doc_spinner;
                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_add_doc_spinner);
                                                        if (viewFindChildViewById2 != null) {
                                                            return new FormAddDocBinding((ConstraintLayout) rootView, linearLayout, textView, imageView, imageView2, textView2, textView3, linearLayout2, noDefaultSpinner, linearLayout3, linearLayout4, cardViewFindChildViewById, uploadFormAddDocBindingBind, viewFindChildViewById2);
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
