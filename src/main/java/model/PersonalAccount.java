package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccount {

    private WebDriver driver;

    // Кнопка выход
    private static final By PA_EXIT_BUTTON = By.xpath(".//button[text()='Выход']");

    public PersonalAccount(WebDriver driver) {
        this.driver = driver;
    }

    public static By getPAexitButtonLocator() {
        return PA_EXIT_BUTTON;
    }
}
