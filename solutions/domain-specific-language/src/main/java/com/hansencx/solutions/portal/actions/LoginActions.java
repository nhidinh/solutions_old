package com.hansencx.solutions.portal.actions;

import com.hansencx.solutions.core.BaseAction;
import com.hansencx.solutions.pages.portal.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * @param
 * @author Nhi Dinh
 * @return
 * @since 1/15/2019
 */


public class LoginActions extends BaseAction {
    public LoginActions(WebDriver driver){
        super(driver);
    }
    private static LoginPage loginPage;

    public void NavigateToLoginPage(){
        loginPage.Goto();
    }
}
