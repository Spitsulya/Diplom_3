import com.github.javafaker.Faker;
import dataAPI.BurgerServiceClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import model.*;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class PersonalAccountTest {

    private WebDriver driver;
    private static final String DEFAULT_BROWSER_NAME = "Chrome";
    private static final String BROWSER_YANDEX = "Yandex";

    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAccount personalAccount;

    private BurgerServiceClient client;
    private String userAccessToken;

    private String userPassword;
    private String userName;
    private String userEmail;

    private Faker faker;

    @Before
    public void setUp() {

        driver = WebDriverFactory.setBrowser(DEFAULT_BROWSER_NAME);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAccount = new PersonalAccount(driver);

        faker = new Faker();
        userEmail = faker.internet().emailAddress();
        userPassword = faker.internet().password(6, 10);
        userName = faker.name().fullName();

        client = new BurgerServiceClient();
        userAccessToken = client.createUserPostRequest(userEmail, userPassword, userName).extract().path("accessToken");

    }

    @Test
    @DisplayName("Successful transition to Personal Account")
    @Description("A test that verifies that a user can register, login and go to Personal account.")
    public void testLoginAndGoToPersonalAccount() {

        loginPage.openStellarBurgersURL();
        loginPage.inputAllRegisterFieldsAndGo(userEmail, userPassword);

        mainPage.clickAccountButton();

        assertTrue("The transfer to the Personal Account has not been completed", personalAccount.isExitDisplayed());
    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            client.deleteUser(userAccessToken);
        }

        driver.quit();
    }
}