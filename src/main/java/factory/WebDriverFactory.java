package factory;

import exceptions.BrowserNotFoundException;
import factory.options.ChromeParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private String browserName = System.getProperty("browser");

    public WebDriver create() {
        switch (browserName.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = (ChromeOptions) new ChromeParameters().browserOptions();
                System.out.println("Start chrome");
                return new ChromeDriver();
            default:
                throw new BrowserNotFoundException();
        }
    }
}
