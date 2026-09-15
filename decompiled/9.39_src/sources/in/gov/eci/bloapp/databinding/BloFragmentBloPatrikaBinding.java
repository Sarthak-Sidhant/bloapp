package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentBloPatrikaBinding implements ViewBinding {
    public final Button downloadPatrika;
    public final LinearLayout downloadPatrikaLayout;
    public final FloatingActionButton floatingActionButton;
    public final FloatingActionButton floatingActionButton4;
    public final FloatingActionButton floatingActionButton5;
    public final PDFView pdfView;
    public final RelativeLayout pdfViewLayout;
    public final CircularProgressIndicator progressCircular;
    private final ConstraintLayout rootView;

    private BloFragmentBloPatrikaBinding(ConstraintLayout rootView, Button downloadPatrika, LinearLayout downloadPatrikaLayout, FloatingActionButton floatingActionButton, FloatingActionButton floatingActionButton4, FloatingActionButton floatingActionButton5, PDFView pdfView, RelativeLayout pdfViewLayout, CircularProgressIndicator progressCircular) {
        this.rootView = rootView;
        this.downloadPatrika = downloadPatrika;
        this.downloadPatrikaLayout = downloadPatrikaLayout;
        this.floatingActionButton = floatingActionButton;
        this.floatingActionButton4 = floatingActionButton4;
        this.floatingActionButton5 = floatingActionButton5;
        this.pdfView = pdfView;
        this.pdfViewLayout = pdfViewLayout;
        this.progressCircular = progressCircular;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentBloPatrikaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentBloPatrikaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_blo_patrika, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentBloPatrikaBinding bind(View rootView) {
        int i = R.id.downloadPatrika;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.downloadPatrika);
        if (button != null) {
            i = R.id.downloadPatrikaLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.downloadPatrikaLayout);
            if (linearLayout != null) {
                i = R.id.floatingActionButton;
                FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.floatingActionButton);
                if (floatingActionButtonFindChildViewById != null) {
                    i = R.id.floatingActionButton4;
                    FloatingActionButton floatingActionButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.floatingActionButton4);
                    if (floatingActionButtonFindChildViewById2 != null) {
                        i = R.id.floatingActionButton5;
                        FloatingActionButton floatingActionButtonFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.floatingActionButton5);
                        if (floatingActionButtonFindChildViewById3 != null) {
                            i = R.id.pdfView;
                            PDFView pDFViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pdfView);
                            if (pDFViewFindChildViewById != null) {
                                i = R.id.pdfViewLayout;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pdfViewLayout);
                                if (relativeLayout != null) {
                                    i = 2131365277;
                                    CircularProgressIndicator circularProgressIndicatorFindChildViewById = ViewBindings.findChildViewById(rootView, 2131365277);
                                    if (circularProgressIndicatorFindChildViewById != null) {
                                        return new BloFragmentBloPatrikaBinding((ConstraintLayout) rootView, button, linearLayout, floatingActionButtonFindChildViewById, floatingActionButtonFindChildViewById2, floatingActionButtonFindChildViewById3, pDFViewFindChildViewById, relativeLayout, circularProgressIndicatorFindChildViewById);
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
