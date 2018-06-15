package com.example.user.project;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by user on 2018/6/15.
 */

public class MyAxisValueFormatter implements IAxisValueFormatter {
    private DecimalFormat mFormat;

   public MyAxisValueFormatter(){
       mFormat = new DecimalFormat("#######.0");
   }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mFormat.format(value);
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }
}
