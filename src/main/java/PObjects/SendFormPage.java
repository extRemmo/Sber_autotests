package PObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SendFormPage {
    WebDriver driver;
    @FindBy(xpath = "//h3[contains(text(), 'Минимальная')]")
    public WebElement minBtn;

    @FindBy(xpath = "//button[contains(text(), 'Оформить')]")
    public WebElement oformBtn;

    public SendFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    public WebElement continueButton;

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
    protected void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }
}
