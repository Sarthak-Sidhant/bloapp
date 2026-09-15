package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityReceiptUploadBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final ImageView cancel;
    public final TextView chooseFileTv;
    public final ImageView deleteuploadReceipt;
    public final Spinner deliverSpinner;
    public final LinearLayout electorImageLL;
    public final ImageView image;
    public final ImageView ivUploadReceipt;
    public final TextView labelPhoto;
    public final LinearLayout main;
    public final EditText othername;
    public final LinearLayout passPhoto;
    public final LinearLayout passPhotoLayout;
    public final TextView photo1Name;
    public final TextView photo1Size;
    public final TextView photoNameTv2;
    public final TextView photoSize;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvOtherNameLable;
    public final TextView tvUploadImage;
    public final TextView tvUploadReceipt;

    private ActivityReceiptUploadBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, ImageView cancel, TextView chooseFileTv, ImageView deleteuploadReceipt, Spinner deliverSpinner, LinearLayout electorImageLL, ImageView image, ImageView ivUploadReceipt, TextView labelPhoto, LinearLayout main, EditText othername, LinearLayout passPhoto, LinearLayout passPhotoLayout, TextView photo1Name, TextView photo1Size, TextView photoNameTv2, TextView photoSize, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvOtherNameLable, TextView tvUploadImage, TextView tvUploadReceipt) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.cancel = cancel;
        this.chooseFileTv = chooseFileTv;
        this.deleteuploadReceipt = deleteuploadReceipt;
        this.deliverSpinner = deliverSpinner;
        this.electorImageLL = electorImageLL;
        this.image = image;
        this.ivUploadReceipt = ivUploadReceipt;
        this.labelPhoto = labelPhoto;
        this.main = main;
        this.othername = othername;
        this.passPhoto = passPhoto;
        this.passPhotoLayout = passPhotoLayout;
        this.photo1Name = photo1Name;
        this.photo1Size = photo1Size;
        this.photoNameTv2 = photoNameTv2;
        this.photoSize = photoSize;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvOtherNameLable = tvOtherNameLable;
        this.tvUploadImage = tvUploadImage;
        this.tvUploadReceipt = tvUploadReceipt;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityReceiptUploadBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityReceiptUploadBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_receipt_upload, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityReceiptUploadBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.cancel;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                if (imageView2 != null) {
                    i = R.id.choose_file_tv;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv);
                    if (textView != null) {
                        i = R.id.deleteupload_receipt;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteupload_receipt);
                        if (imageView3 != null) {
                            i = R.id.deliver_spinner;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.deliver_spinner);
                            if (spinner != null) {
                                i = R.id.electorImageLL;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorImageLL);
                                if (linearLayout != null) {
                                    i = 2131364258;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364258);
                                    if (imageView4 != null) {
                                        i = R.id.iv_upload_receipt;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_upload_receipt);
                                        if (imageView5 != null) {
                                            i = R.id.labelPhoto;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.labelPhoto);
                                            if (textView2 != null) {
                                                LinearLayout linearLayout2 = (LinearLayout) rootView;
                                                i = R.id.othername;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.othername);
                                                if (editText != null) {
                                                    i = R.id.passPhoto;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.passPhoto);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.pass_photo_layout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pass_photo_layout);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.photo1_name;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_name);
                                                            if (textView3 != null) {
                                                                i = R.id.photo1_size;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_size);
                                                                if (textView4 != null) {
                                                                    i = R.id.photo_name_tv2;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_name_tv2);
                                                                    if (textView5 != null) {
                                                                        i = R.id.photo_size;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_size);
                                                                        if (textView6 != null) {
                                                                            i = R.id.textView3;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                            if (textView7 != null) {
                                                                                i = R.id.textView5;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.toolbar_button;
                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                    if (imageView6 != null) {
                                                                                        i = R.id.tv_other_name_lable;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_other_name_lable);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.tv_upload_image;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_upload_image);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.tv_upload_receipt;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_upload_receipt);
                                                                                                if (textView11 != null) {
                                                                                                    return new ActivityReceiptUploadBinding(linearLayout2, imageView, constraintLayoutFindChildViewById, imageView2, textView, imageView3, spinner, linearLayout, imageView4, imageView5, textView2, linearLayout2, editText, linearLayout3, linearLayout4, textView3, textView4, textView5, textView6, textView7, textView8, imageView6, textView9, textView10, textView11);
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
