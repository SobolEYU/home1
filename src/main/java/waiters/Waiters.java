package waiters;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    private WebDriver webDriver;

    public Waiters(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected boolean waiter(Long seconds, ExpectedCondition condition) {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(condition);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitElementIsVisible(WebElement element) {
        return waiter(10L, ExpectedConditions.visibilityOf(element));
    }

    public boolean waitVisibleElementToBeClickable(WebElement element) {
        waiter(10L, ExpectedConditions.visibilityOf(element));
        return waiter(5L, ExpectedConditions.elementToBeClickable(element));
    }
}
