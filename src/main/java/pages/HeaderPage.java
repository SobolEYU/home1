package pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//header который есть на каждой странице
public class HeaderPage extends AbsBasePage<HeaderPage> {

    public HeaderPage(WebDriver webDriver) {
        super(webDriver);
    }

    //вкладка Обучение
    @FindBy(xpath = "//nav//span[@title='Обучение']")
    private WebElement learning;

    public String selectRandomLessonCategory() {
        moveToElement(learning);
        List<WebElement> categories = webDriver.findElements(By.xpath("//nav//a[contains(@href,'categories')]"));
        WebElement selectedCategory = categories.get(new Random().nextInt(0, categories.size()));
        System.out.println("Выбрана категория: " + selectedCategory.getText());
        String selectedCategoryName = selectedCategory.getText().substring(0, selectedCategory.getText().indexOf(" ("));
        moveToElement(selectedCategory).click();
        return selectedCategoryName;
    }
}
