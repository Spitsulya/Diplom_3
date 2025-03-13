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


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Stellar Burgers URL")
    public  void openStellarBurgersURL() {
        driver.get(PAGE_URL);
    }

    @Step("Click on the Personal Account button on the main form")
    public void clickAccountButton() {
        driver.findElement(MAIN_ACCOUNT_BUTTON).click();
    }

    @Step("Click on the Login button on the main form")
    public void clickLoginButton() {
        driver.findElement(MAIN_LOGIN_BUTTON).click();
    }

    @Step("Click on the Constructor on the main form")
    public void clickConstructorButton() {
        driver.findElement(MAIN_CONSTRUCTOR_BUTTON).click();
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

    // ГЕТТЕРЫ
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


}
