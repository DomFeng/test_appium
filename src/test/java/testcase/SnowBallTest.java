package testcase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SnowBallTest extends BaseTest{
/*    打开雪球应用首页，定位首页的搜索框
    判断搜索框的是否可用，打印搜索框的这个元素的左上角坐标和它的宽高
    想搜索框输入：alibaba
    判断阿里巴巴是否可见
    如果可见，打印“搜索成功”点击，如果不可见，打印“搜索失败”*/
    @Test
    public void SnowBallTest(){
        //定位首页搜索框
        WebElement home_search = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        if (home_search.getAttribute("enabled").equals("true")){
            System.out.println(home_search.getLocation());
            home_search.click();
            driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
            WebElement BABA = driver.findElement(By.xpath("//*[@text='BABA']"));
            if (BABA.getAttribute("displayed").equals("true")){
                System.out.println("搜索成功");
            }else{
                System.out.println("搜索失败");
            }
        }
    }

    @Test
    public void swipeTest(){
        try {
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();
            Thread.sleep(15000);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point((int)(width*0.5),(int)(height*0.8))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                    .moveTo(PointOption.point((int)(width*0.5),(int)(height*0.2))).release().perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void priceTest(){
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText());
    }

    @Test
    public void uiautomatorSelectTest(){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        //通过resourceId来定位
        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")").click();
        //通过className来定位
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"交易\")").click();
    }

    @Test
    public void scrollTest(){
        try {
            AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
            Thread.sleep(10000);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"大徐子\").instance(0))");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
