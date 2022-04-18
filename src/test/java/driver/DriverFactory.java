package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    public static AppiumDriver<MobileElement> getDriver(Platforms platform) {
        if (platform == null) {
            throw new IllegalArgumentException("Platform can't be null.");
        }

        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;

        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(UDID, "emulator-5554");
            desiredCapabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
            desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");

            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            switch (platform) {
                case android:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
                    break;
                case ios:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCapabilities);
                    break;
            }

        } catch (Exception e) {
            exception = e;
        }

        if (appiumDriver == null) {
            throw new RuntimeException(exception.getMessage());
        }

        appiumDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return appiumDriver;
    }
}
