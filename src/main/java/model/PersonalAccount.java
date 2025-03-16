package model;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class PersonalAccount {

    private WebDriver driver;

    // Кнопка Выход
    private static final By PA_EXIT_BUTTON = By.xpath(".//ul//button[text()='Выход']");

    public PersonalAccount(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the exit button on the 'personal account' page")
    public void clickExitButton() {
        driver.findElement(PA_EXIT_BUTTON).click();
    }

    @Step("Checking successfully transition to 'personal account'")
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
