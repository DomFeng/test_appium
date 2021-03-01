import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
}
