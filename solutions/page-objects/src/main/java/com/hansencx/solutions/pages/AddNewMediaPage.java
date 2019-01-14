package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewMediaPage extends BasePage {

    //========ELEMENTS=======//
    @FindBy(xpath = "//input[@type='file']")
    private WebElement txt_UploadFile;
    @FindBy(xpath = "//button[text()='Insert into post']")
    private WebElement btnInsertMedia;
    @FindBy(xpath = "//div[@class='media-router']//a[text()='Upload Files']")
    private WebElement tabUploadFiles;
    @FindBy(xpath = "//button[text()='Select Files']")
    private WebElement btnSelectFiles;

    @FindBy(xpath = "//a[text()='Create Gallery']")
    private WebElement lnkCreateGallery;

    @FindBy(xpath = "//button[text()='Create a new gallery']")
    private WebElement btnCreateNewGallery;

    @FindBy(xpath = "//div[contains(@class,'media-selection')]")
    private WebElement ctn_Selection;

    @FindBy(xpath = "//button[text()='Insert gallery']")
    private WebElement btnInsertGallery;

    //--------- VARIABLE ---------------//



    public AddNewMediaPage(WebDriver driver){super(driver);}


}
