package model;
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

    public static String getForgotPasswordPageUrl() {
        return FORGOT_PASSWORD_PAGE_URL;
    }

    public static By getFPLoginButtonLocator() {
        return FP_LOGIN_BUTTON;
    }


}
