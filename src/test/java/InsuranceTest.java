import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver1.exe");
        baseURL = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @Test
    public void  testInsurance() throws Exception {

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver1.exe");
        driver.findElement(By.xpath("//*[text() = 'Страхование'][contains(@class, 'kitt-top')]")).click();
        driver.findElement(By.xpath("//*[text() = 'СберСтрахование'][contains(@class, 'kitt-top')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement title = driver.findElement(By.xpath("//h2[text() = 'Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        Assert.assertEquals("Страхование путешественников", title.getText());

        driver.findElement(By.xpath("//a[contains(@href, 'travel')]//span[contains(text(), 'Оформить онлайн')]")).click();

        Thread.sleep(8000);
        //Wait<WebDriver> wait2 = new WebDriverWait(driver, 5, 1000);
        //WebElement online = driver.findElement(By.xpath("//a[contains(text(), 'Оформить онлайн')]"));
        //wait2.until(ExpectedConditions.visibilityOf(online)).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement applyOnlineBtn = driver.findElement(By.xpath("//a[@class='s-btn'][contains(text(),'Оформить онлайн')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyOnlineBtn);

        try{
            applyOnlineBtn.click();
        }catch (WebDriverException e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyOnlineBtn);
        }

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        driver.findElement(By.xpath("//h3[contains(text(), 'Минимальная')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Оформить')]")).click();

        Thread.sleep(8000);
        WebElement titleReg = driver.findElement(By.xpath("//*[@class='col-4 step-element active']"));
        wait.until(ExpectedConditions.visibilityOf(titleReg));
        Assert.assertEquals("Оформление", titleReg.getText());


        //System.out.println(driver.getTitle());
    }

    @After
    public void afterTest(){
        driver.quit();
    }


}
