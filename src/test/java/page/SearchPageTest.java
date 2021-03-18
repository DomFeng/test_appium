package page;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import testcase.BaseTest;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SearchPageTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    public void searchByName(String name,String code,double price){
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(name);
        driver.findElement(By.xpath("//*[@text='"+code+"']")).click();
        String realPrice = driver.findElement(By.xpath("//*[@text='" + code + "']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        //greaterThan意思是比greaterThan中的值要大
        assertThat("股票实际价格与期望价格的比较",Double.parseDouble(realPrice),greaterThan(price));

    }

    private static Stream<Arguments> byNameGetPrice(){
        return Stream.of(Arguments.of("alibaba","BABA",210d),
        Arguments.of("wangyi","NTES",100d),
        Arguments.of("baidu","BIDU",180d),
        Arguments.of("googl","GOOGL",300d));
    }
}
