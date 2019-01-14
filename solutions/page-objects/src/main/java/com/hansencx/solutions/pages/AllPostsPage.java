package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllPostsPage extends BasePage {

    @FindBy(xpath = "//*[@id='wpbody-content']//a[.='Add New']")
    private WebElement btnAddNewPost;

    public AllPostsPage(WebDriver driver){super(driver);}

    public AddNewPostPage navigateToAddNewPostSection(){
        btnAddNewPost.click();
        return new AddNewPostPage(driver);
    }

}
