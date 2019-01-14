package com.hansencx.solutions.google.actions;

import com.hansencx.solutions.core.BaseAction;
import com.hansencx.solutions.pages.GoogleHomePage;
import org.openqa.selenium.WebDriver;

/**
 * Actions class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-03
 * @see BaseAction
 */
public class Actions extends BaseAction {

    private GoogleHomePage googleHomePage = new GoogleHomePage(driver);

    /**
     * Constructor
     */
    public Actions(WebDriver driver){
        super(driver);
    }

    /**
     * Navigate to Google page
     * @author Vi Nguyen
     * @param
     * @return Nothing.
     * @since 2018-12-03
     * @see
     */
    public void navigateToGoogle(){
        googleHomePage.navigateTo();
        googleHomePage.waitForElementToAppear(googleHomePage.getSearchBox());
    }

}
