package Steps;

import PObjects.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps  {

    @Step("выбран пункт меню {0}")
    public void selectMainMenu(String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void selectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }

}