package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    public static AppiumDriver driver = null;
    public static WebDriverWait driverWait = null;
    public String platformVersion = "7.1";
    public String appPackage = "com.netcore.smartech.java";
    public String androidDeviceName = "b9101d77";

    public void setUp(String device) throws MalformedURLException {
        if (device.equals("iOS")) {
            getSetup_ios();
        }
        if (device.equals("android")) {
            getSetup_android();
        }
    }

    public void getSetup_ios() throws MalformedURLException {
        //Init Appium Instances:
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", "iPhone 5s");

        //Set appPath
        String userDir = System.getProperty("user.dir");
        String localApp = "Lazada.app.zip";
        String appPath = userDir + "/" + localApp;
        capabilities.setCapability("app", appPath);

        driver = new IOSDriver(serverAddress, capabilities);
        driverWait = new WebDriverWait(driver, 90);
    }

    public void getSetup_android() throws MalformedURLException {
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("appium-version", "1.9.1");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", androidDeviceName);
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", appPackage);

        String userDir = System.getProperty("user.dir");
        String localApp = "crowdTest-2596e18b8ed3e9ecec5bbb532ad17a0a-3.apk";
        String appPath = userDir + "/src/test/binary/" + localApp;
        capabilities.setCapability("app", appPath);

        driver = new AndroidDriver(serverAddress, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }
}
