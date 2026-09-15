package in.gov.eci.bloapp.views.fragments.checklist;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.StackedValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.databinding.BloFragmentFormsGraphBinding;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormChartFragment extends Fragment {
    private BloFragmentFormsGraphBinding binding;
    BarEntry form6aentry;
    BarEntry form6entry;
    BarEntry form7Oentry;
    BarEntry form7entry;
    BarEntry form8Oentry;
    BarEntry form8entry;
    String formsData;
    CommomUtility commomUtility = new CommomUtility();
    String form_6 = "0";
    String form_6a = "0";
    String form_6b = "0";
    String form_7 = "0";
    String form_8 = "0";
    String form_7O = "0";
    String form_8O = "0";
    String formDataText = "Form Data";
    int[] colorClassArray = {Color.parseColor("#FEB139"), Color.parseColor("#3BACB6"), Color.parseColor("#FF8C8C"), Color.parseColor("#9BA3EB"), Color.parseColor("#000000"), Color.parseColor("#808080")};
    int[] colors1 = {Color.rgb(254, 177, 57), Color.rgb(59, 172, 182), Color.rgb(255, 140, 140), Color.rgb(155, 163, 235), Color.rgb(0, 0, 0), Color.rgb(128, 128, 128)};
    int[] colors2 = {Color.rgb(155, 163, 235), Color.rgb(0, 0, 0), Color.rgb(128, 128, 128)};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentFormsGraphBinding.inflate(getLayoutInflater());
        if (getArguments() != null) {
            this.form_6 = getArguments().getString("form6");
            this.form_6a = getArguments().getString("form6a");
            this.form_7 = getArguments().getString("form7");
            this.form_8 = getArguments().getString("form8");
            this.form_7O = getArguments().getString("form7O");
            this.form_8O = getArguments().getString("form8O");
            Logger.d("FormsChartFragment - ", this.form_6 + " - " + this.form_6a + " - " + this.form_6b + " - " + this.form_7 + " - " + this.form_8 + " - " + this.form_7O + " - " + this.form_8O);
            this.formsData = "Form6 : " + this.form_6 + "\nForm6A : " + this.form_6a + "\nForm7 : " + this.form_7 + "\nForm8 : " + this.form_8 + "\nForm7O : " + this.form_7O + "\nForm8O : " + this.form_8O;
            formsChart();
        }
        return this.binding.getRoot();
    }

    private void formsChart() {
        Logger.d("FormsChartFragment - ", this.form_6 + " - " + this.form_6a + " - " + this.form_7 + " - " + this.form_8 + " - " + this.form_7O + " - " + this.form_8O);
        IBarDataSet barDataSet = new BarDataSet(dataValues1(), "");
        barDataSet.resetColors();
        barDataSet.setColors(this.colorClassArray);
        Logger.d("FormsChartFragment", String.valueOf(barDataSet.getStackSize()));
        this.binding.stackedBarChart.getDescription().setEnabled(false);
        this.binding.stackedBarChart.getXAxis().setPosition(XAxis.XAxisPosition.TOP);
        XAxis xAxis = this.binding.stackedBarChart.getXAxis();
        String[] strArr = {"", "", "", "", "", ""};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(strArr));
        barDataSet.setStackLabels(strArr);
        xAxis.setGranularity(1.0f);
        xAxis.setGranularityEnabled(true);
        Legend legend = this.binding.stackedBarChart.getLegend();
        xAxis.setDrawAxisLine(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setYEntrySpace(8.0f);
        legend.setCustom(new LegendEntry[]{new LegendEntry("Form6", Legend.LegendForm.SQUARE, 10.0f, 2.0f, (DashPathEffect) null, Color.parseColor("#FEB139")), new LegendEntry("Form6A", Legend.LegendForm.SQUARE, 10.0f, 2.0f, (DashPathEffect) null, Color.parseColor("#3BACB6")), new LegendEntry("Form7", Legend.LegendForm.SQUARE, 10.0f, 2.0f, (DashPathEffect) null, Color.parseColor("#FF8C8C")), new LegendEntry("Form8", Legend.LegendForm.SQUARE, 10.0f, 2.0f, (DashPathEffect) null, Color.parseColor("#9BA3EB")), new LegendEntry("Form 7 Overseas", Legend.LegendForm.SQUARE, 10.0f, 2.0f, (DashPathEffect) null, Color.parseColor("#000000")), new LegendEntry("Form 8 Overseas", Legend.LegendForm.SQUARE, 10.0f, 2.0f, (DashPathEffect) null, Color.parseColor("#808080"))});
        this.binding.stackedBarChart.getXAxis().setDrawGridLines(false);
        this.binding.stackedBarChart.getAxisLeft().setDrawGridLines(false);
        this.binding.stackedBarChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.FormChartFragment.1
            public void onNothingSelected() {
            }

            public void onValueSelected(Entry e, Highlight h) {
                int entryIndex = FormChartFragment.this.binding.stackedBarChart.getData().getDataSetForEntry(e).getEntryIndex((BarEntry) e);
                Logger.d("", "Selected_Value " + entryIndex);
                if (entryIndex == 0) {
                    FormChartFragment.this.commomUtility.displayAlertWithTitleAndMessage(FormChartFragment.this.requireContext(), FormChartFragment.this.formDataText, FormChartFragment.this.formsData);
                    return;
                }
                if (entryIndex == 1) {
                    FormChartFragment.this.commomUtility.displayAlertWithTitleAndMessage(FormChartFragment.this.requireContext(), FormChartFragment.this.formDataText, FormChartFragment.this.formsData);
                    return;
                }
                if (entryIndex == 2) {
                    FormChartFragment.this.commomUtility.displayAlertWithTitleAndMessage(FormChartFragment.this.requireContext(), FormChartFragment.this.formDataText, FormChartFragment.this.formsData);
                    return;
                }
                if (entryIndex == 3) {
                    FormChartFragment.this.commomUtility.displayAlertWithTitleAndMessage(FormChartFragment.this.requireContext(), FormChartFragment.this.formDataText, FormChartFragment.this.formsData);
                } else if (entryIndex == 4) {
                    FormChartFragment.this.commomUtility.displayAlertWithTitleAndMessage(FormChartFragment.this.requireContext(), FormChartFragment.this.formDataText, FormChartFragment.this.formsData);
                } else if (entryIndex == 5) {
                    FormChartFragment.this.commomUtility.displayAlertWithTitleAndMessage(FormChartFragment.this.requireContext(), FormChartFragment.this.formDataText, FormChartFragment.this.formsData);
                }
            }
        });
        this.binding.stackedBarChart.getAxisRight().setEnabled(false);
        YAxis axisLeft = this.binding.stackedBarChart.getAxisLeft();
        axisLeft.setGranularity(1.0f);
        axisLeft.setAxisMinValue(-1.0f);
        axisLeft.setStartAtZero(true);
        barDataSet.setFormSize(17.0f);
        barDataSet.setValueTextSize(15.0f);
        barDataSet.setValueFormatter(new StackedValueFormatter(false, "", 0));
        barDataSet.setDrawValues(false);
        BarData barData = new BarData(new IBarDataSet[]{barDataSet});
        barData.setBarWidth(0.5f);
        this.binding.stackedBarChart.setData(barData);
        this.binding.stackedBarChart.setScaleEnabled(false);
    }

    private List<BarEntry> dataValues1() {
        ArrayList arrayList = new ArrayList();
        this.form6entry = new BarEntry(0.0f, (float) Double.parseDouble(this.form_6));
        this.form6aentry = new BarEntry(1.0f, (float) Double.parseDouble(this.form_6a));
        this.form7entry = new BarEntry(2.0f, (float) Double.parseDouble(this.form_7));
        this.form8entry = new BarEntry(3.0f, (float) Double.parseDouble(this.form_8));
        this.form7Oentry = new BarEntry(4.0f, (float) Double.parseDouble(this.form_7O));
        this.form8Oentry = new BarEntry(5.0f, (float) Double.parseDouble(this.form_8O));
        arrayList.add(this.form6entry);
        arrayList.add(this.form6aentry);
        arrayList.add(this.form7entry);
        arrayList.add(this.form8entry);
        arrayList.add(this.form7Oentry);
        arrayList.add(this.form8Oentry);
        return arrayList;
    }
}
