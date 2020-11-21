package PObjects;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    @FindBy(xpath = "//ul[contains(@class, 'top-menu__list_center')]")
    WebElement mainMenu;

    @FindBy(xpath = "//li[contains(@class, 'kitt-top-menu__item_opened')]")
    WebElement subMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(@class, 'link_first')][contains(text(), '"+menuItem+"')]")).click();
    }

    public void selectSubMenu(String menuItem){
        subMenu.findElement(By.xpath(".//a[contains(@class, 'link_second')][contains(text() , '"+menuItem+"')]")).click();
    }

}
