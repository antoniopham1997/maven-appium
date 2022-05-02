package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TakeScreenshot {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Click on login button
            appiumDriver.findElement(MobileBy.AccessibilityId("Login")).click();
            WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 10);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-LOGIN")));

            // Take screenshot whole screen
            File wholeScreenData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("HomeScreen.png");
            FileUtils.copyFile(wholeScreenData, new File(fileLocation));

            // Take screenshot an area
            File loginFormData = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen")).getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(loginFormData, new File(loginFormFileLocation));

            // Take screenshot an element
            File loginButtonData = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN")).getScreenshotAs(OutputType.FILE);
            String loginButtonFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginButton.png");
            FileUtils.copyFile(loginButtonData, new File(loginButtonFileLocation));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }

    }
}
