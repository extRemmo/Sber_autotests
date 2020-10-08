import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @Test
    public void  testInsurance() {

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver.findElement(By.xpath("//*[text() = 'Страхование'][contains(@class, 'kitt-top')]")).click();
        driver.findElement(By.xpath("//*[text() = 'СберСтрахование'][contains(@class, 'kitt-top')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement title = driver.findElement(By.xpath("//h2[text() = 'Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        Assert.assertEquals("Страхование путешественников", title.getText());

        driver.findElement(By.xpath("//a[contains(@href, 'travel')]//span[contains(text(), 'Оформить онлайн')]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Wait<WebDriver> wait2 = new WebDriverWait(driver, 5, 1000);
        //WebElement online = driver.findElement(By.xpath("//a[contains(text(), 'Оформить онлайн')]"));
        //wait2.until(ExpectedConditions.visibilityOf(online)).click();
        //driver.findElement(By.cssSelector("#app > article > div:nth-child(4) > div > div > a")).click();

    }

    @After
    public void afterTest(){
        driver.quit();
    }


}
