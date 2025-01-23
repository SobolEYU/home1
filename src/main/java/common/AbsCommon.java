package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

public abstract class AbsCommon<T> {

    protected WebDriver webDriver;
    protected Waiters waiters;

    public AbsCommon(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waiters = new Waiters(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
