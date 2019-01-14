package com.hansencx.solutions.pages;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ultils.UploadFile;

import java.awt.*;

public class MediaLibraryPage extends BasePage {

    @FindBy(xpath = "//div[@id='wpbody-content']//a[text()='Add New']")
    private WebElement btnAddNew;

    @FindBy(xpath = "//button[contains(@class,'browser') and text()='Select Files']")
    private WebElement btnSelectFiles;

    @FindBy(id="wpcontent")
    private WebElement ctnDropFiles;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement txtUploadFile;

    public WebElement getBtnAddNew() {
        return btnAddNew;
    }
    public WebElement getBtnSelectFiles() {
        return btnSelectFiles;
    }
    public WebElement getCtnDropFiles() {
        return ctnDropFiles;
    }

    private UploadFile uploadFile = new UploadFile();

    public MediaLibraryPage(WebDriver driver){
        super(driver);
    }

    public void clickAddNewButton() {
        btnAddNew.click();
    }

    public void uploadFileByBrowseButton(String filePath){
        try {
            uploadFile.uploadByBrowseButton(filePath, btnSelectFiles);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void uploadFileByDragDrop(String filePath) {
        uploadFile.uploadByDragDrop(filePath,ctnDropFiles,driver);
    }

    public void uploadFile(String filePath) {
        txtUploadFile.sendKeys(filePath);
    }

}
