import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import model.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class ConstructorSectionsTest {

    private WebDriver driver;
    private static final String DEFAULT_BROWSER_NAME = "Chrome";
    private static final String BROWSER_YANDEX = "Yandex";

    private MainPage mainPage;


    @Before
    public void setUp() {

        driver = WebDriverFactory.setBrowser(DEFAULT_BROWSER_NAME);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        mainPage.openStellarBurgersURL();

    }

    @Test
    @DisplayName("Successful transition to Constructor sections {bun}")
    @Description("A test that allows to check the correct moving between tabs.")
    public void testConstructorSectionBunTransition() {

        // Перейти на соседнюю вкладу Соусы для старта
        mainPage.clickConstructorSouse();
        // Получаем начальные координаты заголовка списка с булками
        Rectangle firstRect = mainPage.getConstructorBunHeaderWebElement().getRect();
        int startCoordinateY = firstRect.getY();
        System.out.println("Y coordinate: " + startCoordinateY);

        // Кликаем по вкладке Булки
        mainPage.clickConstructorBun();

        // Получаем новые координаты заголовка списка с булками
        Rectangle secondRect = mainPage.getConstructorBunHeaderWebElement().getRect();
        int newCoordinateY = secondRect.getY();
        System.out.println("Y coordinate: " + newCoordinateY);

        // Проверяем, что произошло смещение элемента вверх
        assertTrue("The tittle of the Buns has not moved up.", newCoordinateY < startCoordinateY);
    }

    @Test
    @DisplayName("Successful transition to Constructor sections {souse}")
    @Description("A test that allows to check the correct moving between tabs.")
    public void testConstructorSectionSouseTransition() {

        // Получаем начальные координаты заголовка списка с соусами
        Rectangle firstRect = driver.findElement(MainPage.getConstructorSouseHeaderLocator()).getRect();
        int startCoordinateY = firstRect.getY();
        System.out.println("Y coordinate: " + startCoordinateY);

        // Кликаем по вкладке соусов
        mainPage.clickConstructorSouse();

        // Получаем новые координаты заголовка списка с соусами
        Rectangle secondRect = driver.findElement(MainPage.getConstructorSouseHeaderLocator()).getRect();
        int newCoordinateY = secondRect.getY();
        System.out.println("Y coordinate: " + newCoordinateY);

        // Проверяем, что произошло смещение элемента вверх
        assertTrue("The tittle of the Souses has not moved up.", newCoordinateY < startCoordinateY);
    }

    @Test
    @DisplayName("Successful transition to Constructor sections {filling}")
    @Description("A test that allows to check the correct moving between tabs.")
    public void testConstructorSectionFillingTransition() {

        // Получаем начальные координаты заголовка списка с соусами
        Rectangle firstRect = driver.findElement(MainPage.getConstructorFillingHeaderLocator()).getRect();
        int startCoordinateY = firstRect.getY();
        System.out.println("Y coordinate: " + startCoordinateY);

        // Кликаем по вкладке соусов
        mainPage.clickLConstructorFilling();

        // Получаем новые координаты заголовка списка с соусами
        Rectangle secondRect = driver.findElement(MainPage.getConstructorFillingHeaderLocator()).getRect();
        int newCoordinateY = secondRect.getY();
        System.out.println("New Y coordinate: " + newCoordinateY);

        // Проверяем, что произошло смещение элемента вверх
        assertTrue("The tittle of the Fillings has not moved up.", newCoordinateY < startCoordinateY);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}