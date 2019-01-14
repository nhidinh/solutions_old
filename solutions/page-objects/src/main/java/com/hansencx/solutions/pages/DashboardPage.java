package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * DashboardPage class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-20
 * @see BasePage
 */
public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h1[.='Dashboard']")
    private WebElement title;

    @FindBy(xpath = "//li[@id='menu-posts']//div[text()='Posts']")
    private WebElement linkPost;

    @FindBy(id = "//a[@href='media-new.php']")
    private WebElement linkMedia;

    @FindBy(xpath = "//a[@href='media-new.php']")
    private WebElement linkAddNewMedia ;

    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']/a[@class='ab-item']/span[@class='display-name']")
    private WebElement labelLoggedUsername;

    @FindBy(id = "wp-admin-bar-user-info")
    private WebElement linkUserInfo ;

    @FindBy(id = "wp-admin-bar-logout")
    private WebElement linkLogOut ;

    /**
     * Encapsulate fields
     */
    public WebElement getTitle() {
        return title;
    }
    public WebElement getLinkPost() {
        return linkPost;
    }
    public WebElement getLinkMedia() {
        return linkMedia;
    }
    public WebElement getLinkAddNewMedi() {return linkAddNewMedia;}
    public WebElement getLabelLoggedUsername() {
        return labelLoggedUsername;
    }
    public WebElement getLinkUserInfo() {
        return linkUserInfo;
    }
    public WebElement getLinkLogOut() {
        return linkLogOut;
    }

    /**
     * Constructor
     */
    public DashboardPage(){}

    public DashboardPage(WebDriver driver){
        super(driver);
    }


    public AllPostsPage navigateToAllPostSection(){
        linkPost.click();
        return new AllPostsPage(driver);
    }

    public MediaLibraryPage navigateToMediaLibraryPage (){
        linkMedia.click();
        return new MediaLibraryPage(driver);
    }

    public LoginPage logOut(){
            hoverMouseToElement(labelLoggedUsername);
            waitForElementToAppear(linkLogOut);
            linkLogOut.click();
            return new LoginPage(driver);
    }

    public MediaLibraryPage navigateToMediaLibrarySection(){
        linkMedia.click();
        return new MediaLibraryPage(driver);
    }

    public AddNewMediaPage navigateToAddNewMediaSection(){
        linkAddNewMedia.click();
        return new AddNewMediaPage(driver);
    }

}
