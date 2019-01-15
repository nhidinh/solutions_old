package com.hansencx.portal;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.portal.actions.PortalBaseTest;
import org.testng.annotations.Test;

/**
 * @param
 * @author Nhi Dinh
 * @return
 * @since 1/15/2019
 */


public class Search_Tests extends PortalBaseTest {
    @Test(description = "Search by Enrollment Number")
    public void SearchByEnrollmentNumberInList(){
        Page.TopNavigation().clickSearchButton();
        Page.Search().SearchByEnrollmentNumberWithFilter("in list", "1");
        Page.Search().clickSearchButton();
    }
}
