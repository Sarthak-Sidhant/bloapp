package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityPasswordChangeSuccessfullyBinding implements ViewBinding {
    public final TextView credential;
    public final AppCompatButton login;
    public final NestedScrollView nestedScrollView2;
    private final ConstraintLayout rootView;
    public final TextView successfull;
    public final View vector;
    public final View view;

    private BloActivityPasswordChangeSuccessfullyBinding(ConstraintLayout rootView, TextView credential, AppCompatButton login, NestedScrollView nestedScrollView2, TextView successfull, View vector, View view) {
        this.rootView = rootView;
        this.credential = credential;
        this.login = login;
        this.nestedScrollView2 = nestedScrollView2;
        this.successfull = successfull;
        this.vector = vector;
        this.view = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityPasswordChangeSuccessfullyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityPasswordChangeSuccessfullyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_password_change_successfully, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityPasswordChangeSuccessfullyBinding bind(View rootView) {
        int i = R.id.credential;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.credential);
        if (textView != null) {
            i = R.id.login;
            AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.login);
            if (appCompatButtonFindChildViewById != null) {
                i = R.id.nestedScrollView2;
                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nestedScrollView2);
                if (nestedScrollViewFindChildViewById != null) {
                    i = R.id.successfull;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.successfull);
                    if (textView2 != null) {
                        i = R.id.vector;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.vector);
                        if (viewFindChildViewById != null) {
                            i = R.id.view;
                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view);
                            if (viewFindChildViewById2 != null) {
                                return new BloActivityPasswordChangeSuccessfullyBinding((ConstraintLayout) rootView, textView, appCompatButtonFindChildViewById, nestedScrollViewFindChildViewById, textView2, viewFindChildViewById, viewFindChildViewById2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
