package PObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurePage {

    @FindBy(xpath = "//div[@class='flexing']/div/a[contains(@href,'travel_ins')]")
    public WebElement onlineBtn;

    public InsurePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(onlineBtn));
    }

    public void selectTravelMenu(String menuItem){
            onlineBtn.findElement(By.xpath(".//span[contains(text(), '"+menuItem+"')]")).click();
    }

}
