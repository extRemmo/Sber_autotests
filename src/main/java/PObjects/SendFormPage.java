package PObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class SendFormPage extends BaseSteps {

    @FindBy(xpath = "//div[@class='online-card-program selected']")
    public WebElement minBtn;

    @FindBy(xpath = "//div[@class='col-12 centered-col']")
    public WebElement oformBtn;

    public SendFormPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectPolicy(String menuItem1, String menuItem2) {
        minBtn.findElement(By.xpath(".//h3[text()='"+menuItem1+"']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12 centered-col']")));
        oformBtn.findElement(By.xpath(".//button[contains(text(), '"+menuItem2+"')]")).click();
    }

    @FindBy(id = "surname_vzr_ins_0")
    public WebElement surname;

    @FindBy(id = "name_vzr_ins_0")
    WebElement name;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate;

    @FindBy(id = "person_lastName")
    WebElement person_lastName;

    @FindBy(id = "person_firstName")
    WebElement person_firstName;

    @FindBy(id = "person_middleName")
    WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    WebElement person_birthDate;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "//div[@class='col-xl-3 col-md-4 col-12'][2]")
    public WebElement continueButton;

    public void selectContinue(String menuItem){
        continueButton.findElement(By.xpath(".//button[contains(text(), '"+menuItem+"')]")).click();
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия / Surname":
                fillField(surname, value);
                break;
            case  "Имя / Name":
                fillField(name, value);
                break;
            case  "Дата рождения":
                fillField(birthDate, value);
                break;
            case  "Фамилия":
                fillField(person_lastName, value);
                break;
            case  "Имя":
                fillField(person_firstName, value);
                break;
            case  "Отчество":
                fillField(person_middleName, value);
                break;
            case  "Дата рождения2":
                fillField(person_birthDate, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case  "Дата выдачи":
                fillField(documentDate, value);
                break;
            case  "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия / Surname":
                return surname.getAttribute("value");
            case  "Имя / Name":
                return name.getAttribute("value");
            case  "Дата рождения":
                return birthDate.getAttribute("value");
            case  "Фамилия":
                return person_lastName.getAttribute("value");
            case  "Имя":
                return person_firstName.getAttribute("value");
            case  "Отчество":
                return person_middleName.getAttribute("value");
            case  "Дата рождения2":
                return person_birthDate.getAttribute("value");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
            case  "Дата выдачи":
                return documentDate.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
    public void checkFieldErrorMessage(String errorMessage){
        String xpath = "//*[@class = 'alert-form alert-form-error']";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }


    protected void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }
}
