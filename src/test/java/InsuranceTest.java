import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;


public class InsuranceTest extends BaseTest {


    @Test
    public void  testInsurance() throws InterruptedException {
        //Перейти на страницу https://www.sberbank.ru/ru/person
        driver.get(baseUrl);
        //Нажать на – Страхование
        driver.findElement(By.xpath("//*[text() = 'Страхование'][contains(@class, 'kitt-top')]")).click();
        //Нажать на – СберСтрахование
        driver.findElement(By.xpath("//*[text() = 'СберСтрахование'][contains(@class, 'kitt-top')]")).click();
        //ожидается прогрузка и появление заголовка на странице
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        WebElement title = driver.findElement(By.xpath("//h2[text() = 'Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(title));
        //Проверить наличие на странице заголовка – Страхование путешественников
        Assert.assertEquals("Страхование путешественников", title.getText());
        //закрыть всплывающее окно
        driver.findElement(By.xpath("//button[contains(@class, 'kitt-cookie-warning__close')]")).click();
        //Нажать кнопку "Оформить онлайн" в разделе "Страхование путешественников"
        WebElement onlButton = driver.findElement(By.xpath("//a[contains(@href, 'travel')]//span[contains(text(), 'Оформить онлайн')]"));
        wait.until(ExpectedConditions.elementToBeClickable(onlButton));
        onlButton.click();


        //переключаем драйвер на новую вкладку в браузере
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        //Нажать на Оформить онлайн, дожидаясь кликабельности элемента
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='s-hero-banner__btn s-btn']")));
        System.out.println(driver.getTitle());
        WebElement applyOnlineBtn = driver.findElement(By.xpath("//a[contains(@class, 'banner')][contains(text(),'Оформить онлайн')]"));
        applyOnlineBtn.click();

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        driver.findElement(By.xpath("//h3[contains(text(), 'Минимальная')]")).click();
        //Нажать Оформить
        WebElement arrange = driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]"));
        Actions actToMin= new Actions(driver);
        actToMin.moveToElement(arrange).click().build().perform();

        //Ожидание появления вкладки "Оформление"
        WebElement titleReg = driver.findElement(By.xpath("//*[@class='col-4 step-element active']/a[text()='Оформление']"));
        wait.until(ExpectedConditions.visibilityOf(titleReg));
        Assert.assertEquals("Оформление", titleReg.getText());
        //На вкладке "Оформление" заполнить поля:
        fillField (By.id("surname_vzr_ins_0"), "Грачев");
        fillField (By.id("name_vzr_ins_0"), "Дмитрий");
        fillField (By.id("birthDate_vzr_ins_0"), "29121993");
        driver.findElement(By.id("person_lastName")).click();
        fillField (By.id("person_lastName"), "Грачев");
        fillField (By.id("person_firstName"), "Дмитрий");
        fillField (By.id("person_middleName"), "Евгеньевич");
        fillField (By.id("person_birthDate"), "01.10.2002");

        WebElement element = driver.findElement(By.xpath("//div[@class='btn-group']/label[text()='Мужской']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        driver.findElement(By.id("passportSeries")).click();
        fillField (By.id("passportSeries"), "8888");
        fillField (By.id("passportNumber"), "999999");
        fillField (By.id("documentDate"), "01012019");
        driver.findElement(By.id("documentIssue")).click();
        fillField (By.id("documentIssue"), "Отделением УФМС России");

        //проверим что поля заполнены верными значениями
        Assert.assertEquals("Грачев", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Дмитрий", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("29.12.1993", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));

        Assert.assertEquals("Грачев", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Дмитрий", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Евгеньевич", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("01.10.2002", driver.findElement(By.id("person_birthDate")).getAttribute("value"));

        Assert.assertEquals("8888", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("999999", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("01.01.2019", driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("Отделением УФМС России", driver.findElement(By.id("documentIssue")).getAttribute("value"));
        //Нажать продолжить
        driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]")).click();
        //Проверить, что появилось сообщение - При заполнении данных произошла ошибка
        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class = 'alert-form alert-form-error']")).getText());


    }

}
