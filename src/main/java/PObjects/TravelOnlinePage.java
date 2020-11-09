package PObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class TravelOnlinePage  {

    @FindBy(xpath = "//div[@class='s-hero-banner__content']")
    public WebElement applyOnlineButton;


    public TravelOnlinePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectTravelOnline(String menuItem, WebDriver driver) {
        //переключаем драйвер на новую вкладку в браузере
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        //Нажать на Оформить онлайн, дожидаясь кликабельности элемента
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='s-hero-banner__btn s-btn']")));
        System.out.println(driver.getTitle());
        //WebElement applyOnlineBtn = driver.findElement(By.xpath("//a[contains(@class, 'banner')][contains(text(),'Оформить онлайн')]"));
        applyOnlineButton.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();
    }
}







