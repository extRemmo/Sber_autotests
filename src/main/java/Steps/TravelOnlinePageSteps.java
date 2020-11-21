package Steps;

import PObjects.TravelOnlinePage;
import ru.yandex.qatools.allure.annotations.Step;


import static org.junit.Assert.assertTrue;

public class TravelOnlinePageSteps {
    @Step("заголовок страницы СберСтрахование равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new TravelOnlinePage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выполнено нажатие на Оформить онлайн")
    public void selectTravelOnline(String menuItem){
        new TravelOnlinePage().selectTravelOnline(menuItem);
    }

}
