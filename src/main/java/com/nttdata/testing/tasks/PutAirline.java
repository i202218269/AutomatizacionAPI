package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutAirline implements Task {
    private final String _id, name, country, logo, slogan, head_quaters, website, established;

    public PutAirline(String _id, String name, String country, String logo, String slogan, String head_quaters, String website, String established) {
        this._id = _id;
        this.name = name;
        this.country = country;
        this.logo = logo;
        this.slogan = slogan;
        this.head_quaters = head_quaters;
        this.website = website;
        this.established = established;
    }

    public static Performable withDetails(String _id, String name, String country, String logo, String slogan, String head_quaters, String website, String established) {
        return instrumented(PutAirline.class, _id, name, country, logo, slogan, head_quaters, website, established);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/airlines/" + _id)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body("{\"_id\":\"" + _id + "\",\"name\":\"" + name + "\",\"country\":\"" + country + "\",\"logo\":\"" + logo + "\",\"slogan\":\"" + slogan + "\",\"head_quaters\":\"" + head_quaters + "\",\"website\":\"" + website + "\",\"established\":\"" + established + "\"}")
                                .log().all())
        );
    }
}
