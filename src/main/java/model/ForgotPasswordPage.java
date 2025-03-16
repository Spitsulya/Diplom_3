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

    @Step("Open Stellar Burgers 'forgot-password' page URL")
    public void openStellarBurgersForgotURL() {
        driver.get(FORGOT_PASSWORD_PAGE_URL);
    }

    @Step("Click on the 'Login' button on the 'forgot-password' page")
    public void clickLoginButton() {
        driver.findElement(FP_LOGIN_BUTTON).click();
    }

}
