package cucu.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import pages.HeaderPage;

public class HeaderPageSteps {

    public static String selectedCategory;

    @Inject
    public HeaderPage headerPage;

    @Пусть("Переходим на случайную категорию курсов")
    public void selectRandomLessonCategory() {
        selectedCategory = headerPage.selectRandomLessonCategory();
    }

}
