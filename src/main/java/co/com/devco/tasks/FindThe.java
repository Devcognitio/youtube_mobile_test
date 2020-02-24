package co.com.devco.tasks;

import co.com.devco.models.Video;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.userinterface.pages.YoutubeHomePage.FIELD_SEARCH;
import static co.com.devco.userinterface.pages.YoutubeHomePage.ITEM_FIRST_VIDEO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FindThe implements Task {
    private Video video;

    public FindThe(Video video) {
        this.video = video;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(video.getSongName()).into(FIELD_SEARCH),
                WaitUntil.the(ITEM_FIRST_VIDEO, isVisible()),
                Click.on(ITEM_FIRST_VIDEO)
        );
    }
}
