package pages;

import java.util.List;
import java.util.Random;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import scopeds.GuiceScoped;

//header который есть на каждой странице
public class HeaderPage extends AbsBasePage<HeaderPage> {

    @Inject
    public HeaderPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    //вкладка Обучение
    @FindBy(xpath = "//nav//span[@title='Обучение']")
    private WebElement learning;

    public String selectRandomLessonCategory() {
        moveToElement(learning);
        List<WebElement> categories = webDriver.findElements(By.xpath("//nav//a[contains(@href,'categories')]"));
        WebElement selectedCategory = categories.get(new Random().nextInt(0, categories.size()));
        String selectedCategoryName = selectedCategory.getText().substring(0, selectedCategory.getText().indexOf(" ("));
        selectedCategory.click();
        return selectedCategoryName;
    }
}