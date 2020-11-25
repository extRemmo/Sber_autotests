package PObjects;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InsurePage extends BasePageObject {

    @FindBy(xpath = "//div[@id = 'allrecords']/div[5]")
    public WebElement onlineBtn;

    @FindBy(xpath = "//div[@id = 'allrecords']/div[5]//div/div/div[13]/div")
    public WebElement title;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[4]/div")
    public WebElement mainTitle;


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
