package com.example.mac.infolab;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 14-11-2016.
 */

public class firebasedata {
    private String weight;
    private String height;
    private String date;
    String calories;
    String km;
    firebasedata(){
        weight="";
        height="";
        date="";
        calories="";
        km="";

    }
    firebasedata(String a, String b , String c)
    {

        weight=a;
        height=b;
        date=c;
    }
    firebasedata firebasedata1(String a, String b)
    {

        this.km=a;
        this.date=b;
        return this;
    }
    firebasedata firebasedata2(String a, String b)
    {

        this.calories=a;
        this.date=b;
        return this;
    }
    public void setcalories(String a, String b){ calories=a;
    date =b;}
    public void setkm(String a,String b){ km=a;
    date =b;}
    public void setDate(String s){ date=s;}
    public String getDate()
    {
        return date;
    }
    public String getkm()
    {
        return km;
    }
    public String getCalories()
    {
        return calories;
    }

    public String getWeight()
    {
        return weight;
    }
    public String getheight()
    {
        return height;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("weight", weight);
        result.put("height", height);
        result.put("date", date);
        return result;
    }
}
