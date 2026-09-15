package in.gov.eci.bloapp.views.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.components.Legend;
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
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloFragmentDashboardGraphBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.views.activity.DashFormsDetails;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DashBoardChartFragment extends Fragment {
    String before7DaysData;
    BloFragmentDashboardGraphBinding binding;
    String within7DaysData;
    CommomUtility commomUtility = new CommomUtility();
    String withinForm6 = "0";
    String withinForm6A = "0";
    String withinForm6B = "0";
    String withinForm7 = "0";
    String withinForm8 = "0";
    String beforeForm6 = "0";
    String beforeForm6A = "0";
    String beforeForm6B = "0";
    String beforeForm7 = "0";
    String beforeForm8 = "0";
    int[] colorClassArray = {Color.parseColor("#FEB139"), Color.parseColor("#3BACB6"), Color.parseColor("#827397"), Color.parseColor("#FF8C8C"), Color.parseColor("#9BA3EB")};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentDashboardGraphBinding.inflate(getLayoutInflater());
        if (getArguments() != null) {
            this.withinForm6 = getArguments().getString("withForm6");
            this.withinForm6A = getArguments().getString("withForm6A");
            this.withinForm6B = getArguments().getString("withForm6B");
            this.withinForm7 = getArguments().getString("withForm7");
            this.withinForm8 = getArguments().getString("withForm8");
            this.beforeForm6 = getArguments().getString("beforeForm6");
            this.beforeForm6A = getArguments().getString("beforeForm6A");
            this.beforeForm6B = getArguments().getString("beforeForm6B");
            this.beforeForm7 = getArguments().getString("beforeForm7");
            this.beforeForm8 = getArguments().getString("beforeForm8");
            Logger.d("DashBoardChartFragment_Before - ", this.withinForm6 + " - " + this.withinForm6A + " - " + this.withinForm6B + " - " + this.withinForm7 + " - " + this.withinForm8 + " - " + this.beforeForm6 + " - " + this.beforeForm6A + " - " + this.beforeForm6B + " - " + this.beforeForm7 + " - " + this.beforeForm8);
            this.within7DaysData = getString(R.string.blo_form_6) + " : " + this.withinForm6 + "\n" + getString(R.string.blo_form6a) + " : " + this.withinForm6A + "\n" + getString(R.string.blo_form_6b) + " : " + this.withinForm6B + "\n" + getString(R.string.blo_form_7) + " : " + this.withinForm7 + "\n" + getString(R.string.blo_form_8) + " : " + this.withinForm8;
            this.before7DaysData = getString(R.string.blo_form_6) + " : " + this.beforeForm6 + "\n" + getString(R.string.blo_form6a) + " : " + this.beforeForm6A + "\n" + getString(R.string.blo_form_6b) + " : " + this.beforeForm6B + "\n" + getString(R.string.blo_form_7) + " : " + this.beforeForm7 + "\n" + getString(R.string.blo_form_8) + " : " + this.beforeForm8;
            Logger.d("DashBoardChartFragment_After - ", this.withinForm6 + " - " + this.withinForm6A + " - " + this.withinForm6B + " - " + this.withinForm7 + " - " + this.withinForm8 + " - " + this.beforeForm6 + " - " + this.beforeForm6A + " - " + this.beforeForm6B + " - " + this.beforeForm7 + " - " + this.beforeForm8);
            dashboardChart();
        }
        return this.binding.getRoot();
    }

    private ArrayList<BarEntry> dataValues1() {
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        arrayList.add(new BarEntry(0.0f, new float[]{(float) Double.parseDouble(this.withinForm6), (float) Double.parseDouble(this.withinForm6A), (float) Double.parseDouble(this.withinForm6B), (float) Double.parseDouble(this.withinForm7), (float) Double.parseDouble(this.withinForm8)}));
        arrayList.add(new BarEntry(1.0f, new float[]{(float) Double.parseDouble(this.beforeForm6), (float) Double.parseDouble(this.beforeForm6A), (float) Double.parseDouble(this.beforeForm6B), (float) Double.parseDouble(this.beforeForm7), (float) Double.parseDouble(this.beforeForm8)}));
        return arrayList;
    }

    private void dashboardChart() {
        Logger.d("DashBoardChartFragment - ", this.withinForm6 + " - " + this.withinForm6A + " - " + this.withinForm6B + " - " + this.withinForm7 + " - " + this.withinForm8 + " - " + this.beforeForm6 + " - " + this.beforeForm6A + " - " + this.beforeForm6B + " - " + this.beforeForm7 + " - " + this.beforeForm8);
        IBarDataSet barDataSet = new BarDataSet(dataValues1(), "");
        barDataSet.setColors(this.colorClassArray);
        barDataSet.setStackLabels(new String[]{getString(R.string.blo_form_6), getString(R.string.blo_form6a), getString(R.string.blo_form_6b), getString(R.string.blo_form_7), getString(R.string.blo_form_8)});
        this.binding.stackedBarChart.getDescription().setEnabled(false);
        this.binding.stackedBarChart.getXAxis().setPosition(XAxis.XAxisPosition.TOP);
        XAxis xAxis = this.binding.stackedBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{getString(R.string.blo_Less_than_7_days), getString(R.string.blo_more_than_7_days)}));
        xAxis.setGranularity(1.0f);
        xAxis.setGranularityEnabled(true);
        Legend legend = this.binding.stackedBarChart.getLegend();
        xAxis.setDrawAxisLine(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setYEntrySpace(20.0f);
        this.binding.stackedBarChart.getXAxis().setDrawGridLines(false);
        this.binding.stackedBarChart.getAxisLeft().setDrawGridLines(false);
        this.binding.stackedBarChart.setOnChartValueSelectedListener(new AnonymousClass1());
        this.binding.stackedBarChart.getAxisRight().setEnabled(false);
        YAxis axisLeft = this.binding.stackedBarChart.getAxisLeft();
        axisLeft.setGranularity(1.0f);
        axisLeft.setAxisMinimum(0.0f);
        barDataSet.setFormSize(17.0f);
        barDataSet.setValueTextSize(15.0f);
        barDataSet.setValueFormatter(new StackedValueFormatter(false, "", 0));
        barDataSet.setDrawValues(false);
        BarData barData = new BarData(new IBarDataSet[]{barDataSet});
        barData.setBarWidth(0.5f);
        this.binding.stackedBarChart.setData(barData);
        this.binding.stackedBarChart.setScaleEnabled(false);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.DashBoardChartFragment$1, reason: invalid class name */
    class AnonymousClass1 implements OnChartValueSelectedListener {
        AnonymousClass1() {
        }

        public void onValueSelected(Entry e, Highlight h) {
            int entryIndex = DashBoardChartFragment.this.binding.stackedBarChart.getData().getDataSetForEntry(e).getEntryIndex((BarEntry) e);
            Logger.d("", "Selected_Value " + entryIndex);
            if (entryIndex == 0) {
                DashBoardChartFragment.this.commomUtility.showMessageOKCancelBoth(DashBoardChartFragment.this.requireContext(), DashBoardChartFragment.this.getString(R.string.blo_Less_than_7_days_data), DashBoardChartFragment.this.within7DaysData, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.DashBoardChartFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onValueSelected$0(dialogInterface, i);
                    }
                });
            } else if (entryIndex == 1) {
                DashBoardChartFragment.this.commomUtility.showMessageOKCancelBoth(DashBoardChartFragment.this.requireContext(), DashBoardChartFragment.this.getString(R.string.blo_more_than_7_days_data), DashBoardChartFragment.this.before7DaysData, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.DashBoardChartFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onValueSelected$1(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onValueSelected$0(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                DashBoardChartFragment.this.startActivity(new Intent(DashBoardChartFragment.this.requireContext(), (Class<?>) DashFormsDetails.class));
            } else {
                if (i != -1) {
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onValueSelected$1(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                DashBoardChartFragment.this.startActivity(new Intent(DashBoardChartFragment.this.requireContext(), (Class<?>) DashFormsDetails.class));
            } else {
                if (i != -1) {
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        public void onNothingSelected() {
            Logger.d("Selected_Value ", "Nothing Selected");
        }
    }
}
