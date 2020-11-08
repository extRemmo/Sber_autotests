package PObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TravelOnlinePage  {

    @FindBy(xpath = "//div[@class='s-hero-banner__content']")
    public WebElement applyOnlineButton;


    public TravelOnlinePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectTravelOnline(String menuItem) {
        applyOnlineButton.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();
    }
}







