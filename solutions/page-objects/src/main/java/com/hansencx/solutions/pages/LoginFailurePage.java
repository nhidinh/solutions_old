package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFailurePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"login_error\"]/strong[text()='ERROR']")
    private WebElement errorText;

    public WebElement getErrorText() {return errorText;}

    public LoginFailurePage(WebDriver driver){
        super(driver);
    }
}
