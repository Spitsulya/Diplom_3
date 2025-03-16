import com.github.javafaker.Faker;
import client.BurgerServiceClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import model.*;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;
    private MainPage mainPage;
    private ForgotPasswordPage forgotPasswordPage;
    private RegisterPage registerPage;

    private BurgerServiceClient client;
    private String userAccessToken;

    private String userPassword;
    private String userName;
    private String userEmail;

    private Faker faker;


    @Before
    public void setUp() {

        driver = WebDriverFactory.getDefaultDriver();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        registerPage = new RegisterPage(driver);

        faker = new Faker();
        userEmail = faker.internet().emailAddress();
        userPassword = faker.internet().password(6, 10);
        userName = faker.name().fullName();

        client = new BurgerServiceClient();
        userAccessToken = client.createUserPostRequest(userEmail, userPassword, userName).extract().path("accessToken");

    }

    @Test
    @DisplayName("Successful login operation using 'personal account' button ('main' page)")
    @Description("A test that verifies that a user can register and login using 'Personal Account' button from main page.")
    public void testUserLoginUsingMainAccountButton() {

        mainPage.openStellarBurgersMainURL();
        mainPage.clickAccountButton();

        loginPage.inputAllRegisterFieldsAndGo(userEmail, userPassword);

        assertTrue("The login was not successful.", loginPage.isTitleDisplayed());
    }

    @Test
    @DisplayName("Successful login operation using 'login' button ('main' page)")
    @Description("A test that verifies that a user can register and login using 'Login' button from main page.")
    public void testUserLoginUsingMainLoginButton() {

        mainPage.openStellarBurgersMainURL();
        mainPage.clickLoginButton();

        loginPage.inputAllRegisterFieldsAndGo(userEmail, userPassword);

        assertTrue("The login was not successful.", loginPage.isTitleDisplayed());
    }

    @Test
    @DisplayName("Successful login operation using 'login' button ('register' page)")
    @Description("A test that verifies that a user can register and login using 'Login' button from 'register' page.")
    public void testUserLoginUsingRegisterLoginButton() {

        registerPage.openStellarBurgersRegisterURL();
        registerPage.clickLoginButton();

        loginPage.inputAllRegisterFieldsAndGo(userEmail, userPassword);

        assertTrue("The login was not successful.", loginPage.isTitleDisplayed());
    }

    @Test
    @DisplayName("Successful login operation using 'login' button ('forgot-password' page)")
    @Description("A test that verifies that a user can register and login using 'Login' button from 'forgot-password' page.")
    public void testUserLoginUsingForgotLoginButton() {

        forgotPasswordPage.openStellarBurgersForgotURL();
        forgotPasswordPage.clickLoginButton();

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
}
