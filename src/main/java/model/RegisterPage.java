package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static model.LoginPage.getLoginLoginButtonLocator;

public class RegisterPage {

    private WebDriver driver;

    // URL страницы регистрации
    private static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    // Ввод Имя
    private static final By REGISTER_INPUT_NAME = By.xpath(".//fieldset[1]//input[@name='name']");
    // Ввод Email
    private static final By REGISTER_INPUT_EMAIL = By.xpath(".//fieldset[2]//input[@name='name']");
    // Ввод Пароль
    private static final By REGISTER_INPUT_PASSWORD = By.xpath(".//fieldset[3]//input[@name='Пароль']");
    //Кнопка Зарегистрироваться
    private static final By REGISTER_REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    // Кнопка Войти
    private static final By REGISTER_LOGIN_BUTTON = By.xpath(".//*[text()='Войти']");
    // Ошибка пароля
    private static final By REGISTER_PASSWORD_ERROR = By.xpath(".//*[text()='Пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String userName) {
        driver.findElement(REGISTER_INPUT_NAME).sendKeys(userName);
    }

    public void setEmail(String userEmail) {
        driver.findElement(REGISTER_INPUT_EMAIL).sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        driver.findElement(REGISTER_INPUT_PASSWORD).sendKeys(userPassword);
    }

    @Step("Click on the Register button on the RegisterPage form")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_REGISTER_BUTTON).click();
    }

    public void clickLoginButton() {
        driver.findElement(REGISTER_LOGIN_BUTTON).click();
    }

    private void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isLoginLoginButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginLoginButtonLocator()));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если кнопка не появилась, возвращаем false
        }
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(REGISTER_PASSWORD_ERROR).isDisplayed();
    }

    @Step("Filling in all fields on the registration form and click on the Register button")
    public void inputAllRegisterFieldsAndGo(String userName, String userEmail, String userPassword) {
        waitForElementToBeVisible(REGISTER_INPUT_NAME);
        setName(userName);
        setEmail(userEmail);
        setPassword(userPassword);
        clickRegisterButton();
    }

    public static String getRegisterPageUrl() {
        return REGISTER_PAGE_URL;
    }

    public static By getRegisterLoginButtonLocator() {
        return REGISTER_LOGIN_BUTTON;
    }

}
