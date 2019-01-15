package com.hansencx.solutions.pages.portal;

import com.hansencx.solutions.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver){
        super(driver);
    }

    //ELEMENTS
    @FindBy(id = "SearchButton")
    WebElement btnSearch;
    @FindBy(id="ResetButton")
    WebElement btnClear;
    @FindBy(name = "EnrollmentNumberFilter")
    WebElement ddlEnrollmentNumberFilter;
    @FindBy(id="EnrollmentNumber")
    WebElement txtEnrollmentNumber;

    public WebElement getOptionElement(String parent, String option){
        WebElement opt = driver.findElement(By.xpath(""));
        return opt;
    }

    //METHODS
    public void clickSearchButton(){
        click(btnSearch);
    }
    public void clickClearButton(){
        click(btnClear);
    }
    public void setTextEnrollmentNumber(String enrollNumber){
        setText(txtEnrollmentNumber, enrollNumber);
    }
    public void selectEnrollmentNumberFilterOption(String option){
        Select selectEnrollmentNumberFilter = new Select(ddlEnrollmentNumberFilter);
        selectEnrollmentNumberFilter.selectByVisibleText(option);
    }

    //ACTIONS
    public void SearchByEnrollmentNumberWithFilter(String option, String enrollNumber){
        selectEnrollmentNumberFilterOption(option);
        setTextEnrollmentNumber(enrollNumber);
    }
}