package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-20
 * @see BasePage
 */
public class LoginPage extends BasePage{

    /**
     * Locators
     */
    @FindBy(xpath = "//*[@id='user_login']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='user_pass']")
    private WebElement passwordField;

    @FindBy(id = "wp-submit")
    private WebElement loginButton;

    /**
     * Encapsulate fields
     */
    public WebElement getusernameField() {
        return usernameField;
    }
    public WebElement getpasswordField() {
        return passwordField;
    }
    public WebElement getloginButton() {
        return loginButton;
    }


    /**
     * Constructor
     */
    public LoginPage(){
    }
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * Login.
     * @author Vi Nguyen
     * @param username,password
     * @return DashboardPage
     * @since   2018-12-20
     * @see
     */
    public DashboardPage loginSuccessfully(String username, String password) throws InterruptedException {
        getusernameField().click();
        getusernameField().sendKeys(username);
        getpasswordField().sendKeys(password);
        Thread.sleep(2000);

        waitForElementToBeClickable(getloginButton());
        getloginButton().click();

        return new DashboardPage(driver);
    }

    public LoginFailurePage loginUnsuccessfully(String username, String password) throws InterruptedException{
        getusernameField().click();
        getusernameField().sendKeys(username);
        getpasswordField().sendKeys(password);
        Thread.sleep(2000);

        waitForElementToBeClickable(getloginButton());
        getloginButton().click();

        return new LoginFailurePage(driver);
    }

}
