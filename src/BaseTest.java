import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseTest {

    private static AppiumDriverLocalService service;
    private static IOSDriver<IOSElement> driver;

    @BeforeSuite
    public void globalSetup () throws IOException {

        service = AppiumDriverLocalService.buildDefaultService();

        service.start();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../apps");
//        File app = new File(appDir.getCanonicalPath(), "TestApp.app.zip");
//
        String deviceName = null;
//        System.getenv("IOS_DEVICE_NAME");
        //Init connect to Appium
        String platformVersion = System.getenv("IOS_PLATFORM_VERSION");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", deviceName == null ? "iPhone 14 Pro" : deviceName);
        capabilities.setCapability("appium:platformVersion", platformVersion == null ? "16.1" : platformVersion);
        capabilities.setCapability("appium:app", "/Users/konstantin/Downloads/TestApp.app"/*app.getAbsolutePath()*/);
        capabilities.setCapability("appium:automationName", "xcuitest");
        driver = new IOSDriver<IOSElement>(getServiceUrl(), capabilities);
    }

    @AfterSuite
    public void globalTearDown () {
        if (service != null) {
            service.stop();
        }
        driver.quit();
    }

    public static IOSDriver<IOSElement> getDriver() {
        return driver;
    }

    public URL getServiceUrl () {
        return service.getUrl();
    }

}
