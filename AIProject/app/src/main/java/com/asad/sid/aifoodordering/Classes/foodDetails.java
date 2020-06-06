package com.asad.sid.aifoodordering.Classes;

public class foodDetails{
    private String sno;
    private String foodname;
    private String foodprice;

    public foodDetails(){

    }

    public foodDetails(String sno, String foodname, String foodprice) {
        this.sno = sno;
        this.foodname = foodname;
        this.foodprice = foodprice;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(String foodprice) {
        this.foodprice = foodprice;
    }
}

