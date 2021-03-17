import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToastTest {
    public static AppiumDriver driver;

    @BeforeAll
    public static void initData(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("udid","127.0.0.1:7555");
            caps.setCapability("deviceName","xxxx");
            caps.setCapability("appPackage","io.appium.android.apis");
            caps.setCapability("appActivity","io.appium.android.apis.view.PopupMenu1");
            driver = new AndroidDriver<>(new URL("http://192.168.96.136:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void toastTest(){
        driver.findElement(By.xpath("//*[@text='Make a Popup!']")).click();
        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@text='Search']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='android.widget.Toast']")).getText());
        System.out.println(driver.getPageSource());
    }
}
