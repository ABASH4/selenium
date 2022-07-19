package tests;

import page.object.BaseUITest;
import page.object.MainPage;
import model.Order;
import page.object.OrderDetailsFormPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderPageScooterTest extends BaseUITest {
    private final Order order;
    public OrderPageScooterTest(Order order){
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object order() {
        return new Object[][] {
                {new Order("Алексей", "Иванов", "Москва", "Черкизовская", "89555555555", "25.07.2022", "трое суток", "black", "Позвонить у двери")},
                {new Order("Антон", "Петров", "Самара", "Сокольники", "89234567890", "26.07.2022", "сутки", "grey", " ")}
        };
    }

    @Test
    public void orderScooter() {

        OrderDetailsFormPage isInputDataBlockDisplayed = new MainPage(driver)
                .open()
                .clickOrderButton()
                .fillOrderDetailsForm(order);

    }
}