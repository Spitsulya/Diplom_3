package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Ввод email
    private static final By inputEmail = By.xpath(".//*[text()='Личный Кабинет']");
    // Ввод Пароль
    private static final By inputPassword = By.xpath(".//*[text()='Пароль']");
    //Кнопка Войти
    private static final By loginButton = By.xpath(".//button[text()='Войти']");
    // Кнопка Зарегистрироваться
    private static final By registerButton = By.xpath(".//*[text()='Зарегистрироваться']");
    // Кнопка восстановить пароль
    private static final By recoverPasswordButton = By.xpath(".//*[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickregisterButton() {
        driver.findElement(registerButton).click();
    }
}
