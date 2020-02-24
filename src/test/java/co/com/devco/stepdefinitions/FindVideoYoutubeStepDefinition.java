package co.com.devco.stepdefinitions;

import co.com.devco.exceptions.VideoDoesNotBelongToTheBandException;
import co.com.devco.interactions.Select;
import co.com.devco.questions.FirstVideo;
import co.com.devco.questions.TheVideo;
import co.com.devco.tasks.Find;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static co.com.devco.exceptions.VideoDoesNotBelongToTheBandException.OTHER_VIDEO_LISTED_MESSAGE;
import static co.com.devco.models.builders.VideoBuilder.video;
import static co.com.devco.tasks.comunes.Cargar.cargoLosDatosDeLaTransaccionConLaSiguiente;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FindVideoYoutubeStepDefinition {

    @Given("^that (.*) wants to search a Video$")
    public void thatJuanWantsSearchVideo(String nameActor) {
        theActorCalled(nameActor).attemptsTo(
                Select.buttonFinder()
        );
    }

    @Given("^that el actor wants to see a Video$")
    public void thatJuanWantsSeeVideo(List<Map<String, Object>> informacion) {
        theActorCalled("Juan").attemptsTo(
                cargoLosDatosDeLaTransaccionConLaSiguiente(informacion),
                Select.buttonFinder()
        );
    }

    @When("^He searchs (.*)$")
    public void heSearchsVideo(String songName) {
        theActorInTheSpotlight().attemptsTo(
                Find.the(video().
                        withSongName(songName)
                )
        );
    }

    @When("^He write the name of the video$")
    public void heSearchsTheVideo() {
        theActorInTheSpotlight().attemptsTo(
                Find.theVideo()
        );
    }

    @Then("^He should see that the first video belongs to (.*) Band$")
    public void heShouldSeeTheFirstVideoBelongsTo(String nameband) {
        theActorInTheSpotlight().should(seeThat(
                FirstVideo.listedBelongsTo(nameband)).orComplainWith(
                VideoDoesNotBelongToTheBandException.class, OTHER_VIDEO_LISTED_MESSAGE
                )
        );
    }

    @Then("^He should see that the video belongs to correct Band$")
    public void heShouldSeeTheFirstVideoBelongsToCorrect() {
        theActorInTheSpotlight().should(seeThat(
                TheVideo.listedBelongsToTheCorrectBand()).orComplainWith(
                VideoDoesNotBelongToTheBandException.class, OTHER_VIDEO_LISTED_MESSAGE
                )
        );
    }
}
