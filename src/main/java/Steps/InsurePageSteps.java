package Steps;

import PObjects.InsurePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsurePageSteps extends BaseSteps {

    @Step("заголовок раздела - Страхование равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new InsurePage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }


    @Step("выполнено нажатие на Оформить онлайн")
    public void selectTravelMenu(String menuItem){
        new InsurePage().selectTravelMenu(menuItem);
    }
}
