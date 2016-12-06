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
    firebasedata(){
        weight="";
        height="";
        date="";
    }
    firebasedata(String a, String b , String c)
    {

        weight=a;
        height=b;
        date=c;
    }
    public void setDate(String s){ date=s;}
    public String getDate()
    {
        return date;
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
