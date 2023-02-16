package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import static org.testng.Assert.assertEquals;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    private IOSDriver<IOSElement> driver;
    public MainPage() {
    }
    public MainPage(IOSDriver<IOSElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(id = "IntegerA")
    public MobileElement integerA;

    @iOSFindBy(id = "IntegerB")
    public MobileElement integerB;

    @iOSFindBy(id = "ComputeSumButton")
    public MobileElement computeSumButton;

    @iOSFindBy(id = "Answer")
    public MobileElement completeSum;

    public void checkCalculate(int value1, int value2) {
        integerA.sendKeys(Integer.toString(value1));
        integerB.sendKeys(Integer.toString(value2));
        computeSumButton.click();
        int summ = value1 + value2;
        String sumString = completeSum.getText();
        Integer.getInteger(sumString);

        assertEquals(Integer.parseInt(sumString), summ);

    }
}
