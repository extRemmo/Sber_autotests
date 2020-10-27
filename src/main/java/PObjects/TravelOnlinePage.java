package PObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class TravelOnlinePage extends BasePageObject {

    @FindBy(xpath = "//a[@class='s-hero-banner__btn s-btn']")
    public WebElement applyOnlineButton;

    @FindBy(xpath = "//h1[text()='Страхование путешественников ']")
    public WebElement title;


    public TravelOnlinePage () {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectTravelOnline(String menuItem) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='s-hero-banner__btn s-btn']")));

        applyOnlineButton.findElement(By.xpath("//a[@class='s-hero-banner__btn s-btn' and contains(text(),'"+menuItem+"')]")).click();
    }

}







