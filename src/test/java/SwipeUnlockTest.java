import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwipeUnlockTest{
    public static AppiumDriver driver;

    @BeforeAll
    public static void initData(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("udid","127.0.0.1:7555");
            caps.setCapability("deviceName","xxxx");
            caps.setCapability("appPackage","cn.kmob.screenfingermovelock");
            caps.setCapability("appActivity","com.samsung.ui.FlashActivity");
            driver = new AndroidDriver<>(new URL("http://192.168.96.136:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unlockTest(){
        try {
            TouchAction touchAction = new TouchAction(driver);
            Duration duration = Duration.ofMillis(3000);
            driver.findElement(By.id("cn.kmob.screenfingermovelock:id/patternTxt")).click();
            Thread.sleep(3000);
            touchAction.press(PointOption.point(248,389)).waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point(770,381)).waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point(1286,400)).waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point(1289,894)).waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point(1288,1409)).waitAction(WaitOptions.waitOptions(duration)).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
