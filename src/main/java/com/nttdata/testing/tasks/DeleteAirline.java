package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteAirline implements Task {
    private final String _id;

    public DeleteAirline(String _id) {
        this._id = _id;
    }

    public static Performable byId(String _id) {
        return instrumented(DeleteAirline.class, _id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/airlines/" + _id).with(requestSpecification -> requestSpecification.log().all())
        );
    }
}
