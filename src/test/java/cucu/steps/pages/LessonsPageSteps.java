package cucu.steps.pages;

import java.util.List;
import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import model.LessonsCards;
import pages.LessonPage;
import pages.LessonsListPage;

public class LessonsPageSteps {

    private static List<LessonsCards> listLessons;

    @Inject
    public LessonPage lessonPage;

    @Inject
    public LessonsListPage lessonsListPage;

    @Пусть("Открываем курс: {string}")
    public void selectLessonByName(String name) {
        lessonsListPage.selectLessonByName(name);
    }

    @Тогда("Название курса на его странице = {string}")
    public void checkHeaderTitle(String name) {
        lessonPage.checkHeaderTitle(name);
    }

    @Пусть("Получаем список курсов с самым ранним и самым поздник")
    public void getSortedLessonsByDate() {
        listLessons = lessonsListPage.getSortedLessonsByDate();
    }

    @Тогда("Проверяем даты и названия полученных курсов")
    public void checkFirstAndLastLessons() {
        lessonPage.checkFirstAndLastLessons(listLessons);
    }

    @Тогда("Проверяем, что отображаются курсы выбранной категории")
    public void checkSelectedCategory() {
        lessonsListPage.checkSelectedCategory(HeaderPageSteps.selectedCategory);
    }
}
