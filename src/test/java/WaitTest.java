import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest extends BaseTest{

    private Boolean aBoolean;
    private WebElement webElement;

    @Test
    public void fun(){
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        driver.findElement(By.id("com.xueqiu.android:id/tv_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        WebElement ali = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BABA']")));
        System.out.println(ali.getAttribute("enabled"));
        ali.click();

    }
}
