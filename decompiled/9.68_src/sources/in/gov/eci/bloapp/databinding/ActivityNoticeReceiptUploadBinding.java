package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityNoticeReceiptUploadBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final ImageView deleteuploadReceipt;
    public final LinearLayout electorImageLL;
    public final LinearLayout generatedNoticeLL;
    public final TextView genertedDocName;
    public final ImageView ivGenertedDocReceipt;
    public final ImageView ivUploadReceipt;
    public final LinearLayout main;
    public final TextView photo1Name;
    public final TextView photo1Size;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvUploadImage;
    public final TextView tvUploadReceipt;

    private ActivityNoticeReceiptUploadBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, ImageView deleteuploadReceipt, LinearLayout electorImageLL, LinearLayout generatedNoticeLL, TextView genertedDocName, ImageView ivGenertedDocReceipt, ImageView ivUploadReceipt, LinearLayout main, TextView photo1Name, TextView photo1Size, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvUploadImage, TextView tvUploadReceipt) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.deleteuploadReceipt = deleteuploadReceipt;
        this.electorImageLL = electorImageLL;
        this.generatedNoticeLL = generatedNoticeLL;
        this.genertedDocName = genertedDocName;
        this.ivGenertedDocReceipt = ivGenertedDocReceipt;
        this.ivUploadReceipt = ivUploadReceipt;
        this.main = main;
        this.photo1Name = photo1Name;
        this.photo1Size = photo1Size;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvUploadImage = tvUploadImage;
        this.tvUploadReceipt = tvUploadReceipt;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNoticeReceiptUploadBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNoticeReceiptUploadBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_notice_receipt_upload, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNoticeReceiptUploadBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.deleteupload_receipt;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteupload_receipt);
                if (imageView2 != null) {
                    i = R.id.electorImageLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorImageLL);
                    if (linearLayout != null) {
                        i = R.id.generatedNoticeLL;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.generatedNoticeLL);
                        if (linearLayout2 != null) {
                            i = R.id.generted_doc_name;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.generted_doc_name);
                            if (textView != null) {
                                i = R.id.iv_generted_doc_receipt;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_generted_doc_receipt);
                                if (imageView3 != null) {
                                    i = R.id.iv_upload_receipt;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_upload_receipt);
                                    if (imageView4 != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) rootView;
                                        i = R.id.photo1_name;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_name);
                                        if (textView2 != null) {
                                            i = R.id.photo1_size;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_size);
                                            if (textView3 != null) {
                                                i = R.id.textView3;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                if (textView4 != null) {
                                                    i = R.id.textView5;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                    if (textView5 != null) {
                                                        i = R.id.toolbar_button;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                        if (imageView5 != null) {
                                                            i = R.id.tv_upload_image;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_upload_image);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_upload_receipt;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_upload_receipt);
                                                                if (textView7 != null) {
                                                                    return new ActivityNoticeReceiptUploadBinding(linearLayout3, imageView, constraintLayoutFindChildViewById, imageView2, linearLayout, linearLayout2, textView, imageView3, imageView4, linearLayout3, textView2, textView3, textView4, textView5, imageView5, textView6, textView7);
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
