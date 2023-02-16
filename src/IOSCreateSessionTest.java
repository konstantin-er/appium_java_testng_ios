import Pages.MainPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class IOSCreateSessionTest extends BaseTest {
//    private IOSDriver<IOSElement> driver;

    @BeforeSuite
    public void setUp() throws Exception {

    }

    @AfterSuite
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void testCreateSession () {

        MainPage main = new MainPage(this.getDriver());
        main.checkCalculate(12, 13);
//        main.integerA.sendKeys("12");

//        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("IntegerA");
//        el1.sendKeys("11");
//        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("IntegerB");
//        el2.sendKeys("10");
//        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("ComputeSumButton");
//        el3.click();

        // Check that the XCUIElementTypeApplication was what we expect it to be
//        List<WebElement> computeSumButtons = driver.findElementsByXPath("//XCUIElementTypeTextField[@name=\"IntegerA\"]");
//        computeSumButtons.get(0).sendKeys("12");
//        IOSElement applicationElement = (IOSElement) driver.findElementByAccessibilityId("IntegerA");
//        applicationElement.setValue("12");
//        String applicationName = applicationElement.getAttribute("name");
//        Assert.assertEquals(applicationName, "TestApp");
    }
}
