package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPostPage extends BasePage {

    @FindBy(xpath = "//textarea[@placeholder='Add title']")
    private WebElement txtAddTitle;

    @FindBy(xpath = "//*[@id='mce_0']")
    private WebElement txtAddBody;

    @FindBy(xpath = "//*[@id='editor']//button[contains(.,'Publish')]")
    private WebElement btnPublish;

    @FindBy(xpath = "//*[@id=\"editor\"]/div/div/div/div[3]/div/div/div[2]/div/div[1]/a")
    private WebElement labelAddSuccessfully;

    @FindBy(xpath = "//*[@id='editor']/div/div/div/div[3]/div/div/div[1]//button")
    private WebElement btnConfirmPublish;

    @FindBy(xpath = "//*[@id='menu-posts']//a[.='All Posts  ']")
    private WebElement linkAllPosts;

    public AddNewPostPage(WebDriver driver){super(driver);}

    public void addNewPost(String title, String body) throws InterruptedException {
        txtAddTitle.sendKeys(title);
        txtAddTitle.sendKeys(Keys.ENTER);
        setText(txtAddBody, body);
        btnPublish.click();
        Thread.sleep(10000);
        btnConfirmPublish.click();
    }

    public AllPostsPage navigateToAllPostsSection(){
        linkAllPosts.click();
        return new AllPostsPage(driver);
    }
    public void verifyPostingSuccessfully(){
        verifyElementPresent(labelAddSuccessfully);
    }


}
