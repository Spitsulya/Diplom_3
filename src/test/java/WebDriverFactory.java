import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {

    public static final String CHROME_BROWSER = "Chrome";
    public static final String YANDEX_BROWSER = "Yandex";

    public static WebDriver setBrowser (String browserName) {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/WebDriver/bin/chromedriver-win64/yandexdriver.exe");

        if (browserName.equals(CHROME_BROWSER)) {
            return new ChromeDriver();
        } else if (browserName.equals(YANDEX_BROWSER)) {
            return new ChromeDriver(options);
        } else {
            throw new RuntimeException("Не удалось определить браузер.");
        }
    }
}










//public class WebDriverFactory {
//
//    public static WebDriver getWebDriver(String browserName) {
//        if (browserName.equals("YANDEX")) {
//            return new FirefoxDriver();
//        } else if (browserName.equals("CHROME")) {
//            return new ChromeDriver();
//        } else {
//            throw new RuntimeException("Нераспознанный браузер " + browserName);
//        }
//    }
//}
