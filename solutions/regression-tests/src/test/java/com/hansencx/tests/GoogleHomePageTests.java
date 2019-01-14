package com.hansencx.tests;

import com.hansencx.solutions.google.actions.Actions;
import com.hansencx.solutions.core.BaseTest;
import org.testng.annotations.Test;

/**
 * GoogleHomePageTests class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-03
 * @see BaseTest
 */
public class GoogleHomePageTests extends BaseTest {

    @Test
    public void newHomePageTests(){
        Actions actions = new Actions(getDriver());
        actions.navigateToGoogle();
    }
}






