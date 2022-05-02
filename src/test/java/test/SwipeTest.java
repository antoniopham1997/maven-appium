package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class SwipeTest {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        public static void swipeUp(AppiumDriver driver, int x, int yStart, int yEnd, int time) {
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = x * screenWidth / 100;
            int xEndPoint = x * screenWidth / 100;

            int yStartPoint = yStart * screenHeight / 100;
            int yEndPoint = yEnd * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);
            for (int i = 0; i < time; i++) {
                touchAction.longPress(startPoint).moveTo(endPoint).release().perform();
            }
        }

        public static void swipeDown(AppiumDriver driver, int x, int yStart, int yEnd, int time) {
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = x * screenWidth / 100;
            int xEndPoint = x * screenWidth / 100;

            int yStartPoint = yStart * screenHeight / 100;
            int yEndPoint = yEnd * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);

            for (int i = 0; i < time; i++) {
                touchAction.longPress(startPoint).moveTo(endPoint).release().perform();
            }
        }

        public static void swipeFromLeftToRight(AppiumDriver driver, int xStart, int xEnd, int y, int time) {
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = xStart * screenWidth / 100;
            int xEndPoint = xEnd * screenWidth / 100;

            int yStartPoint = y * screenHeight / 100;
            int yEndPoint = y * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);

            for (int i = 0; i < time; i++) {
                touchAction.longPress(startPoint).moveTo(endPoint).release().perform();
            }
        }

        public static void swipeFromRightToLeft(AppiumDriver driver, int xStart, int xEnd, int y, int time) {
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = xStart * screenWidth / 100;
            int xEndPoint = xEnd * screenWidth / 100;

            int yStartPoint = y * screenHeight / 100;
            int yEndPoint = y * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);

            for (int i = 0; i < time; i++) {
                touchAction.longPress(startPoint).moveTo(endPoint).release().perform();
            }
        }
    }
