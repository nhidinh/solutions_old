package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * SolutionsDemoPage class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-20
 * @see BasePage
 */
public class SolutionsDemoPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"meta-2\"]/ul/li[1]/a")
    private static WebElement loginLink;//

    /**
     * Encapsulate fields
     */
    public WebElement getloginLink() {
        return loginLink;
    }

    /**
     * Constructors
     */
    public SolutionsDemoPage(WebDriver driver){
        super(driver);
    }

    /**
     * Navigate to Solutions Demo page
     * @author Vi Nguyen
     * @param
     * @return Nothing.
     * @since   2018-12-20
     * @see
     */
    public void navigateTo(){
        driver.get("http://localhost/wordpress/");
    }

    /**
     * Click on Login link at the Demo Solutions page
     * @author Vi Nguyen
     * @param
     * @return LoginPage instance.
     * @since   2018-12-20
     * @see
     */
    public LoginPage clickOnLoginLink(){
        loginLink.click();
        return new LoginPage(driver);
    }
}
