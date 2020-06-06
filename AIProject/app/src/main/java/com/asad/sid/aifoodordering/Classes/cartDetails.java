package com.asad.sid.aifoodordering.Classes;

public class cartDetails {
    String phone;
    String txtCartName;
    String txtCartQuantity;
    String textCartPrice;

    public cartDetails() {
    }

    public cartDetails(String phone, String txtCartName, String txtCartQuantity, String textCartPrice) {
        this.phone = phone;
        this.txtCartName = txtCartName;
        this.textCartPrice = textCartPrice;
        this.txtCartQuantity = txtCartQuantity;
    }


    public String getTxtCartQuantity() {
        return txtCartQuantity;
    }

    public void setTxtCartQuantity(String txtCartQuantity) {
        this.txtCartQuantity = txtCartQuantity;
    }
    public String getTxtCartName() {
        return txtCartName;
    }

    public void setTxtCartName(String txtCartName) {
        this.txtCartName = txtCartName;
    }

    public String getTextCartPrice() {
        return textCartPrice;
    }

    public void setTextCartPrice(String textCartPrice) {
        this.textCartPrice = textCartPrice;
    }
}

