package common;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import scopeds.GuiceScoped;
import waiters.Waiters;

public abstract class AbsCommon<T> {

    protected WebDriver webDriver;
    protected Waiters waiters;

    @Inject
    public AbsCommon(GuiceScoped guiceScoped) {
        this.webDriver = guiceScoped.getWebDriver();
        this.waiters = new Waiters(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
