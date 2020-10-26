package steps;

import PObjects.InsurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsurePageSteps {

    @Step("заголовок страницы - Страхование равен {0}")
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
