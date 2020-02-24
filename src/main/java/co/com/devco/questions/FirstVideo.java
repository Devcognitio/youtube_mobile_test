package co.com.devco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.devco.userinterface.pages.ListedVideosPage.CARD_VIDEO;

public class FirstVideo implements Question<Boolean> {
    private String nameBand;

    public FirstVideo(String nameBand){
        this.nameBand = nameBand;
    }

    public static FirstVideo listedBelongsTo(String nameBand){
        return new FirstVideo(nameBand);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CARD_VIDEO.of(nameBand).resolveFor(actor).isVisible();
    }
}
