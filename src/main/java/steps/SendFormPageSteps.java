package steps;

import PObjects.InsurePage;
import PObjects.SendFormPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendFormPageSteps {

    @Step("выбрана сумма защиты и начато оформление")
    public void selectPolicy (String menuItem1, String menuItem2){
        new SendFormPage().selectPolicy(menuItem1, menuItem2);
    }


    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SendFormPage().fillField(field, value);
    }
    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendFormPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField( String value){
        new SendFormPage().checkFieldErrorMessage(value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("нажата кнопка Продолжить")
    public void selectContinue (String menuItem){
        new SendFormPage().selectContinue(menuItem);
    }
}
