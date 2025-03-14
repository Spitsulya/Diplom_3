package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {

    private WebDriver driver;

    // URL главной страницы
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    // Личный кабинет
    private static final By MAIN_ACCOUNT_BUTTON = By.xpath(".//*[text()='Личный Кабинет']");
    // Войти в аккаунт
    private static final By MAIN_LOGIN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    // Заголовок Соберите бургер
    private static final By MAIN_TITTLE_CREATE_BURGER = By.xpath(".//*[text()='Соберите бургер']");
    // Конструктор
    private static final By MAIN_CONSTRUCTOR_BUTTON = By.xpath(".//*[text()='Конструктор']");
    // Логотип
    private static final By LOGO_BUTTON = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    // Раздел Булки
    private static final By CONSTRUCTOR_BUN = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//span[contains(text(), 'Булки')]");
    // Раздел Соусы
    private static final By CONSTRUCTOR_SOUSE = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//span[contains(text(), 'Соусы')]");
    // Раздел Начинки
    private static final By CONSTRUCTOR_FILLING = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//span[contains(text(), 'Начинки')]");
    // Заголовок раздела Булки
    private static final By CONSTRUCTOR_BUN_HEADER = By.xpath(".//h2[contains(@class, 'text_type_main-medium') and contains (text(), 'Булки')]");
    // Заголовок раздела Соусы
    private static final By CONSTRUCTOR_SOUSE_HEADER = By.xpath(".//h2[contains(@class, 'text_type_main-medium') and contains (text(), 'Соусы')]");
    // Заголовок раздела Начинки
    private static final By CONSTRUCTOR_FILLING_HEADER = By.xpath(".//h2[contains(@class, 'text_type_main-medium') and contains (text(), 'Начинки')]");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }



    @Step("Open Stellar Burgers main URL")
    public  void openStellarBurgersURL() {
        driver.get(PAGE_URL);
    }

    @Step("Click on the Personal Account button on the main form")
    public void clickAccountButton() {
        driver.findElement(MAIN_ACCOUNT_BUTTON).click();
    }

    @Step("Click on the Login button")
    public void clickLoginButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Click on the Constructor on the main form")
    public void clickConstructorButton() {
        driver.findElement(MAIN_CONSTRUCTOR_BUTTON).click();
        waitForElementToBeVisible(CONSTRUCTOR_BUN_HEADER);
    }

    @Step("Click on the LOGO on the main form")
    public void clickLogoButton() {
        driver.findElement(MAIN_CONSTRUCTOR_BUTTON).click();
    }

    @Step("Click on the BUN on the Constructor form")
    public void clickConstructorBun() {
        driver.findElement(CONSTRUCTOR_BUN).click();
        waitForElementToBeVisible(CONSTRUCTOR_BUN_HEADER);
    }
    @Step("Click on the SOUSE on the Constructor form")
    public void clickConstructorSouse() {
        driver.findElement(CONSTRUCTOR_SOUSE).click();
        waitForElementToBeVisible(CONSTRUCTOR_SOUSE_HEADER);
    }
    @Step("Click on the FILLING on the Constructor form")
    public void clickLConstructorFilling() {
        driver.findElement(CONSTRUCTOR_FILLING).click();
        waitForElementToBeVisible(CONSTRUCTOR_FILLING_HEADER);
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Checking successfully transition to the Constructor")
    public boolean isTitleDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(getMainTittleCreateBurgerLocator()));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если заголовок не появился, возвращаем false
        }
    }

    public static String getPageUrl() {
        return PAGE_URL;
    }

    public static By getMainAccountButtonLocator() {
        return MAIN_ACCOUNT_BUTTON;
    }

    public static By getMainLoginButtonLocator() {
        return MAIN_LOGIN_BUTTON;
    }

    public static By getMainTittleCreateBurgerLocator() {
        return MAIN_TITTLE_CREATE_BURGER;
    }

    public static By getConstructorBunLocator() {
        return CONSTRUCTOR_BUN;
    }

    public static By getConstructorSouseLocator() {
        return CONSTRUCTOR_SOUSE;
    }

    public static By getConstructorFillingLocator() {
        return CONSTRUCTOR_FILLING;
    }

    public WebElement getConstructorBunHeaderWebElement() {
        return driver.findElement(CONSTRUCTOR_BUN_HEADER);
    }

    public static By getConstructorSouseHeaderLocator() {
        return CONSTRUCTOR_SOUSE_HEADER;
    }

    public static By getConstructorFillingHeaderLocator() {
        return CONSTRUCTOR_FILLING_HEADER;
    }


}
