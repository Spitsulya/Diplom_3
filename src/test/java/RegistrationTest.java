import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.LoginPage;
import model.MainPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import client.BurgerServiceClient;
import static org.junit.Assert.assertTrue;


public class RegistrationTest {

    private WebDriver driver;

    private MainPage mainPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    private BurgerServiceClient client;
    private String userAccessToken;

    private String userPassword;
    private String invalidUserPassword;
    private String userName;
    private String userEmail;

    private Faker faker;


    @Before
    public void setUp() {

        driver = WebDriverFactory.getDefaultDriver();

        mainPage = new MainPage(driver);
        mainPage.openStellarBurgersURL();

        faker = new Faker();
        userEmail = faker.internet().emailAddress();
        userPassword = faker.internet().password(6, 10);
        invalidUserPassword = faker.internet().password(1, 5);
        userName = faker.name().fullName();

        client = new BurgerServiceClient();
    }

    @Test
    @DisplayName("Successful registration with valid password")
    @Description("A test that verifies that a user can register by entering valid data (password of more than six characters.")
    public void testRegistrationPasswordGreaterThanSixSuccessfully() {

        mainPage.clickAccountButton();

        loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        registerPage = new RegisterPage(driver);
        registerPage.inputAllRegisterFieldsAndGo(userName, userEmail, userPassword);

        assertTrue("The login page does not appear - authorization is not successful.", registerPage.isLoginLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Impossible registration with invalid password")
    @Description("A test that verifies that a user cannot register by entering a password of less than 6 characters.")
    public void testRegistrationPasswordLessThanSixSuccessfully() {

        mainPage.clickAccountButton();

        loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        registerPage = new RegisterPage(driver);
        registerPage.inputAllRegisterFieldsAndGo(userName, userEmail, invalidUserPassword);

        assertTrue("The password entry error is not displayed when entering less than six characters.", registerPage.isPasswordErrorDisplayed());
    }

    @After
    public void tearDown() {

        userAccessToken = client.loginUser(userEmail, userPassword, userName).extract().path("accessToken");
        if (userAccessToken != null) {
            client.deleteUser(userAccessToken);
        }

        driver.quit();
    }
}
