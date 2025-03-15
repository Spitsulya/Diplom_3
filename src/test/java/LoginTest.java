import com.github.javafaker.Faker;
import client.BurgerServiceClient;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;

    private BurgerServiceClient client;
    private String userAccessToken;

    private String userPassword;
    private String userName;
    private String userEmail;

    private Faker faker;

    @Parameterized.Parameter(0)
    public String pageUrl; // URL страницы
    @Parameterized.Parameter(1)
    public By buttonLocator; // Локатор кнопки

    @Parameterized.Parameters(name = "{index}: testLogin(pageUrl={0}, buttonLocator={1})")
    public static Object[][] loginButtonProvider() {
        return new Object[][] {
                {MainPage.getPageUrl(), MainPage.getMainAccountButtonLocator()}, // Вход через кнопку «Войти в аккаунт»
                {MainPage.getPageUrl(), MainPage.getMainLoginButtonLocator()}, // Вход через кнопку «Личный кабинет»
                {RegisterPage.getRegisterPageUrl(), RegisterPage.getRegisterLoginButtonLocator()}, // Вход через кнопку в форме регистрации
                {ForgotPasswordPage.getForgotPasswordPageUrl(), ForgotPasswordPage.getFPLoginButtonLocator()} // Вход через кнопку в форме восстановления пароля
        };
    }

    @Before
    public void setUp() {

        driver = WebDriverFactory.getDefaultDriver();

        loginPage = new LoginPage(driver);

        faker = new Faker();
        userEmail = faker.internet().emailAddress();
        userPassword = faker.internet().password(6, 10);
        userName = faker.name().fullName();

        client = new BurgerServiceClient();
        userAccessToken = client.createUserPostRequest(userEmail, userPassword, userName).extract().path("accessToken");

    }

    @Test
    @DisplayName("Successful login operation using four buttons")
    @Description("A test that verifies that a user can register and login using four login buttons and three URL pages.")
    public void testUserLoginUsingFourButtons() {

        openURL(pageUrl);
        clickButton(buttonLocator);
        loginPage.inputAllRegisterFieldsAndGo(userEmail, userPassword);

        assertTrue("The login was not successful.", loginPage.isTitleDisplayed());
    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            client.deleteUser(userAccessToken);
        }

        driver.quit();
    }

    @Step("Open Stellar Burgers URL depending on the page.")
    public  void openURL(String pageUrl) {
        driver.get(pageUrl);
    }

    @Step("Clicking on the Login button depending on the button locator.")
    public void clickButton(By buttonLocator) {
        WebElement button = driver.findElement(buttonLocator);
        button.click();
    }
}
