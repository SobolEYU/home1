package factory.options;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeParameters implements IBrowserOptions {

    @Override
    public AbstractDriverOptions browserOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("disable-gpu");
    return options;
    }
}
