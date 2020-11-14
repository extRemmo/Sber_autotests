package PObjects;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InsurePage {

    @FindBy(xpath = "//div[@id = 'allrecords']/div[5]")
    public WebElement onlineBtn;
    //div[@id = 'allrecords']/div[5]//div[text() = 'Страхование' and text() = 'путешественников']
    @FindBy(xpath = "//div[@id = 'allrecords']/div[5]//div/div/div[13]/div")
    public WebElement title;

    @FindBy(xpath = "//ul[contains(@class, 'top-menu__list_center')]")
    WebElement closeBtn;

    public InsurePage () {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void selectTravelMenu(String menuItem){
        closeBtn.findElement(By.xpath("//button[text()='Закрыть']")).click();
        onlineBtn.findElement(By.xpath(".//a[text()='"+menuItem+"' and contains(@href, 'travel')]")).click();
    }

}
