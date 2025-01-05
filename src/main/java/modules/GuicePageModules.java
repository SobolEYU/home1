package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import pages.HeaderPage;
import pages.LessonPage;
import pages.LessonsListPage;
import pages.MainPage;
import scopeds.GuiceScoped;

public class GuicePageModules extends AbstractModule {

    @Inject
    private GuiceScoped guiceScoped;

    @Singleton
    @Provides
    public MainPage getMainPage() {
        return new MainPage(guiceScoped);
    }

    @Singleton
    @Provides
    public LessonsListPage getLessonsListPage() {
        return new LessonsListPage(guiceScoped);
    }

    @Singleton
    @Provides
    public HeaderPage getHeaderPage() {
        return new HeaderPage(guiceScoped);
    }

    @Singleton
    @Provides
    public LessonPage getLessonPage() {
        return new LessonPage(guiceScoped);
    }
}
