import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
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
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");
            driver = new AndroidDriver<>(new URL("http://192.168.96.136:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
