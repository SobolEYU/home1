package factory;

import java.net.MalformedURLException;
import java.net.URL;
import exceptions.BrowserNotFoundException;
import factory.options.ChromeParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private String browserName = System.getProperty("browser");
    private URL selenoidUrl;

    public WebDriverFactory() {
        try {
            selenoidUrl = new URL(System.getProperty("selenoid.url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver create() {
        switch (browserName.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = (ChromeOptions) new ChromeParameters().browserOptions();
                return new RemoteWebDriver(selenoidUrl, options);
                //return new ChromeDriver();
            default:
                throw new BrowserNotFoundException();
        }
    }
}
