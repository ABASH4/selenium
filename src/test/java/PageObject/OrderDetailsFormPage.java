package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import PageObject.BaseUITest;

public class OrderDetailsFormPage extends BaseUITest {
    private final WebDriver driver;

    public OrderDetailsFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By customerName = By.xpath(".//input[@placeholder = '* Имя']");
    private final By customerLastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By customerAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By whenMetroStation = By.xpath(".//input[@class='select-search__input']");

    private final By customerPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By inputDataBlock = By.className("App_App__15LM-");
    private final By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By backButton = By.xpath(".//[@class=Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i]");
    // Форма 2. Поле 'Когда привезти самокат'
    private final By whenOrderDate = By.className("Input_Responsible__1jDKN");
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    private final By selectRentalPeriod = By.xpath(".//div[contains(text(),'двое суток')]");
    private final By colourTool = By.xpath(".//input[@id = 'black']");
    private final By commentCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    public OrderDetailsFormPage fillOrderDetailsForm(Order order) {
        fillName(order.getName());
        fillLastName(order.getLastName());
        fillAddress(order.getAddress());
        fillMetroStation(order.getMetroStation());
        fillPhone(order.getPhone());
        clickFurtherButton();
        fillOrderDate(order.getOrderDate());
        fillRentalPeriod();
        clickColourTool();
        fillCommentCourier(order.getOrderComment());
        clickFurtherButton();
        clickFurtherButton();


        return this;
    }

    private OrderDetailsFormPage fillName(String name) {
        driver.findElement(customerName).sendKeys(name);
        return this;
    }

    private OrderDetailsFormPage fillLastName(String lastName) {
        driver.findElement(customerLastName).sendKeys(lastName);
        return this;
    }

    private OrderDetailsFormPage fillAddress(String address) {
        driver.findElement(customerAddress).sendKeys(address);
        return this;
    }

    private OrderDetailsFormPage fillMetroStation(String metroStation) {
        driver.findElement(whenMetroStation).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    // Номер телефона
    private OrderDetailsFormPage fillPhone(String phone) {
        driver.findElement(customerPhone).sendKeys(phone);
        return this;
    }

    // Нажать кнопку Далее
    private OrderDetailsFormPage clickFurtherButton() {
        driver.findElement(furtherButton).click();
        return this;
    }

    //Выбор даты
    private OrderDetailsFormPage fillOrderDate(String orderDate) {
        driver.findElement(whenOrderDate).click();
        driver.findElement(whenOrderDate).sendKeys(orderDate + Keys.ENTER);
        return this;
    }

    //Выбор срока аренды
    private OrderDetailsFormPage fillRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(selectRentalPeriod).click();
        return this;
    }
    private OrderDetailsFormPage clickColourTool() {
        driver.findElement(colourTool).click();
        return this;
    }
    private OrderDetailsFormPage fillCommentCourier(String orderComment) {
        driver.findElement(commentCourier).click();
        driver.findElement(commentCourier).sendKeys(orderComment);
        return this;
    }


}