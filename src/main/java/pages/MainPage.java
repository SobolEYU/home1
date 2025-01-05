package pages;

import com.google.inject.Inject;
import scopeds.GuiceScoped;

//главная страница
public class MainPage extends AbsBasePage<MainPage> {

    @Inject
    public MainPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }


}