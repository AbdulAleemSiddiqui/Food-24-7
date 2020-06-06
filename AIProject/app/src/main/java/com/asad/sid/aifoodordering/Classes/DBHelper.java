package com.asad.sid.aifoodordering.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "myDatabase";
    private static final int DB_VER = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String script = "CREATE TABLE CartInfo(PHONE TEXT, NAME TEXT, QUANTITY TEXT, PRICE TEXT)";
        String orderScript = "CREATE TABLE OrderInfo(ID INTEGER PRIMARY KEY AUTOINCREMENT, PHONE TEXT, NAME TEXT, PRICE TEXT, ADDRESS TEXT)";

        sqLiteDatabase.execSQL(script);
        sqLiteDatabase.execSQL(orderScript);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CartInfo");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS OrderInfo");

        onCreate(sqLiteDatabase);
    }

    public long addToOrder(orderDetails cd) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("PHONE", cd.phone);
        cv.put("NAME", cd.food);
        cv.put("PRICE", cd.amount);
        cv.put("ADDRESS", cd.address);

        return db.insert("OrderInfo", null, cv);

    }


    public long addToCart(cartDetails cd) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("PHONE", cd.phone);
        cv.put("NAME", cd.txtCartName);
        cv.put("QUANTITY", cd.txtCartQuantity);
        cv.put("PRICE", cd.textCartPrice);

        return db.insert("CartInfo", null, cv);

    }

    public int clearCart(String phone) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("CartInfo", "PHONE = ?", new String[]{phone});

    }

    public ArrayList<cartDetails> getAllFoodData(String ph) {
        ArrayList<cartDetails> cdlist = new ArrayList<cartDetails>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query("CartInfo", new String[]{"PHONE", "NAME", "QUANTITY", "PRICE"}, "PHONE=?",
                new String[]{ph}, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                cdlist.add(new cartDetails(cursor.getString(cursor.getColumnIndex("PHONE")),
                        cursor.getString(cursor.getColumnIndex("NAME")), cursor.getString(cursor.getColumnIndex("QUANTITY")),
                        cursor.getString(cursor.getColumnIndex("PRICE"))));
            }
            return cdlist;
        } else {
            return null;
        }
    }

    public ArrayList<orderDetails> getAllOrders(String ph) {
        ArrayList<orderDetails> odlist = new ArrayList<orderDetails>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query("OrderInfo", new String[]{"ID","PHONE", "NAME", "PRICE", "ADDRESS"}, "PHONE=?",
                new String[]{ph}, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                odlist.add(new orderDetails(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID"))),cursor.getString(cursor.getColumnIndex("PHONE")),
                        cursor.getString(cursor.getColumnIndex("NAME")), cursor.getString(cursor.getColumnIndex("PRICE")),
                        cursor.getString(cursor.getColumnIndex("ADDRESS"))));
            }
            return odlist;
        } else {
            return null;
        }
    }





    public cartDetails getSingleUserData(String phone) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("CartInfo", new String[]{" PHONE, NAME, QUANTITY, PRICE" }, "PHONE=?",
                new String[]{phone}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            cartDetails cd = new cartDetails(cursor.getString(cursor.getColumnIndex("PHONE")),cursor.getString(cursor.getColumnIndex("NAME")),
                    cursor.getString(cursor.getColumnIndex("QUANTITY")) ,cursor.getString(cursor.getColumnIndex("PRICE")));
            return cd;
        }
        else {
            return null;
        }
    }
    public long Update_userData(String phone, String name, String quantity, String price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("PHONE", phone);
        cv.put("NAME", name);
        cv.put("QUANTITY", quantity);
        cv.put("PRICE", price);
        return db.update("CartInfo", cv, "PHONE = ?", new String[]{phone});
    }
}
