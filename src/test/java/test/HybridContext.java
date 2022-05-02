package test;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HybridContext {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Click on Webview button
            appiumDriver.findElement(MobileBy.AccessibilityId("Webview")).click();

            // Wait until more than one context
            WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 10);
            explicitWait.until(new WaitMoreThanOneContext(appiumDriver));

            // Switch to web view context
            appiumDriver.context(Contexts.WEB_VIEW);

            // Interact on web view
            appiumDriver.findElementByCssSelector(".navbar__toggle").click();

            // Switch to native context
            appiumDriver.context(Contexts.NATIVE);

            // Click on login button
            appiumDriver.findElement(MobileBy.AccessibilityId("Login")).click();

            appiumDriver.findElement(MobileBy.AccessibilityId("input-email")).sendKeys("usernametest@email.com");

            appiumDriver.findElement(MobileBy.AccessibilityId("input-password")).sendKeys("12345678");

            appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN")).click();

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            System.out.println("Title: " + appiumDriver.findElement(MobileBy.id("android:id/alertTitle")).getText());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
