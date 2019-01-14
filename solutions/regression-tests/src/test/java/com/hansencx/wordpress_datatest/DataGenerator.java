package com.hansencx.wordpress_datatest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * User: Nhi Dinh
 * Date: 4/01/2019
 */
public class DataGenerator {
    private  String[] wordNames = {"new","post","collection","Pen","tutorial","vacation"};
    private String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    private int rndNo(){
        Random ran = new Random();
        return ran.nextInt(wordNames.length);
    }
    private String rndString(){
        return wordNames[rndNo()]+" "+wordNames[rndNo()]+" ";
    }

    public String title(){
        return "Title: "+rndString()+TIMESTAMP;
    }
    public String body(){
        return "======= Body: "+ rndString()+ TIMESTAMP;
    }
}
