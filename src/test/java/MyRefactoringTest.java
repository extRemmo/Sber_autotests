import PObjects.InsurePage;
import PObjects.MainPage;
import PObjects.SendFormPage;
import PObjects.TravelOnlinePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest() throws InterruptedException {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);

        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("СберСтрахование");

        InsurePage insurePage = new InsurePage(driver);
        insurePage.selectTravelMenu("Оформить онлайн");

        Thread.sleep(8000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        new TravelOnlinePage(driver);

        new SendFormPage(driver).minBtn.click();
        Thread.sleep(5000);
        new SendFormPage(driver).oformBtn.click();

        SendFormPage sendFormPage = new SendFormPage(driver);
        sendFormPage.fillField("Фамилия / Surname", "Грачев");
        sendFormPage.fillField("Имя / Name", "Дмитрий");
        sendFormPage.fillField("Дата рождения", "29121993");
        sendFormPage.fillField("Фамилия", "Грачев");
        sendFormPage.fillField("Имя", "Дмитрий");
        sendFormPage.fillField("Отчество", "Евгеньевич");
        sendFormPage.fillField("Дата рождения2", "01.10.2002");
        sendFormPage.fillField("Серия паспорта", "8888");
        sendFormPage.fillField("Номер паспорта", "999999");
        sendFormPage.fillField("Дата выдачи", "01012019");
        sendFormPage.fillField("Кем выдан", "Отделением УФМС России");
        new SendFormPage(driver).continueButton.click();

        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class = 'alert-form alert-form-error']")).getText());
        Thread.sleep(5000);

    }
}
