package com.hansencx.tests;

import com.hansencx.solutions.database.DatabaseHelper;
import org.testng.annotations.Test;

public class OracleTests {
    @Test
    void method01() {
        //List<String> expectedList = Arrays.asList("NY", "3000");
        DatabaseHelper dbhelper = new DatabaseHelper();
        dbhelper.open();
        dbhelper.executeQuery("SELECT * FROM COUNTRY2");
        dbhelper.assertResult("NY");
        dbhelper.close();
    }
}
