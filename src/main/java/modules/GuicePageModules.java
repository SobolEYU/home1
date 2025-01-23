package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.LessonPage;
import pages.LessonsListPage;
import pages.MainPage;

public class GuicePageModules extends AbstractModule {

    private WebDriver webDriver;

    @Provides
    private WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = createWebDriver();
        }
        return webDriver;
    }

    private WebDriver createWebDriver() {
        WebDriver driver = new WebDriverFactory().create();
        driver.manage().window().maximize();
        return driver;
    }

    @Singleton
    @Provides
    public MainPage getMainPage() {
        return new MainPage(getDriver());
    }

    @Singleton
    @Provides
    public LessonsListPage getLessonsListPage() {
        return new LessonsListPage(getDriver());
    }

    @Singleton
    @Provides
    public HeaderPage getHeaderPage() {
        return new HeaderPage(getDriver());
    }

    @Singleton
    @Provides
    public LessonPage getLessonPage() {
        return new LessonPage(getDriver());
    }
}
