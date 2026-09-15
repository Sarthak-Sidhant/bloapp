package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class PopupVoiceBinding implements ViewBinding {
    public final Button btnStartListening;
    public final ImageView cross;
    public final EditText editTextVoice;
    public final ImageView ivwave;
    public final ProgressBar progressListening;
    private final LinearLayout rootView;

    private PopupVoiceBinding(LinearLayout rootView, Button btnStartListening, ImageView cross, EditText editTextVoice, ImageView ivwave, ProgressBar progressListening) {
        this.rootView = rootView;
        this.btnStartListening = btnStartListening;
        this.cross = cross;
        this.editTextVoice = editTextVoice;
        this.ivwave = ivwave;
        this.progressListening = progressListening;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PopupVoiceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PopupVoiceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.popup_voice, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PopupVoiceBinding bind(View rootView) {
        int i = R.id.btnStartListening;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnStartListening);
        if (button != null) {
            i = R.id.cross;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
            if (imageView != null) {
                i = R.id.editTextVoice;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.editTextVoice);
                if (editText != null) {
                    i = R.id.ivwave;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivwave);
                    if (imageView2 != null) {
                        i = R.id.progressListening;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressListening);
                        if (progressBar != null) {
                            return new PopupVoiceBinding((LinearLayout) rootView, button, imageView, editText, imageView2, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
