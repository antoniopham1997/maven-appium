package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDown {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            SwipeTest.swipeDown(driver, 50, 0, 70, 1);

            Map<String, String> notifications = new HashMap<>();
            List<MobileElement> notificationElements = driver.findElements(MobileBy.id("android:id/notification_main_column"));
            for (MobileElement notificationElement : notificationElements) {
                MobileElement titleElement = notificationElement.findElement(MobileBy.id("android:id/title"));
                String titleText = titleElement.getText();

                MobileElement contentElement = notificationElement.findElement(MobileBy.id("android:id/text"));
                String contentText = contentElement.getText();

                notifications.put(titleText, contentText);
            }

            if (notifications.keySet().isEmpty()) {
                throw new RuntimeException("There is no notification");
            } else {
                for (String title : notifications.keySet()) {
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + notifications.get(title));
                }
            }

            SwipeTest.swipeUp(driver, 50, 70, 0, 1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
