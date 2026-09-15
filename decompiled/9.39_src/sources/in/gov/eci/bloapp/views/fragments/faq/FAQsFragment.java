package in.gov.eci.bloapp.views.fragments.faq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloFragmentFaqsBinding;
import in.gov.eci.bloapp.model.app_model.ExpandModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FAQsFragment extends Fragment {
    private BloFragmentFaqsBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentFaqsBinding.inflate(inflater, container, false);
        setData();
        ExpandAdapter expandAdapter = new ExpandAdapter(getContext());
        this.binding.fragmentBooksearchSearchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.binding.fragmentBooksearchSearchResultsRecyclerView.setAdapter(expandAdapter);
        expandAdapter.setResults(setData());
        return this.binding.getRoot();
    }

    private ArrayList<ExpandModel> setData() {
        ExpandModel expandModel = new ExpandModel(getResources().getString(R.string.blo_faq_q_one), getResources().getString(R.string.blo_ans), null, false);
        ExpandModel expandModel2 = new ExpandModel(getResources().getString(R.string.blo_faq_q_two), getResources().getString(R.string.blo_ans_two), null, false);
        ExpandModel expandModel3 = new ExpandModel(getResources().getString(R.string.blo_faq_q_three), getResources().getString(R.string.blo_ans_three), null, false);
        ExpandModel expandModel4 = new ExpandModel(getResources().getString(R.string.blo_faq_q_four), getResources().getString(R.string.blo_ans_four), null, false);
        ExpandModel expandModel5 = new ExpandModel(getResources().getString(R.string.blo_faq_q_five), getResources().getString(R.string.blo_ans_five), null, false);
        ExpandModel expandModel6 = new ExpandModel(getResources().getString(R.string.blo_faq_q_six), getResources().getString(R.string.blo_ans_six), null, false);
        ExpandModel expandModel7 = new ExpandModel(getResources().getString(R.string.blo_faq_q_seven), getResources().getString(R.string.blo_ans_seven), null, false);
        ExpandModel expandModel8 = new ExpandModel(getResources().getString(R.string.blo_faq_q_eight), getResources().getString(R.string.blo_ans_eight), null, false);
        ExpandModel expandModel9 = new ExpandModel(getResources().getString(R.string.blo_faq_q_nine), getResources().getString(R.string.blo_ans_nine), null, false);
        ArrayList<ExpandModel> arrayList = new ArrayList<>();
        arrayList.add(expandModel);
        arrayList.add(expandModel2);
        arrayList.add(expandModel3);
        arrayList.add(expandModel4);
        arrayList.add(expandModel5);
        arrayList.add(expandModel6);
        arrayList.add(expandModel7);
        arrayList.add(expandModel8);
        arrayList.add(expandModel9);
        return arrayList;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
