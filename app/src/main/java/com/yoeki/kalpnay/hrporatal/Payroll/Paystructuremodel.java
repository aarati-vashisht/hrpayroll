
package com.yoeki.kalpnay.hrporatal.Payroll;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Paystructuremodel {


   String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getPayElement() {
        return PayElement;
    }

    public void setPayElement(String payElement) {
        PayElement = payElement;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    String Period;
   String PayElement;
   String Amount;





}