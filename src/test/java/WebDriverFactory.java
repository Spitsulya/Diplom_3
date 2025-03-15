import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {
    private static String defaultBrowserName;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("src/main/config.properties");
            properties.load(input);
            defaultBrowserName = properties.getProperty("default.browser", "Chrome"); // Установите значение по умолчанию
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver setBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Yandex")) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files/WebDriver/bin/chromedriver-win64/yandexdriver.exe");
            return new ChromeDriver(options);
        } else {
            throw new RuntimeException("The browser could not be detected.");
        }
    }

    public static WebDriver getDefaultDriver() {
        return setBrowser(defaultBrowserName);
    }
}




