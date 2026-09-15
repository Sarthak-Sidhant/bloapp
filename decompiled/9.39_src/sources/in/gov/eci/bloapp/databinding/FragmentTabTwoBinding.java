package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FragmentTabTwoBinding implements ViewBinding {
    public final Button btnSearch;
    public final LinearLayout editableItem;
    public final NestedScrollView formScroll;
    public final CurrentElectorDetailsBinding includeCurrentDetails;
    public final FragmentTabOneBinding includeEdit;
    public final LinearLayout linearRelative;
    public final LinearLayout lvCurrentDetailsEdit;
    public final CardView lvProgenyDetails;
    public final LinearLayout lvRecylerview;
    private final RelativeLayout rootView;
    public final RecyclerView selfMapping;
    public final Spinner spElectorRelative;
    public final ImageView speakGrandparent;
    public final TextView submitButton;
    public final TextView tvRecordCount;
    public final TextView tvRelationtypetitle;
    public final TextView txtDummyRelative;
    public final EditText txtRelativeName;

    private FragmentTabTwoBinding(RelativeLayout rootView, Button btnSearch, LinearLayout editableItem, NestedScrollView formScroll, CurrentElectorDetailsBinding includeCurrentDetails, FragmentTabOneBinding includeEdit, LinearLayout linearRelative, LinearLayout lvCurrentDetailsEdit, CardView lvProgenyDetails, LinearLayout lvRecylerview, RecyclerView selfMapping, Spinner spElectorRelative, ImageView speakGrandparent, TextView submitButton, TextView tvRecordCount, TextView tvRelationtypetitle, TextView txtDummyRelative, EditText txtRelativeName) {
        this.rootView = rootView;
        this.btnSearch = btnSearch;
        this.editableItem = editableItem;
        this.formScroll = formScroll;
        this.includeCurrentDetails = includeCurrentDetails;
        this.includeEdit = includeEdit;
        this.linearRelative = linearRelative;
        this.lvCurrentDetailsEdit = lvCurrentDetailsEdit;
        this.lvProgenyDetails = lvProgenyDetails;
        this.lvRecylerview = lvRecylerview;
        this.selfMapping = selfMapping;
        this.spElectorRelative = spElectorRelative;
        this.speakGrandparent = speakGrandparent;
        this.submitButton = submitButton;
        this.tvRecordCount = tvRecordCount;
        this.tvRelationtypetitle = tvRelationtypetitle;
        this.txtDummyRelative = txtDummyRelative;
        this.txtRelativeName = txtRelativeName;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTabTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTabTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_tab_two, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTabTwoBinding bind(View rootView) {
        int i = R.id.btnSearch;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnSearch);
        if (button != null) {
            i = R.id.editable_item;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.editable_item);
            if (linearLayout != null) {
                i = R.id.formScroll;
                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.formScroll);
                if (nestedScrollViewFindChildViewById != null) {
                    i = R.id.include_current_details;
                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.include_current_details);
                    if (viewFindChildViewById != null) {
                        CurrentElectorDetailsBinding currentElectorDetailsBindingBind = CurrentElectorDetailsBinding.bind(viewFindChildViewById);
                        i = R.id.include_edit;
                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.include_edit);
                        if (viewFindChildViewById2 != null) {
                            FragmentTabOneBinding fragmentTabOneBindingBind = FragmentTabOneBinding.bind(viewFindChildViewById2);
                            i = R.id.linearRelative;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelative);
                            if (linearLayout2 != null) {
                                i = R.id.lv_current_details_edit;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_current_details_edit);
                                if (linearLayout3 != null) {
                                    i = R.id.lv_progeny_details;
                                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.lv_progeny_details);
                                    if (cardViewFindChildViewById != null) {
                                        i = R.id.lv_recylerview;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_recylerview);
                                        if (linearLayout4 != null) {
                                            i = R.id.self_mapping;
                                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.self_mapping);
                                            if (recyclerViewFindChildViewById != null) {
                                                i = R.id.sp_elector_relative;
                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.sp_elector_relative);
                                                if (spinner != null) {
                                                    i = R.id.speak_grandparent;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_grandparent);
                                                    if (imageView != null) {
                                                        i = R.id.submitButton;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitButton);
                                                        if (textView != null) {
                                                            i = R.id.tv_record_count;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_record_count);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_relationtypetitle;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relationtypetitle);
                                                                if (textView3 != null) {
                                                                    i = R.id.txtDummyRelative;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyRelative);
                                                                    if (textView4 != null) {
                                                                        i = R.id.txtRelativeName;
                                                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                        if (editText != null) {
                                                                            return new FragmentTabTwoBinding((RelativeLayout) rootView, button, linearLayout, nestedScrollViewFindChildViewById, currentElectorDetailsBindingBind, fragmentTabOneBindingBind, linearLayout2, linearLayout3, cardViewFindChildViewById, linearLayout4, recyclerViewFindChildViewById, spinner, imageView, textView, textView2, textView3, textView4, editText);
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
