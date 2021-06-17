package com.central.tests;

import com.central.pages.HomePage;
import org.testng.annotations.Test;


public class HomePageTests extends BaseTest{

    @Test(groups = {"Tags"},
            description = "TC_ID:01 - Verify tag is highlighted on hover",
            alwaysRun = true)
    public void VerifyTagIsHighlightedOnHover() {
        HomePage home = new HomePage(getDriver().get());
        home.hoverFilterTag();
    }

    @Test(groups = {"Tags"},
            description = "TC_ID:02 - Verify User is able to select the Tag",
            alwaysRun = true)
    public void VerifyUserIsAbleToSelectTheTag() {
        HomePage home = new HomePage(getDriver().get());
        home.selectTag();
    }

    @Test(groups = {"Tags"},
            description = "TC_ID:03 - Verify User is able to select the Tag",
            alwaysRun = true)
    public void VerifyPage2Navigation() throws InterruptedException {
        HomePage home = new HomePage(getDriver().get());
        home.pageNavigationForSelectedFilter();
    }



    @Test(groups = {"Tags"},
            description = "TC_ID:04 - On tap of global feed, selected tag should be dismissed",
            alwaysRun = true)
    public void VerifySelectedTagIsDismissed() throws InterruptedException {
        HomePage home = new HomePage(getDriver().get());
        home.VerifySelectedTagIsDismissed();
    }


}
