package testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestAppium {
    public static AppiumDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
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

    @Test
    public void helloSnowBall(){
        //定位首页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        //定位搜索页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        //定位阿里巴巴股票
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println("打印："+driver.findElement(By.xpath("(//*[@resource-id='com.xueqiu.android:id/current_price'])[1]")).getText());
    }
}
