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


public class ConstructorTest {

    private WebDriver driver;

    private MainPage mainPage;
    private LoginPage loginPage;

    private BurgerServiceClient client;
    private String userAccessToken;

    private String userPassword;
    private String userName;
    private String userEmail;
    private Faker faker;

    @Before
    public void setUp() {

        driver = WebDriverFactory.getDefaultDriver();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        faker = new Faker();
        userEmail = faker.internet().emailAddress();
        userPassword = faker.internet().password(6, 10);
        userName = faker.name().fullName();

        client = new BurgerServiceClient();
        userAccessToken = client.createUserPostRequest(userEmail, userPassword, userName).extract().path("accessToken");

        loginPage.openStellarBurgersURL();
        loginPage.inputAllRegisterFieldsAndGo(userEmail, userPassword);
        mainPage.clickAccountButton();

    }

    @Test
    @DisplayName("Successful transition to Constructor page from Personal Account")
    @Description("A test that verifies that a user can register, login and go to Constructor page from Personal account using Constructor button.")
    public void testConstructorButtonTransition() {

        mainPage.clickConstructorButton();

        assertTrue("The transfer to the Personal Account has not been completed", mainPage.isTitleDisplayed());
    }

    @Test
    @DisplayName("Successful transition to Constructor page from Personal Account")
    @Description("A test that verifies that a user can register, login and go to Constructor page from Personal account using LOGO.")
    public void testConstructorLogoTransition() {

        mainPage.clickLogoButton();

        assertTrue("The transfer to the Personal Account has not been completed", mainPage.isTitleDisplayed());
    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            client.deleteUser(userAccessToken);
        }

        driver.quit();
    }
}