package co.com.devco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.devco.models.DatosPrueba.obtener;
import static co.com.devco.userinterface.pages.ListedVideosPage.CARD_VIDEO;

public class TheVideo implements Question<Boolean> {

    public static TheVideo listedBelongsToTheCorrectBand(){
        return new TheVideo();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CARD_VIDEO.of(obtener("nameBand")).resolveFor(actor).isVisible();
    }
}
