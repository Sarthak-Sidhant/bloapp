package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ChecklistOfflineFormPhotoBinding implements ViewBinding {
    public final CardView cvUploadDoc;
    public final LinearLayout offlineForm;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;
    public final TextView tvUploadformDocEditTextview;
    public final LinearLayout uploadDoc1Certi;
    public final TextView uploadDoc1ChooseFile;
    public final ImageView uploadDoc1Delete;
    public final ImageView uploadDoc1Photo;
    public final TextView uploadDoc1Photoname;
    public final TextView uploadDoc1Size;
    public final LinearLayout uploadDoc2Certi;
    public final TextView uploadDoc2ChooseFile;
    public final ImageView uploadDoc2Delete;
    public final ImageView uploadDoc2Photo;
    public final TextView uploadDoc2Photoname;
    public final TextView uploadDoc2Size;
    public final ImageButton uploadformDocButton;

    private ChecklistOfflineFormPhotoBinding(ConstraintLayout rootView, CardView cvUploadDoc, LinearLayout offlineForm, TextView tvTitle, TextView tvUploadformDocEditTextview, LinearLayout uploadDoc1Certi, TextView uploadDoc1ChooseFile, ImageView uploadDoc1Delete, ImageView uploadDoc1Photo, TextView uploadDoc1Photoname, TextView uploadDoc1Size, LinearLayout uploadDoc2Certi, TextView uploadDoc2ChooseFile, ImageView uploadDoc2Delete, ImageView uploadDoc2Photo, TextView uploadDoc2Photoname, TextView uploadDoc2Size, ImageButton uploadformDocButton) {
        this.rootView = rootView;
        this.cvUploadDoc = cvUploadDoc;
        this.offlineForm = offlineForm;
        this.tvTitle = tvTitle;
        this.tvUploadformDocEditTextview = tvUploadformDocEditTextview;
        this.uploadDoc1Certi = uploadDoc1Certi;
        this.uploadDoc1ChooseFile = uploadDoc1ChooseFile;
        this.uploadDoc1Delete = uploadDoc1Delete;
        this.uploadDoc1Photo = uploadDoc1Photo;
        this.uploadDoc1Photoname = uploadDoc1Photoname;
        this.uploadDoc1Size = uploadDoc1Size;
        this.uploadDoc2Certi = uploadDoc2Certi;
        this.uploadDoc2ChooseFile = uploadDoc2ChooseFile;
        this.uploadDoc2Delete = uploadDoc2Delete;
        this.uploadDoc2Photo = uploadDoc2Photo;
        this.uploadDoc2Photoname = uploadDoc2Photoname;
        this.uploadDoc2Size = uploadDoc2Size;
        this.uploadformDocButton = uploadformDocButton;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChecklistOfflineFormPhotoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChecklistOfflineFormPhotoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.checklist_offline_form_photo, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChecklistOfflineFormPhotoBinding bind(View rootView) {
        int i = R.id.cv_upload_doc;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cv_upload_doc);
        if (cardViewFindChildViewById != null) {
            i = R.id.offlineForm;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.offlineForm);
            if (linearLayout != null) {
                i = R.id.tv_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_title);
                if (textView != null) {
                    i = R.id.tv_uploadform_doc_edit_textview;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_uploadform_doc_edit_textview);
                    if (textView2 != null) {
                        i = R.id.upload_doc1_certi;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_certi);
                        if (linearLayout2 != null) {
                            i = R.id.upload_doc1_choose_file;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_choose_file);
                            if (textView3 != null) {
                                i = R.id.upload_doc1_delete;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_delete);
                                if (imageView != null) {
                                    i = R.id.upload_doc1_photo;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_photo);
                                    if (imageView2 != null) {
                                        i = R.id.upload_doc1_photoname;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_photoname);
                                        if (textView4 != null) {
                                            i = R.id.upload_doc1_size;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_size);
                                            if (textView5 != null) {
                                                i = R.id.upload_doc2_certi;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_certi);
                                                if (linearLayout3 != null) {
                                                    i = R.id.upload_doc2_choose_file;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_choose_file);
                                                    if (textView6 != null) {
                                                        i = R.id.upload_doc2_delete;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_delete);
                                                        if (imageView3 != null) {
                                                            i = R.id.upload_doc2_photo;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_photo);
                                                            if (imageView4 != null) {
                                                                i = R.id.upload_doc2_photoname;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_photoname);
                                                                if (textView7 != null) {
                                                                    i = R.id.upload_doc2_size;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_size);
                                                                    if (textView8 != null) {
                                                                        i = R.id.uploadform_doc_button;
                                                                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.uploadform_doc_button);
                                                                        if (imageButton != null) {
                                                                            return new ChecklistOfflineFormPhotoBinding((ConstraintLayout) rootView, cardViewFindChildViewById, linearLayout, textView, textView2, linearLayout2, textView3, imageView, imageView2, textView4, textView5, linearLayout3, textView6, imageView3, imageView4, textView7, textView8, imageButton);
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
