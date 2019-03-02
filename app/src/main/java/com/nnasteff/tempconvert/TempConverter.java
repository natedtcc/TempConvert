/*
 *   Nathan Nasteff
 *   Delaware Tech
 *   Spring 2019
 */

// Temperature conversion class

package com.nnasteff.tempconvert;
import java.text.DecimalFormat;

public class TempConverter {

    private double tempFar;
    private double tempCel;
    private double tempIn;
    private boolean tempSelect;
    DecimalFormat formatter = new DecimalFormat("#0.0");

    public TempConverter(){
        tempIn = 79;
        tempSelect = true;
    }

    public double getTempIn() {
        return tempIn;
    }

    public void setTempIn(String t) {
        this.tempIn = Double.parseDouble(t);
    }

    public void setTempSelect(boolean tempSelect) {
        this.tempSelect = tempSelect;
    }

    // This method will return the proper temperature
    // according to boolean tempSelect. True for fahrenheit,
    // false for celsius.

    public String getTemps() {
        tempCel = (tempIn - 32) * (5.0 / 9.0);
        tempFar = tempIn *(9.0 / 5.0) + 32;
        if(tempSelect)
            return formatter.format(tempFar) + "°F";
        else
            return formatter.format(tempCel) + "°C";
    }

}