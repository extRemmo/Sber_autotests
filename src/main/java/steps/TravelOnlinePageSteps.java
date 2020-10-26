package steps;

import PObjects.InsurePage;
import PObjects.TravelOnlinePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelOnlinePageSteps {
    @Step("выполнено нажатие на Оформить онлайн")
    public void selectTravelOnline(String menuItem){
        new TravelOnlinePage().selectTravelOnline(menuItem);
    }
}
