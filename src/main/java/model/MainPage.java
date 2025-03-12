package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    // Личный кабинет
    private static final By accountButton = By.xpath(".//*[text()='Личный Кабинет']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void openStellarBurgersURL() {
        driver.get(PAGE_URL);
    }

    @Step("Click on the Personal Account button on the main form")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
}
