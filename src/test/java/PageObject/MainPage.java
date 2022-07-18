package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    // Драйвер
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Главная страница
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Открыть ссылку
    public MainPage open() {
        driver.get(URL);
        return this;
    }

    // Кнопка "Статус заказа"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");

    // Поле ввода номера заказа для проверки статуса
    private final By orderNameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");

    // Кнопка "Go!"
    private final By searchOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    //Кнопка "Заказать"
    private final By orderButton = By.className("Button_Button__ra12g");

    //Клик по кнопкам с вопросами (аккордеон)
    public OrderDetailsFormPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return new OrderDetailsFormPage(driver);
    }
    // Клик по полю ввода номера заказа и ввод(статус)
    public MainPage enterOrderNumber(String orderNumber) {
        driver.findElement(orderNameInput).sendKeys(orderNumber);
        return this;
    }
    // Поиск заказа
    public MainPage clickSearchOrderButton() {
        driver.findElement(searchOrderButton).click();
        return new MainPage(driver);
    }
    // Скролл до аккордеона
    public MainPage scrollToAccordion() {
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //Кнопки с вопросами (аккордеон)
    public static String questionAccordionButton = "accordion__heading-%s";
    // Ответы на вопросы (аккордеон)
    public static String answerAccordionText = "accordion__panel-%s";
    //Динамический номер для локатора кнопок
    public static By accordionButton(String number) {
        return By.id(String.format(questionAccordionButton, number));
    }
    //Динамический номер для локатора ответов
    public static By accordionText(String number) {
        return By.id(String.format(answerAccordionText, number));
    }

    //Клик по кнопкам с вопросами (аккордеон)
    public MainPage clickAccordionButton(String number) {
        driver.findElement(accordionButton(number)).click();
        return this;
    }
    //Возвращение текста ответов на вопросы (аккордеон)
    public String getAccordionText(String number) {
        return driver.findElement(accordionText(number)).getText();
    }

}
