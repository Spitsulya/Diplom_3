package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    // Ввод Имя
    private static final By inputName = By.xpath(".//fieldset[1]//input[@name='name']");
    // Ввод Email
    private static final By inputEmail = By.xpath(".//fieldset[2]//input[@name='name']");
    // Ввод Пароль
    private static final By inputPassword = By.xpath(".//fieldset[3]//input[@name='Пароль']");
    //Кнопка Зарегистрироваться
    private static final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // Кнопка Войти
    private static final By loginButton = By.xpath(".//*[text()='Войти']");
    // Ошибка пароля
    private static final By passwordError = By.xpath(".//*[text()='Пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String userName) {
        driver.findElement(inputName).sendKeys(userName);
    }

    public void setEmail(String userEmail) {
        driver.findElement(inputEmail).sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        driver.findElement(inputPassword).sendKeys(userPassword);
    }

    @Step("Click on the Register button on the RegisterPage form")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    private void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isLoginButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если кнопка не появилась, возвращаем false
        }
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }

    @Step("Filling in all fields on the registration form and click on the Register button")
    public void inputAllRegisterFieldsAndGo(String userName, String userEmail, String userPassword) {
        waitForElementToBeVisible(inputName);
        setName(userName);
        setEmail(userEmail);
        setPassword(userPassword);
        clickRegisterButton();
    }

}
