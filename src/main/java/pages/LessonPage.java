package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.google.inject.Inject;
import model.LessonsCards;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import scopeds.GuiceScoped;

//страница с курсами
public class LessonPage extends AbsBasePage<LessonPage> {

    @Inject
    public LessonPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    //заголовок с названием курса
    @FindBy(tagName = "h1")
    private WebElement header;

    //текст с указанием даты старта занятий
    @FindBy(xpath = "//div[contains(text(),'Старт занятий')]")
    private WebElement dateStart;

    public LessonsCards getLessonInfo() {
        LocalDate dateFrom;
        String dateFromText = dateStart.getText().replace("Старт занятий ", "");
        String nameLesson = header.getText();
        int countSpaces = dateFromText.length() - dateFromText.replace(" ", "").length();
        if (countSpaces == 1) {
            dateFrom = LocalDate.parse(dateFromText + " " + LocalDate.now().getYear(), DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru")));
        } else {
            dateFrom = LocalDate.parse(dateFromText, DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru")));
        }
        return new LessonsCards(nameLesson, dateFromText, dateFrom);
    }

    public void checkHeaderTitle(String title) {
        String expected = header.getText();
        assertThat(expected)
                .as(String.format("Название курса %s не совпадает с %s", title, expected))
                .isEqualTo(title);
    }

    public void checkFirstAndLastLessons(List<LessonsCards> expectedLessonsCards) {
        ArrayList<LessonsCards> actualLessons = new ArrayList<>();
        for (LessonsCards lesson: expectedLessonsCards) {
            open(lesson.getUrl());
            actualLessons.add(getLessonInfo());
        }
        assertThat(actualLessons.equals(expectedLessonsCards))
                .as("Даты/название у курса не совпадают на странице и в списке")
                .isTrue();
    }
}
