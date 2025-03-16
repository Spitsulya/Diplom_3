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
    // Раздел Булки активный
    private static final By CONSTRUCTOR_BUN_ACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and .//span[text()='Булки']]");
    // Раздел Булки не активный
    private static final By CONSTRUCTOR_BUN_INACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and not(contains(@class, 'tab_tab_type_current__2BEPc'))]//span[text()='Булки']");
    // Раздел Соусы активный
    private static final By CONSTRUCTOR_SOUSE_ACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and .//span[text()='Соусы']]");
    // Раздел Соусы не активный
    private static final By CONSTRUCTOR_SOUSE_INACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and not(contains(@class, 'tab_tab_type_current__2BEPc'))]//span[text()='Соусы']");   // Раздел Булки не активный
    // Раздел Начинки активный
    private static final By CONSTRUCTOR_FILLING_ACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and .//span[text()='Начинки']]");
    // Раздел Начинки не активный
    private static final By CONSTRUCTOR_FILLING_INACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and not(contains(@class, 'tab_tab_type_current__2BEPc'))]//span[text()='Начинки']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    @Step("Open Stellar Burgers main URL")
    public void openStellarBurgersMainURL() {
        driver.get(PAGE_URL);
    }

    @Step("Click on the Personal Account button on the main form")
    public void clickAccountButton() {
        driver.findElement(MAIN_ACCOUNT_BUTTON).click();
    }

    @Step("Click on the Login button")
    public void clickLoginButton() {
        driver.findElement(MAIN_LOGIN_BUTTON).click();
    }

    @Step("Click on the Constructor on the main form")
    public void clickConstructorButton() {
        driver.findElement(MAIN_CONSTRUCTOR_BUTTON).click();
        waitForElementToBeVisible(CONSTRUCTOR_BUN_ACTIVE_TAB);
    }

    @Step("Click on the LOGO on the main form")
    public void clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Click on the BUN on the Constructor form")
    public void clickBunTab() {
        driver.findElement(CONSTRUCTOR_BUN_INACTIVE_TAB).click();
    }

    @Step("Click on the SOUSE on the Constructor form")
    public void clickSouseTab() {
        driver.findElement(CONSTRUCTOR_SOUSE_INACTIVE_TAB).click();
    }

    @Step("Click on the FILLING on the Constructor form")
    public void clickFillingTab() {
        driver.findElement(CONSTRUCTOR_FILLING_INACTIVE_TAB).click();
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Checking successfully transition to the Constructor")
    public boolean isTitleDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getMainTittleCreateBurgerLocator()));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если заголовок не появился, возвращаем false
        }
    }

    public static By getMainTittleCreateBurgerLocator() {
        return MAIN_TITTLE_CREATE_BURGER;
    }

    @Step("Checking successful move to 'Bun' tab")
    public boolean isBunTabActive() {
        return driver.findElements(CONSTRUCTOR_BUN_ACTIVE_TAB).size() > 0;
    }

    @Step("Checking successful move to 'Souse' tab")
    public boolean isSauceTabActive() {
        return driver.findElements(CONSTRUCTOR_SOUSE_ACTIVE_TAB).size() > 0;
    }

    @Step("Checking successful move to 'Filling' tab")
    public boolean isFillingTabActive() {
        return driver.findElements(CONSTRUCTOR_FILLING_ACTIVE_TAB).size() > 0;
    }

}
