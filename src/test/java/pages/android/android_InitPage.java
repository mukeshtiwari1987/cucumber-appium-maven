package pages.android;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.DriverFactory;


public class android_InitPage extends DriverFactory {
    String emailTxtBox = appPackage + ":id/emailEditText";
    By emailID = By.id(emailTxtBox);

    String loginBtn = appPackage + ":id/loginButton";
    By loginBtnId = By.id(loginBtn);

    By PNAutomationBtn = By.xpath("//android.widget.TextView[@text='PNAutomation']");

    By SimplePn = By.xpath("//android.widget.TextView[@text='Simple Notifications']");
    By SimplePnAH = By.xpath("//android.widget.TextView[@text='Simple Notification (AH)']");


    public void verifyInitPageLoaded() {
        driver.findElement(emailID);
    }

    public void enterEmail() {
        driver.findElement(emailID).sendKeys("test1@netcore.co.in");
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtnId).click();
    }

    public void clickPNAutomationBtn() {
        driver.findElement(PNAutomationBtn).click();
    }

    public void clickSimpleNotifications() {
        driver.findElement(SimplePn).click();
    }

    public void clickSimpleNotificationAH() {
        driver.findElement(SimplePnAH).click();
    }
}
