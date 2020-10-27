package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;


public class ScenarioSteps  {
    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurePageSteps insurePageSteps = new InsurePageSteps();
    TravelOnlinePageSteps travelOnlinePageSteps = new TravelOnlinePageSteps();
    SendFormPageSteps sendFormPageSteps = new SendFormPageSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMainMenu(String menuName){
        mainPageSteps.selectMainMenu(menuName);
    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void selectSubMenu(String menuName){
        mainPageSteps.selectSubMenu(menuName);
    }

    @Then("^заголовок страницы \"(.+)\"$")
    public void checkTitleInsurePage(String title){
        insurePageSteps.checkPageTitle(title);
    }

    @When("^выполнено нажатие на кнопку \"(.+)\"$")
    public void selectTravelMenu(String menuName){
        insurePageSteps.selectTravelMenu(menuName);
        //для перехода на необходимую вкладку переключаем драйвер на неё
        ArrayList tabs = new ArrayList(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window((String) tabs.get(1));
    }

    @Then("^заголовок страницы СберСтрахование равен \"(.+)\"$")
    public void checkTitleTravelOnlinePage(String title) throws InterruptedException {
        Thread.sleep(8000);
        travelOnlinePageSteps.checkPageTitle(title);
    }

    @When("^выполнено нажатие по кнопке \"(.+)\"$")
    public void selectTravelOnline(String menuName){
        travelOnlinePageSteps.selectTravelOnline(menuName);
    }

    @Then("^заголовок страницы Страхование путешественников равен \"(.+)\"$")
    public void checkTitleSendPage(String title)  {
        sendFormPageSteps.checkPageTitle(title);
    }

    @When("^выбрана сумма страхования \"(.+)\"$")
    public void selectPolicy(String menuItem){
        sendFormPageSteps.selectPolicy(menuItem);
    }

    @When("^Выполнено нажатие на кнопку \"(.+)\"$")
    public void selectRegButton(String menuItem){
        sendFormPageSteps.selectRegButton(menuItem);
    }

    @Then("^заголовок второй страницы Страхование путешественников равен \"(.+)\"$")
    public void checkSecondTitleSendPage(String title)  {
        sendFormPageSteps.checkSecondPageTitle(title);
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendFormPageSteps.fillField(field, value));

    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendFormPageSteps.checkFillField(field, value));
    }

    @When("^Произведено нажатие на кнопку \"(.+)\"$")
    public void selectContinue(String menuItem){
        sendFormPageSteps.selectContinue(menuItem);
    }

    @Then("^Появилось сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessageField(String value)  {
        sendFormPageSteps.checkErrorMessageField(value);
    }
}
