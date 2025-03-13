package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
