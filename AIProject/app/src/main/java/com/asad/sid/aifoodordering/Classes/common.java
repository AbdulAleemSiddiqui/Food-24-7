package com.asad.sid.aifoodordering.Classes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class common {

    public static user currentUser;
    public static String usname, usemail;
    public static String selectedMenu;
    public static String Sno, foodname,foodflavor, foodprice, foodquantity, totalamount;
    public static int tempQuantity = 0;

    public static String tempSize = "";
//    public static String smallQuantity = "0";
//    public static String regularQuantity = "0";
//    public static String largeQuantity = "0";

    public static int BillAmount;

    public static String FoodStack = "";
    public static String FinalAmount;
    public static String Address = "Karachi Pakistan";


    public static void flavorSetter(String command)
    {
        if (command.indexOf("small") != -1 || command.indexOf("chota") != -1) {
            common.tempSize = "small";
        } else if (command.indexOf("regular") != -1 || command.indexOf("medium") != -1 || command.indexOf("darmiyana") != -1) {
            common.tempSize = "regular";
        } else if (command.indexOf("big") != -1 || command.indexOf("large") != -1 || command.indexOf("bara") != -1) {
            common.tempSize = "large";
        }
        else
        {
            common.tempSize = "";
        }
    }

    public static int quantitySetter(String command) {
        if (command.indexOf("1") != -1 || command.indexOf("ek") != -1 || command.indexOf("one") != -1) {
            common.tempQuantity = 1;
            return 1;
        } else if (command.indexOf("2") != -1 || command.indexOf("do") != -1 || command.indexOf("two") != -1) {
            common.tempQuantity = 2;
            return 2;
        } else if (command.indexOf("3") != -1 || command.indexOf("teen") != -1 || command.indexOf("thiree") != -1) {
            common.tempQuantity = 3;
            return 3;
        } else if (command.indexOf("4") != -1 || command.indexOf("char") != -1 || command.indexOf("four") != -1) {
            common.tempQuantity = 4;
            return 4;
        } else if (command.indexOf("5") != -1 || command.indexOf("paanch") != -1 || command.indexOf("five") != -1) {
            common.tempQuantity = 5;
            return 5;
        } else if (command.indexOf("6") != -1 || command.indexOf("che") != -1 || command.indexOf("chef") != -1 || command.indexOf("hey") != -1 || command.indexOf("six") != -1) {
            common.tempQuantity = 6;
            return 6;
        } else if (command.indexOf("7") != -1 || command.indexOf("sath") != -1 || command.indexOf("seven") != -1) {
            common.tempQuantity = 7;
            return 7;
        } else if (command.indexOf("8") != -1 || command.indexOf("aath") != -1 || command.indexOf("eight") != -1) {
            common.tempQuantity = 8;
            return 8;
        } else if (command.indexOf("9") != -1 || command.indexOf("no") != -1 || command.indexOf("nine") != -1) {
            common.tempQuantity = 9;
            return 9;
        } else if (command.indexOf("10") != -1 || command.indexOf("dus") != -1 || command.indexOf("ten") != -1) {
            common.tempQuantity = 10;
            return 10;
        } else if (command.indexOf("11") != -1) {
            common.tempQuantity = 11;
            return 11;
        } else if (command.indexOf("12") != -1) {
            common.tempQuantity = 12;
            return 12;
        } else if (command.indexOf("13") != -1) {
            common.tempQuantity = 13;
            return 13;
        } else if (command.indexOf("14") != -1) {
            common.tempQuantity = 14;
            return 14;
        } else if (command.indexOf("15") != -1) {
            common.tempQuantity = 15;
            return 15;
        } else if (command.indexOf("16") != -1) {
            common.tempQuantity = 16;
            return 16;
        } else if (command.indexOf("17") != -1) {
            common.tempQuantity = 17;
            return 17;
        } else if (command.indexOf("18") != -1) {
            common.tempQuantity = 18;
            return 18;
        } else if (command.indexOf("19") != -1) {
            common.tempQuantity = 19;
            return 19;
        } else if (command.indexOf("20") != -1) {
            common.tempQuantity = 20;
            return 20;
        } else {
            return 0;
        }
    }


}
