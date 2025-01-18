package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import model.LessonsCards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//страница с курсами
public class LessonsListPage extends AbsBasePage<LessonsListPage> {

    public LessonsListPage(WebDriver webDriver) {
        super(webDriver);
    }

    private LessonPage lessonPage = new LessonPage(webDriver);

    //список курсов
    @FindBy(xpath = "//section//a[contains(@href,'lessons') and .//p]")
    private List<WebElement> lessons;

    //фильтр по списку категорий
    @FindBy(xpath = "//section/div[.//p[text()='Направление']]//div[@class='ReactCollapse--content']/div/div")
    private List<WebElement> categoriesInFilter;

    //ищем и переходим в курс по его имени
    public void selectLessonByName(String name) {
        List<WebElement> lessonsByName = lessons.stream().filter(it -> it.getText().contains(name)).toList();
        lessonsByName.get(0).click();
    }

    public List<LessonsCards> getSortedLessonsByDate() {
        List<LessonsCards> expectedLessonsCards = lessons.stream().map(it -> {
            String name = it.findElements(By.xpath(".//div[text() != '']")).get(0).getText();
            String date = it.findElements(By.xpath(".//div[text() != '']")).get(1).getText();
            return new LessonsCards(name, date, it.getDomAttribute("href"));
        }).toList();
        LocalDate min = expectedLessonsCards.stream().map(LessonsCards::getDate).reduce((it1, it2) -> it1.isBefore(it2) ? it1 : it2).orElse(null);
        LocalDate max = expectedLessonsCards.stream().map(LessonsCards::getDate).reduce((it1, it2) -> it1.isBefore(it2) ? it2 : it1).orElse(null);
        expectedLessonsCards = expectedLessonsCards.stream()
                .filter(it -> it.getDate().equals(min) || it.getDate().equals(max))
                .toList();
        return expectedLessonsCards;
    }

    public void checkSelectedCategory(String selectedCategory) {
        List<WebElement> checkedCategories = categoriesInFilter.stream().filter(it -> it.getDomAttribute("value").equals("true")).toList();
        assertThat(checkedCategories.size())
                .as("Выбрана 1 категория")
                .isEqualTo(1);
        assertThat(checkedCategories.get(0).getText())
                .as(String.format("Выбранная категория не соответствует той, на которую кликали"))
                .isEqualTo(selectedCategory);
    }
}
