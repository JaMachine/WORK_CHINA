package com.example.myapplication;

import java.text.NumberFormat;

public class CashVariableUnit {

    public String doubleToString(double d) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return nf.format(d);
    }

    public double stringToDouble(String s) {
        return Double.parseDouble(s);
    }
}
