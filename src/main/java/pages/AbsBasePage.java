package pages;

import com.google.inject.Inject;
import common.AbsCommon;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import scopeds.GuiceScoped;

public class AbsBasePage<T> extends AbsCommon<T> {

    private static final String BASE_URL = "https://otus.ru";

    @Inject
    public AbsBasePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @FindBy(css = ".__jivoDesktopButton")
    private WebElement chatBot;

    public T open(String url) {
        webDriver.get(BASE_URL + url);
        return (T) this;
    }

    public T open() {
        webDriver.get(BASE_URL);
        waiters.waitElementIsVisible(chatBot);
        return (T) this;
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).perform();
    }
}
