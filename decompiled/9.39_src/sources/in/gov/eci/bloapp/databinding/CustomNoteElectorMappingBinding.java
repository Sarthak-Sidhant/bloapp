package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CustomNoteElectorMappingBinding implements ViewBinding {
    public final TextView noteCustomBlo;
    public final TextView noteCustomSystem;
    private final LinearLayout rootView;

    private CustomNoteElectorMappingBinding(LinearLayout rootView, TextView noteCustomBlo, TextView noteCustomSystem) {
        this.rootView = rootView;
        this.noteCustomBlo = noteCustomBlo;
        this.noteCustomSystem = noteCustomSystem;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomNoteElectorMappingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomNoteElectorMappingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_note_elector_mapping, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomNoteElectorMappingBinding bind(View rootView) {
        int i = R.id.note_custom_blo;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.note_custom_blo);
        if (textView != null) {
            i = R.id.note_custom_system;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note_custom_system);
            if (textView2 != null) {
                return new CustomNoteElectorMappingBinding((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
