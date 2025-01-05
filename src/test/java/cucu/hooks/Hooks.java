package cucu.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import scopeds.GuiceScoped;

public class Hooks {

    @Inject
    private GuiceScoped guiceScoped;

    @After
    public void closeDriver() {
        WebDriver webDriver = guiceScoped.getWebDriver();

        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
