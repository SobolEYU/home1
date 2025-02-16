package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuicePageModules;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class BaseExtensions implements BeforeEachCallback, AfterEachCallback {

    private Injector injector;

    @Override
    public void beforeEach(ExtensionContext context) {
        context.getTestInstance()
                .ifPresent(instance -> {
                    injector = Guice.createInjector(new GuicePageModules());
                    injector.injectMembers(instance);
                });
    }

    @Override
    public void afterEach(ExtensionContext context) {
        WebDriver driver = injector.getProvider(WebDriver.class).get();
        if (driver != null) {
            driver.quit();
        }
    }
}