package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ChecklistFormAddDocBinding implements ViewBinding {
    public final ImageButton addDocButton;
    public final LinearLayout addDocCerti;
    public final TextView addDocChooseFile;
    public final ImageView addDocDelete;
    public final ImageView addDocPhoto;
    public final TextView addDocPhotoname;
    public final TextView addDocSize;
    public final LinearLayout addDocState1Layout;
    public final NoDefaultSpinner addDocumentSpinner;
    public final LinearLayout annexureD;
    public final CheckBox cbNotsubmittedAddDoc;
    public final LinearLayout cvDoc;
    public final ChecklistOfflineFormPhotoBinding includeOfflineDoc;
    public final LinearLayout lvTitle;
    private final ConstraintLayout rootView;
    public final TextView tvAddDocEditTextview;
    public final View viewAddDocSpinner;

    private ChecklistFormAddDocBinding(ConstraintLayout rootView, ImageButton addDocButton, LinearLayout addDocCerti, TextView addDocChooseFile, ImageView addDocDelete, ImageView addDocPhoto, TextView addDocPhotoname, TextView addDocSize, LinearLayout addDocState1Layout, NoDefaultSpinner addDocumentSpinner, LinearLayout annexureD, CheckBox cbNotsubmittedAddDoc, LinearLayout cvDoc, ChecklistOfflineFormPhotoBinding includeOfflineDoc, LinearLayout lvTitle, TextView tvAddDocEditTextview, View viewAddDocSpinner) {
        this.rootView = rootView;
        this.addDocButton = addDocButton;
        this.addDocCerti = addDocCerti;
        this.addDocChooseFile = addDocChooseFile;
        this.addDocDelete = addDocDelete;
        this.addDocPhoto = addDocPhoto;
        this.addDocPhotoname = addDocPhotoname;
        this.addDocSize = addDocSize;
        this.addDocState1Layout = addDocState1Layout;
        this.addDocumentSpinner = addDocumentSpinner;
        this.annexureD = annexureD;
        this.cbNotsubmittedAddDoc = cbNotsubmittedAddDoc;
        this.cvDoc = cvDoc;
        this.includeOfflineDoc = includeOfflineDoc;
        this.lvTitle = lvTitle;
        this.tvAddDocEditTextview = tvAddDocEditTextview;
        this.viewAddDocSpinner = viewAddDocSpinner;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChecklistFormAddDocBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChecklistFormAddDocBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.checklist_form_add_doc, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChecklistFormAddDocBinding bind(View rootView) {
        int i = R.id.add_doc_button;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.add_doc_button);
        if (imageButton != null) {
            i = R.id.add_doc_certi;
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
                                                i = R.id.cb_notsubmitted_add_doc;
                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.cb_notsubmitted_add_doc);
                                                if (checkBox != null) {
                                                    i = R.id.cv_doc;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cv_doc);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.includeOfflineDoc;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.includeOfflineDoc);
                                                        if (viewFindChildViewById != null) {
                                                            ChecklistOfflineFormPhotoBinding checklistOfflineFormPhotoBindingBind = ChecklistOfflineFormPhotoBinding.bind(viewFindChildViewById);
                                                            i = R.id.lvTitle;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lvTitle);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.tv_add_doc_edit_textview;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_add_doc_edit_textview);
                                                                if (textView4 != null) {
                                                                    i = R.id.view_add_doc_spinner;
                                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_add_doc_spinner);
                                                                    if (viewFindChildViewById2 != null) {
                                                                        return new ChecklistFormAddDocBinding((ConstraintLayout) rootView, imageButton, linearLayout, textView, imageView, imageView2, textView2, textView3, linearLayout2, noDefaultSpinner, linearLayout3, checkBox, linearLayout4, checklistOfflineFormPhotoBindingBind, linearLayout5, textView4, viewFindChildViewById2);
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
