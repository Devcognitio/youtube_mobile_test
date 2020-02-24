package co.com.devco.tasks;

import co.com.devco.models.builders.VideoBuilder;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Find{

    public static Performable the(VideoBuilder videoBuilder) {
        return instrumented(FindThe.class, videoBuilder.build());
    }

    public static Performable theVideo() {
        return instrumented(FindTheVideo.class);
    }
}
