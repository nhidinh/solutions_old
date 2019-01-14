package com.hansencx.wordpress_datatest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

/**
 * User: Nhi Dinh
 * Date: 4/01/2019
 */
public class DataSetup {
    public void setUpPostData(ITestContext context){
        DataGenerator dataGenerator = new DataGenerator();
        String body = dataGenerator.body();
        String title = dataGenerator.title();

        context.setAttribute("title", title);
        context.setAttribute("body", body);
    }
}
