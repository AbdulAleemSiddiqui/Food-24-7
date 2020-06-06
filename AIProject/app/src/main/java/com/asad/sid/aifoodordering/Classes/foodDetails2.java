package com.asad.sid.aifoodordering.Classes;

public class foodDetails2{

    private String sno, flavor;

    public foodDetails2(String sno, String flavor) {
        this.sno = sno;
        this.flavor = flavor;
    }

    public foodDetails2(){

    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getFlavor() { return flavor; }

    public void setFlavor(String flavor) { this.flavor = flavor; }
}

