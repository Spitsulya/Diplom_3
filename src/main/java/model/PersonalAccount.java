package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static model.MainPage.getMainTittleCreateBurgerLocator;

public class PersonalAccount {

    private WebDriver driver;

    // Кнопка выход
    private static final By PA_EXIT_BUTTON = By.xpath(".//button[text()='Выход']");

    public PersonalAccount(WebDriver driver) {
        this.driver = driver;
    }

    public static By getPAexitButtonLocator() {
        return PA_EXIT_BUTTON;
    }

    @Step("Click on the exit buttin on the Personal account page")
    public void clickExitButton() {
        driver.findElement(PA_EXIT_BUTTON).click();
    }

    @Step("Checking successfull transition to personal account")
    public boolean isExitDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(PA_EXIT_BUTTON));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если заголовок не появился, возвращаем false
        }
    }
}
