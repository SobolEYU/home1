package main;

import java.util.List;
import com.google.inject.Inject;
import extensions.BaseExtensions;
import model.LessonsCards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HeaderPage;
import pages.LessonPage;
import pages.LessonsListPage;

@ExtendWith(BaseExtensions.class)
public class MainPageTests  {

    @Inject
    private LessonsListPage lessonsListPage;

    @Inject
    private LessonPage lessonPage;

    @Inject
    private HeaderPage headerPage;

    private static final String LESSONS_URL = "/catalog/courses";
    private static final String LESSON_TO_FIND = "C++ Developer. Basic";


    @Test
    @DisplayName("Сценарий 1")
    public void rightLessonOpenedTest() {
        headerPage.open(LESSONS_URL);
        lessonsListPage.selectLessonByName(LESSON_TO_FIND);
        lessonPage.checkHeaderTitle(LESSON_TO_FIND);
    }

    @Test
    @DisplayName("Сценарий 2")
    public void dateStartLessonsTest() {
        headerPage.open(LESSONS_URL);
        List<LessonsCards> listLessons = lessonsListPage.getSortedLessonsByDate();
        lessonPage.checkFirstAndLastLessons(listLessons);
    }

    @Test
    @DisplayName("Сценарий 3")
    public void selectRandomCategoryTest() {
        headerPage.open();
        String selectedCategory = headerPage.selectRandomLessonCategory();
        lessonsListPage.checkSelectedCategory(selectedCategory);
    }
}
