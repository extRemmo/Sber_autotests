package PObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InsurePage {

    @FindBy(xpath = "//div[@class='flexing']/div/a[contains(@href,'travel_ins')]")
    public WebElement onlineBtn;

    @FindBy(xpath = "//h2[text() = 'Страхование путешественников']")
    public WebElement title;

    @FindBy(xpath = "//ul[contains(@class, 'top-menu__list_center')]")
    WebElement closeBtn;

    public InsurePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectTravelMenu(String menuItem){
        closeBtn.findElement(By.xpath("//button[text()='Закрыть']")).click();
        onlineBtn.findElement(By.xpath(".//span[contains(text(), '"+menuItem+"')]")).click();
    }

}
