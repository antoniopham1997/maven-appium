package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FullFillTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement navigateFormsButtonElement = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navigateFormsButtonElement.click();

            MobileElement inputField = driver.findElement(MobileBy.AccessibilityId("text-input"));
            inputField.sendKeys("haha");

            MobileElement switchToggleElement = driver.findElement(MobileBy.AccessibilityId("switch"));
            switchToggleElement.click();

            MobileElement selectAnItemElement = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Select an item...\")"));
            selectAnItemElement.click();

            MobileElement lastOption = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"This app is awesome\")"));
            lastOption.click();

            // Get Mobile window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch point
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);
            // Swipe up
            touchAction.longPress(startPoint).moveTo(endPoint).release().perform();

            MobileElement activeButtonElement = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeButtonElement.click();

            WebDriverWait explicitWait = new WebDriverWait(driver, 5);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"This button is active\")")));

            MobileElement okButton = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"OK\")"));
            okButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
