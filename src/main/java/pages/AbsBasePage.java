package pages;

import common.AbsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

abstract public class AbsBasePage<T> extends AbsCommon<T> {

    private static final String BASE_URL = System.getProperty("base.url");
    private static Boolean cookiePopupClosed = false;

    public AbsBasePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".__jivoDesktopButton")
    private WebElement chatBot;

    @FindBy(xpath = "//button[@font-style='bold']")
    private WebElement cookiePopup;

    public T open(String url) {
        webDriver.get(BASE_URL + url);
        if (!cookiePopupClosed) {
            waiters.waitVisibleElementToBeClickable(cookiePopup);
            cookiePopup.click();
            cookiePopupClosed = true;
        }
        return (T) this;
    }

    public T open() {
        webDriver.get(BASE_URL);
        waiters.waitElementIsVisible(chatBot);
        cookiePopup.click();
        return (T) this;
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).perform();
    }
}
