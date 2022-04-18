package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {

            MobileElement navigateLoginButtonElement = driver.findElement(MobileBy.AccessibilityId("Login"));
            navigateLoginButtonElement.click();

            MobileElement usernameField = driver.findElement(MobileBy.AccessibilityId("input-email"));
            usernameField.sendKeys("usernametest@email.com");

            MobileElement passwordField = driver.findElement(MobileBy.AccessibilityId("input-password"));
            passwordField.sendKeys("12345678");

            MobileElement loginButton = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginButton.click();

            WebDriverWait explicitWait = new WebDriverWait(driver, 5);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            System.out.println("Title: " + driver.findElement(MobileBy.id("android:id/alertTitle")).getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
