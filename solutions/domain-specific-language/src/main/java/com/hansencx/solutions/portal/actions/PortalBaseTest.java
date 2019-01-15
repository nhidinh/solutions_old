package com.hansencx.solutions.portal.actions;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.pages.portal.LoginPage;
import com.hansencx.solutions.pages.portal.utilities.Portal_PageGenerator;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @param
 * @author Nhi Dinh
 * @return
 * @since 1/15/2019
 */


public class PortalBaseTest extends BaseTest {
     public Portal_PageGenerator Page;

     @BeforeTest
    public void SetPage(){
         Page = new Portal_PageGenerator(driver);
     }

     @BeforeClass
    @Parameters({"username", "password"})
    public void LoginBeforeTest(String username, String password, ITestContext testContext){
         if(!testContext.getName().contains("Login Test")){
             LoginPage loginPage = Page.Login().Goto();
             loginPage.LogonWithUsername(username, password);
         }
     }
}
