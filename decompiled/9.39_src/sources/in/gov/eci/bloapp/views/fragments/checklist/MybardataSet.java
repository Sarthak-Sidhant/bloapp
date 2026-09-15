package in.gov.eci.bloapp.views.fragments.checklist;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MybardataSet extends BarDataSet {
    public MybardataSet(List<BarEntry> yVals, String label) {
        super(yVals, label);
    }

    public int getColor(int index) {
        return ((Integer) this.mColors.get(1)).intValue();
    }
}
