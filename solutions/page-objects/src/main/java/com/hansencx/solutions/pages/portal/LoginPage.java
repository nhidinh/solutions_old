package com.hansencx.solutions.pages.portal;

import com.hansencx.solutions.core.BasePage;
import com.hansencx.solutions.pages.portal.utilities.Links;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //WEB ELEMENT
    @FindBy(xpath = "//table[contains(@id,'Login')]//input[contains(@id, 'UserName')]")
    WebElement txtUsername;
    @FindBy(xpath = "//table[contains(@id,'Login')]//input[contains(@id, 'Password')]")
    WebElement txtPassword;
    @FindBy(xpath = "//table[contains(@id,'Login')]//input[contains(@id, 'LoginButton')]")
    WebElement btnLogon;
    @FindBy(xpath = "//table[contains(@id,'Login')]//a[contains(text(),'Forgot your password')]")
    WebElement lnkForgotPassword;

    //MEDTHODS
    public void setTextUsername(String username){
        setText(txtUsername, username);
    }
    public void setTextPassword(String password){
        setText(txtPassword, password);
    }
    public void clickLogonButton(){
        click(btnLogon);
    }
    public void clickForgotPasswordLink(){
        click(lnkForgotPassword);
    }

    //ACTIONS
    public LoginPage Goto(){
        navigateToPage(Links.URL_LOGIN);
        return new LoginPage(driver);
    }
    public void LogonWithUsername(String username, String password){
        waitForPageLoad();
        setTextUsername(username);
        setTextPassword(password);
        clickLogonButton();
    }
    public void VerifyLogonSuccessfully(){}


}
