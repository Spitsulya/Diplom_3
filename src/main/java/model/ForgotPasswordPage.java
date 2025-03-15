package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    // URL страницы восстановления пароля
    private static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    // Кнопка Войти
    private static final By FP_LOGIN_BUTTON = By.xpath(".//*[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Getting 'forgot-password' page URL")
    public static String getForgotPasswordPageUrl() {
        return FORGOT_PASSWORD_PAGE_URL;
    }

    @Step("Getting login button locator on the 'forgot-password' page")
    public static By getFPLoginButtonLocator() {
        return FP_LOGIN_BUTTON;
    }


}
