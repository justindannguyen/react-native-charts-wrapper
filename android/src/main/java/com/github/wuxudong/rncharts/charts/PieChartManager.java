package com.github.wuxudong.rncharts.charts;


import android.view.View;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.data.PieEntry;
import com.github.wuxudong.rncharts.data.DataExtract;
import com.github.wuxudong.rncharts.data.PieDataExtract;
import com.github.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.github.wuxudong.rncharts.utils.BridgeUtils;

public class PieChartManager extends ChartBaseManager<PieChart, PieEntry> {

    @Override
    public String getName() {
        return "RNPieChart";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        PieChart pieChart =  new PieChart(reactContext);
        pieChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(pieChart));
        return pieChart;
    }

    @Override
    DataExtract getDataExtract() {
        return new PieDataExtract();
    }

    @ReactProp(name = "drawEntryLabels")
    public void setDrawSliceText(PieChart chart, boolean enabled) {
        chart.setDrawEntryLabels(enabled);
    }

    @ReactProp(name = "usePercentValues")
    public void setUsePercentValues(PieChart chart, boolean enabled) {
        chart.setUsePercentValues(enabled);
    }

    @ReactProp(name = "centerText")
    public void setCenterText(PieChart chart, ReadableMap propMap) {
        if (BridgeUtils.validate(propMap, ReadableType.String, "text")) {
            chart.setCenterText(propMap.getString("text"));
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "radiusPercent")) {
            chart.setCenterTextRadiusPercent((float) propMap.getDouble("radiusPercent"));
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "textSize")) {
            chart.setCenterTextSize((float) propMap.getDouble("textSize"));
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "textSizePixels")) {
            chart.setCenterTextSizePixels((float) propMap.getDouble("textSizePixels"));
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "textOffsetX") &&
                BridgeUtils.validate(propMap, ReadableType.Number, "textOffsetY")) {
            chart.setCenterTextOffset((float) propMap.getDouble("textOffsetX"),
                    (float) propMap.getDouble("textOffsetY"));
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "textColor")) {
            chart.setCenterTextColor(propMap.getInt("textColor"));
        }
        if (BridgeUtils.validate(propMap, ReadableType.Boolean, "enabled")) {
            chart.setDrawCenterText(propMap.getBoolean("enabled"));
        }
    }

    @ReactProp(name = "holeRadius")
    public void setHoleRadius(PieChart chart, float percent) {
        chart.setHoleRadius(percent);
    }

    @ReactProp(name = "holeColor")
    public void setHoleColor(PieChart chart, Integer color) {
        chart.setHoleColor(color);
    }

    @ReactProp(name = "transparentCircleRadius")
    public void setTransparentCircleRadius(PieChart chart, float percent) {
        chart.setTransparentCircleRadius(percent);
    }

    @ReactProp(name = "transparentCircleColor")
    public void setTransparentCircleColor(PieChart chart, Integer color) {
        chart.setTransparentCircleColor(color);
    }

    @ReactProp(name = "entryLabelColor")
    public void setEntryLabelColor(PieChart chart, Integer color) {
        chart.setEntryLabelColor(color);
    }

    @ReactProp(name = "entryLabelTextSize")
    public void setEntryLabelTextSize(PieChart chart, float size) {
        chart.setEntryLabelTextSize(size);
    }

    @ReactProp(name = "maxAngle")
    public void setMaxAngle(PieChart chart, float maxAngle) {
        chart.setMaxAngle(maxAngle);
    }

    @ReactProp(name = "rotationEnabled")
    public void setRotationEnabled(PieChart chart, boolean enabled) {
        chart.setRotationEnabled(enabled);
    }

    @ReactProp(name = "rotationAngle")
    public void setRotationAngle(PieChart chart, float angle) {
        chart.setRotationAngle(angle);
    }


}
