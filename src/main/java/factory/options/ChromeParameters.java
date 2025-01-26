package factory.options;

import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeParameters implements IBrowserOptions {

    private final String onMobile = System.getProperty("mobile");

    @Override
    public AbstractDriverOptions browserOptions() {
        ChromeOptions options = new ChromeOptions();
        if (onMobile.equals("Y")) {
            options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 14 Pro Max"));
        }
        options.addArguments("no-sandbox");
        options.addArguments("disable-gpu");
        options.setCapability("browserName", "chrome");
    return options;
    }
}
