package PObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TravelOnlinePage  {

    //WebDriver driver;
    @FindBy(xpath = "//div[@class='s-content-section__button-block']//a[@class='s-btn'][contains(text(),'Оформить онлайн')]")
    public WebElement applyOnlineButton;


    public TravelOnlinePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        /*Wait<WebDriver> wait = new WebDriverWait(driver, 5, 500);
        wait.until(ExpectedConditions.visibilityOf(applyOnlineButton));*/

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyOnlineButton);

        try{
            applyOnlineButton.click();
        }catch (WebDriverException e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyOnlineButton);
        }
    }

    /*public void selectTravelMenu2() {

        //applyOnlineButton.findElement(By.xpath(".//a[@class='s-btn'][contains(text(),'"+menuItem+"')]"));
        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyOnlineButton);

        try{
            applyOnlineButton.click();
        }catch (WebDriverException e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyOnlineButton);
        }*/


}





