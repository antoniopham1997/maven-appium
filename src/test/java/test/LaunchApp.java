package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchApp {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;

        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability("udid", "emulator-5554");
            desiredCapabilities.setCapability("appPackage", "com.google.android.youtube");
            desiredCapabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");

            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);

            Thread.sleep(3000);
        } catch (Exception e) {
            exception = e;
        }

        if (appiumDriver == null) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}