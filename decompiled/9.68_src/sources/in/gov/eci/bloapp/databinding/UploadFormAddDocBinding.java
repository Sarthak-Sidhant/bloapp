package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class UploadFormAddDocBinding implements ViewBinding {
    public final LinearLayout annexureD;
    public final CheckBox cbNotsubmitted;
    public final CardView cvUploadDoc;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;
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

    private UploadFormAddDocBinding(ConstraintLayout rootView, LinearLayout annexureD, CheckBox cbNotsubmitted, CardView cvUploadDoc, TextView tvTitle, LinearLayout uploadDoc1Certi, TextView uploadDoc1ChooseFile, ImageView uploadDoc1Delete, ImageView uploadDoc1Photo, TextView uploadDoc1Photoname, TextView uploadDoc1Size, LinearLayout uploadDoc2Certi, TextView uploadDoc2ChooseFile, ImageView uploadDoc2Delete, ImageView uploadDoc2Photo, TextView uploadDoc2Photoname, TextView uploadDoc2Size) {
        this.rootView = rootView;
        this.annexureD = annexureD;
        this.cbNotsubmitted = cbNotsubmitted;
        this.cvUploadDoc = cvUploadDoc;
        this.tvTitle = tvTitle;
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
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UploadFormAddDocBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UploadFormAddDocBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.upload_form_add_doc, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UploadFormAddDocBinding bind(View rootView) {
        int i = R.id.annexureD;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexureD);
        if (linearLayout != null) {
            i = R.id.cb_notsubmitted;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.cb_notsubmitted);
            if (checkBox != null) {
                i = R.id.cv_upload_doc;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cv_upload_doc);
                if (cardViewFindChildViewById != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_title);
                    if (textView != null) {
                        i = R.id.upload_doc1_certi;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_certi);
                        if (linearLayout2 != null) {
                            i = R.id.upload_doc1_choose_file;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_choose_file);
                            if (textView2 != null) {
                                i = R.id.upload_doc1_delete;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_delete);
                                if (imageView != null) {
                                    i = R.id.upload_doc1_photo;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_photo);
                                    if (imageView2 != null) {
                                        i = R.id.upload_doc1_photoname;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_photoname);
                                        if (textView3 != null) {
                                            i = R.id.upload_doc1_size;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc1_size);
                                            if (textView4 != null) {
                                                i = R.id.upload_doc2_certi;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_certi);
                                                if (linearLayout3 != null) {
                                                    i = R.id.upload_doc2_choose_file;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_choose_file);
                                                    if (textView5 != null) {
                                                        i = R.id.upload_doc2_delete;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_delete);
                                                        if (imageView3 != null) {
                                                            i = R.id.upload_doc2_photo;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_photo);
                                                            if (imageView4 != null) {
                                                                i = R.id.upload_doc2_photoname;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_photoname);
                                                                if (textView6 != null) {
                                                                    i = R.id.upload_doc2_size;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_doc2_size);
                                                                    if (textView7 != null) {
                                                                        return new UploadFormAddDocBinding((ConstraintLayout) rootView, linearLayout, checkBox, cardViewFindChildViewById, textView, linearLayout2, textView2, imageView, imageView2, textView3, textView4, linearLayout3, textView5, imageView3, imageView4, textView6, textView7);
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
