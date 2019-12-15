package com.netcore.android;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.android.android_InitPage;
import utils.DriverFactory;

import java.net.MalformedURLException;


public class android_Steps {
    DriverFactory df = new DriverFactory();
    android_InitPage initPage = new android_InitPage();

    @Before(value = "@android")
    public void setUp() throws MalformedURLException {
        df.setUp("android");
    }

    @Given("^user is on PNAutomation screen$")
    public void user_is_on_InitPage() throws InterruptedException {
        initPage.verifyInitPageLoaded();
        initPage.enterEmail();
        initPage.clickLoginBtn();
        initPage.clickPNAutomationBtn();
    }

    @When("^user clicks on Simple Notification$")
    public void user_click_on_simplepn() {
        initPage.clickSimpleNotifications();
    }

    @Then("^user clicks on Simple Notification AH$")
    public void user_choose_Singapore() {
        initPage.clickSimpleNotificationAH();
    }

    @After
    public void tearDown() throws Exception {
        df.tearDown();
    }
}
