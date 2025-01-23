package extensions;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuicePageModules;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class BaseExtensions implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Injector injector = Guice.createInjector(new GuicePageModules());
        context.getStore(GLOBAL).put(context.getTestInstance(), injector);
        context.getTestInstance().ifPresent(injector::injectMembers);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        Injector injector = context.getStore(GLOBAL).get(context.getTestInstance(), Injector.class);
        WebDriver driver = injector.getProvider(WebDriver.class).get();
        if (driver != null) {
            driver.quit();
        }
    }
}