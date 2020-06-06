package com.asad.sid.aifoodordering.Classes;

public class orderDetails{
    int id;
    String phone;
    String food;
    String amount;
    String address;

    public orderDetails(String phone, String food, String amount, String address) {

        this.phone = phone;
        this.food = food;
        this.amount = amount;
        this.address = address;
    }

    public orderDetails(int id, String phone, String food, String amount, String address) {
        this.id = id;
        this.phone = phone;
        this.food = food;
        this.amount = amount;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
