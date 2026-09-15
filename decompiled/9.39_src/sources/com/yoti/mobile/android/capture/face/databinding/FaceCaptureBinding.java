package com.yoti.mobile.android.capture.face.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.view.PreviewView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.capture.face.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FaceCaptureBinding implements ViewBinding {
    public final PreviewView cameraPreview;
    private final View rootView;

    private FaceCaptureBinding(View view, PreviewView previewView) {
        this.rootView = view;
        this.cameraPreview = previewView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static FaceCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.face_capture, viewGroup);
        return bind(viewGroup);
    }

    public static FaceCaptureBinding bind(View view) {
        int i = R.id.cameraPreview;
        PreviewView previewViewFindViewById = view.findViewById(i);
        if (previewViewFindViewById != null) {
            return new FaceCaptureBinding(view, previewViewFindViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
