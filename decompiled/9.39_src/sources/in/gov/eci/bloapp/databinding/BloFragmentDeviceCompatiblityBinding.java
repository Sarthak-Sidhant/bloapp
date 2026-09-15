package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentDeviceCompatiblityBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ImageView camIm2;
    public final TextView camTx2;
    public final ImageView carrierIm2;
    public final TextView carrierTx2;
    public final ConstraintLayout constraintLayout;
    public final ImageView devicemodelIm2;
    public final TextView devicemodelTx2;
    public final ImageView internetIm2;
    public final TextView internetTx2;
    public final ImageView locationIm2;
    public final TextView locationTx2;
    public final View mainDivider;
    public final TextView mainheadingTv;
    public final ImageView memoryIm2;
    public final TextView memoryTx2;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final Button searchBtn;
    public final ImageView softwareIm2;
    public final TextView softwareTx2;
    public final ImageView storageIm2;
    public final TextView storageTx2;
    public final ImageView totalStorageIm2;
    public final TextView totalStorageTx2;

    private BloFragmentDeviceCompatiblityBinding(ConstraintLayout rootView, ImageView backBtnIv, ImageView camIm2, TextView camTx2, ImageView carrierIm2, TextView carrierTx2, ConstraintLayout constraintLayout, ImageView devicemodelIm2, TextView devicemodelTx2, ImageView internetIm2, TextView internetTx2, ImageView locationIm2, TextView locationTx2, View mainDivider, TextView mainheadingTv, ImageView memoryIm2, TextView memoryTx2, ScrollView scrollView, Button searchBtn, ImageView softwareIm2, TextView softwareTx2, ImageView storageIm2, TextView storageTx2, ImageView totalStorageIm2, TextView totalStorageTx2) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.camIm2 = camIm2;
        this.camTx2 = camTx2;
        this.carrierIm2 = carrierIm2;
        this.carrierTx2 = carrierTx2;
        this.constraintLayout = constraintLayout;
        this.devicemodelIm2 = devicemodelIm2;
        this.devicemodelTx2 = devicemodelTx2;
        this.internetIm2 = internetIm2;
        this.internetTx2 = internetTx2;
        this.locationIm2 = locationIm2;
        this.locationTx2 = locationTx2;
        this.mainDivider = mainDivider;
        this.mainheadingTv = mainheadingTv;
        this.memoryIm2 = memoryIm2;
        this.memoryTx2 = memoryTx2;
        this.scrollView = scrollView;
        this.searchBtn = searchBtn;
        this.softwareIm2 = softwareIm2;
        this.softwareTx2 = softwareTx2;
        this.storageIm2 = storageIm2;
        this.storageTx2 = storageTx2;
        this.totalStorageIm2 = totalStorageIm2;
        this.totalStorageTx2 = totalStorageTx2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentDeviceCompatiblityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentDeviceCompatiblityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_device_compatiblity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentDeviceCompatiblityBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cam_im2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cam_im2);
            if (imageView2 != null) {
                i = R.id.cam_tx2;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cam_tx2);
                if (textView != null) {
                    i = R.id.carrier_im2;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.carrier_im2);
                    if (imageView3 != null) {
                        i = R.id.carrier_tx2;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.carrier_tx2);
                        if (textView2 != null) {
                            i = R.id.constraintLayout;
                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                            if (constraintLayoutFindChildViewById != null) {
                                i = R.id.devicemodel_im2;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.devicemodel_im2);
                                if (imageView4 != null) {
                                    i = R.id.devicemodel_tx2;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.devicemodel_tx2);
                                    if (textView3 != null) {
                                        i = R.id.internet_im2;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.internet_im2);
                                        if (imageView5 != null) {
                                            i = R.id.internet_tx2;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.internet_tx2);
                                            if (textView4 != null) {
                                                i = R.id.location_im2;
                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.location_im2);
                                                if (imageView6 != null) {
                                                    i = R.id.location_tx2;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.location_tx2);
                                                    if (textView5 != null) {
                                                        i = R.id.main_divider;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.main_divider);
                                                        if (viewFindChildViewById != null) {
                                                            i = R.id.mainheading_tv;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mainheading_tv);
                                                            if (textView6 != null) {
                                                                i = R.id.memory_im2;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.memory_im2);
                                                                if (imageView7 != null) {
                                                                    i = R.id.memory_tx2;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.memory_tx2);
                                                                    if (textView7 != null) {
                                                                        i = 2131365580;
                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, 2131365580);
                                                                        if (scrollView != null) {
                                                                            i = R.id.search_btn;
                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.search_btn);
                                                                            if (button != null) {
                                                                                i = R.id.software_im2;
                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.software_im2);
                                                                                if (imageView8 != null) {
                                                                                    i = R.id.software_tx2;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.software_tx2);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.storage_im2;
                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.storage_im2);
                                                                                        if (imageView9 != null) {
                                                                                            i = R.id.storage_tx2;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.storage_tx2);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.total_storage_im2;
                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.total_storage_im2);
                                                                                                if (imageView10 != null) {
                                                                                                    i = R.id.total_storage_tx2;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_storage_tx2);
                                                                                                    if (textView10 != null) {
                                                                                                        return new BloFragmentDeviceCompatiblityBinding((ConstraintLayout) rootView, imageView, imageView2, textView, imageView3, textView2, constraintLayoutFindChildViewById, imageView4, textView3, imageView5, textView4, imageView6, textView5, viewFindChildViewById, textView6, imageView7, textView7, scrollView, button, imageView8, textView8, imageView9, textView9, imageView10, textView10);
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
