package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPwdFragmentBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    public final TextView noDataFound;
    public final RecyclerView pwdRequest;
    public final NoDefaultSpinner requestType;
    private final ConstraintLayout rootView;
    public final NoDefaultSpinner status;
    public final NoDefaultSpinner statusValue;
    public final LinearLayout statusValueLayout;
    public final TextView textView3;
    public final ImageView vector;
    public final View viewLine;
    public final View viewLine1;

    private BloFragmentPwdFragmentBinding(ConstraintLayout rootView, ConstraintLayout constraintLayout, TextView noDataFound, RecyclerView pwdRequest, NoDefaultSpinner requestType, NoDefaultSpinner status, NoDefaultSpinner statusValue, LinearLayout statusValueLayout, TextView textView3, ImageView vector, View viewLine, View viewLine1) {
        this.rootView = rootView;
        this.constraintLayout = constraintLayout;
        this.noDataFound = noDataFound;
        this.pwdRequest = pwdRequest;
        this.requestType = requestType;
        this.status = status;
        this.statusValue = statusValue;
        this.statusValueLayout = statusValueLayout;
        this.textView3 = textView3;
        this.vector = vector;
        this.viewLine = viewLine;
        this.viewLine1 = viewLine1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPwdFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPwdFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_pwd_fragment, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPwdFragmentBinding bind(View rootView) {
        int i = R.id.constraintLayout;
        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
        if (constraintLayoutFindChildViewById != null) {
            i = R.id.noDataFound;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.noDataFound);
            if (textView != null) {
                i = R.id.pwd_request;
                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pwd_request);
                if (recyclerViewFindChildViewById != null) {
                    i = R.id.request_type;
                    NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.request_type);
                    if (noDefaultSpinner != null) {
                        i = R.id.status;
                        NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.status);
                        if (noDefaultSpinner2 != null) {
                            i = R.id.status_value;
                            NoDefaultSpinner noDefaultSpinner3 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.status_value);
                            if (noDefaultSpinner3 != null) {
                                i = R.id.status_value_layout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.status_value_layout);
                                if (linearLayout != null) {
                                    i = R.id.textView3;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                    if (textView2 != null) {
                                        i = R.id.vector;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vector);
                                        if (imageView != null) {
                                            i = R.id.view_line;
                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_line);
                                            if (viewFindChildViewById != null) {
                                                i = R.id.view_line1;
                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_line1);
                                                if (viewFindChildViewById2 != null) {
                                                    return new BloFragmentPwdFragmentBinding((ConstraintLayout) rootView, constraintLayoutFindChildViewById, textView, recyclerViewFindChildViewById, noDefaultSpinner, noDefaultSpinner2, noDefaultSpinner3, linearLayout, textView2, imageView, viewFindChildViewById, viewFindChildViewById2);
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
