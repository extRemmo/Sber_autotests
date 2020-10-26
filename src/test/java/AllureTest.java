import PObjects.TravelOnlinePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.ArrayList;
import java.util.HashMap;


public class AllureTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurePageSteps insurePageSteps = new InsurePageSteps();
    TravelOnlinePageSteps travelOnlinePageSteps = new TravelOnlinePageSteps();
    SendFormPageSteps sendFormPageSteps = new SendFormPageSteps();
    HashMap<String, String> testData = new HashMap<>();

    @Title("Заявка на СберСтрахование")
    @Test
    public void Test() throws InterruptedException {
        mainPageSteps.selectMainMenu("Страхование");
        mainPageSteps.selectSubMenu("СберСтрахование");

        insurePageSteps.checkPageTitle("Страхование путешественников");
        insurePageSteps.selectTravelMenu("Оформить онлайн");

        //для перехода на необходимую вкладку переключаем драйвер на неё
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));

        travelOnlinePageSteps.selectTravelOnline("Оформить онлайн");

        sendFormPageSteps.selectPolicy("Минимальная", "Оформить");

        testData.put("Фамилия / Surname","Грачев");
        testData.put("Имя / Name","Дмитрий");
        testData.put("Дата рождения","29.12.1993");
        testData.put("Фамилия","Грачев");
        testData.put("Имя","Дмитрий");
        testData.put("Отчество","Евгеньевич");
        testData.put("Дата рождения2","01.10.2002");
        testData.put("Серия паспорта","8888");
        testData.put("Номер паспорта","999999");
        testData.put("Дата выдачи","01.01.2019");
        testData.put("Кем выдан","Отделением УФМС России");

        sendFormPageSteps.fillFields(testData);
        sendFormPageSteps.checkFillFields(testData);
        sendFormPageSteps.selectContinue("Продолжить");

        sendFormPageSteps.checkErrorMessageField("При заполнении данных произошла ошибка");

    }

}
