package PObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Steps.BaseSteps;

public class BasePageObject {
    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.click();
        field.sendKeys(value);
    }
}
