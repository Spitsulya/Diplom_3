package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static model.MainPage.getMainTittleCreateBurgerLocator;

public class LoginPage {

    private WebDriver driver;

    // URL страницы Логин
    private static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    // Ввод Email
    private static final By LOGIN_INPUT_EMAIL = By.xpath(".//fieldset[1]//input[@name='name']");
    // Ввод Пароль
    private static final By LOGIN_INPUT_PASSWORD = By.xpath(".//fieldset[2]//input[@name='Пароль']");
    // Кнопка Войти
    private static final By LOGIN_LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    // Кнопка Зарегистрироваться
    private static final By LOGIN_REGISTER_BUTTON = By.xpath(".//*[text()='Зарегистрироваться']");
    // Кнопка Восстановить пароль
    private static final By LOGIN_RECOVER_PASSWORD_BUTTON = By.xpath(".//*[text()='Восстановить пароль']");
    // Заголовок Соберите бургер
    private static final By LOGIN_TITTLE_CREATE_BURGER = By.xpath(".//*[text()='Соберите бургер']");
    // Заголовок Вход
    private static final By LOGIN_TITTLE = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Stellar Burgers login URL")
    public  void openStellarBurgersURL() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void clickRegisterButton() {
        driver.findElement(LOGIN_REGISTER_BUTTON).click();
    }

    public void setEmail(String userEmail) {
        driver.findElement(LOGIN_INPUT_EMAIL).sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        driver.findElement(LOGIN_INPUT_PASSWORD).sendKeys(userPassword);
    }

    @Step("Click on the Login button on the RegisterPage form")
    public void clickLoginButton() {
        driver.findElement(LOGIN_LOGIN_BUTTON).click();
    }

    @Step("Filling in all fields on the login form and click on the Login button")
    public void inputAllRegisterFieldsAndGo(String userEmail, String userPassword) {
        setEmail(userEmail);
        setPassword(userPassword);
        clickLoginButton();
    }

    @Step("Checking successfull user login")
    public boolean isTitleDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(getMainTittleCreateBurgerLocator()));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если заголовок не появился, возвращаем false
        }
    }

    @Step("Checking successfully exiting form account")
    public boolean isEntranceDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_TITTLE));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если заголовок не появился, возвращаем false
        }
    }

    public static By getLoginLoginButtonLocator() {
        return LOGIN_LOGIN_BUTTON;
    }
}
