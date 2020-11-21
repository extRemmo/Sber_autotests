package steps;

import PObjects.InsurePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsurePageSteps {
    @Step("заголовок страницы - Страхование равен {0}")
    public void checkPageTitle(String expectedTitle){
       String actualTitle = new InsurePage().title.getText().replaceAll("\n", " ");
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }


    @Step("выполнено нажатие на кнопку {0}")
    public void selectTravelMenu(String menuItem){
        new InsurePage().selectTravelMenu(menuItem);
    }
}
