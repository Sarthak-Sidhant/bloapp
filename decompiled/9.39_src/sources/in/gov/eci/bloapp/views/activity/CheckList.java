package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityCheckListBinding;
import in.gov.eci.bloapp.views.fragments.checklist.CheckListMain;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CheckList extends Hilt_CheckList {
    private BloActivityCheckListBinding binding;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityCheckListBinding bloActivityCheckListBindingInflate = BloActivityCheckListBinding.inflate(getLayoutInflater());
        this.binding = bloActivityCheckListBindingInflate;
        setContentView((View) bloActivityCheckListBindingInflate.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main, new CheckListMain()).commitAllowingStateLoss();
        }
    }
}
