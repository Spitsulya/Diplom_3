import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import model.*;
import org.openqa.selenium.WebDriver;
import org.junit.Test;


public class ConstructorSectionsTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {

        driver = WebDriverFactory.getDefaultDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        mainPage.openStellarBurgersURL();

    }

    @Test
    @DisplayName("Successful transition to Constructor sections {bun}")
    @Description("A test that allows to check the correct moving between tabs: from 'Filling' to 'Bun'.")
    public void testBunTabActivation() {

        mainPage.clickFillingTab();
        mainPage.clickBunTab();
        Assert.assertTrue("The tab 'Bun' should be active.", mainPage.isBunTabActive());

    }

    @Test
    @DisplayName("Successful transition to Constructor sections {souse}")
    @Description("A test that allows to check the correct moving between tabs: from 'Bun' to 'Souse'.")
    public void testSauceTabActivation() {

        Assert.assertFalse("The tab 'Souse' is mistakenly active.", mainPage.isSauceTabActive());
        mainPage.clickSouseTab();
        Assert.assertTrue("The tab 'Souse' should be active.", mainPage.isSauceTabActive());
    }

    @Test
    @DisplayName("Successful transition to Constructor sections {filling}")
    @Description("A test that allows to check the correct moving between tabs: from 'Bun' to 'Filling'.")
    public void testFillingTabActivation() {

        Assert.assertFalse("The tab 'Filling' is mistakenly active.", mainPage.isFillingTabActive());
        mainPage.clickFillingTab();
        Assert.assertTrue("The tab 'Filling' should be active.", mainPage.isFillingTabActive());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


