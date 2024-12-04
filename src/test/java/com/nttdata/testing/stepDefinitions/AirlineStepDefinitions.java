package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.DeleteAirline;
import com.nttdata.testing.tasks.GetAirlines;
import com.nttdata.testing.tasks.PostAirline;
import com.nttdata.testing.tasks.PutAirline;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class AirlineStepDefinitions {
    public static Logger LOGGER = LoggerFactory.getLogger(AirlineStepDefinitions.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint para obtener las aerolineas")
    public void elActorEstableceElEndpointParaObtenerLasAerolineas(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el {actor} envia una solicitud GET")
    public void elActorEnviaUnaSolicitudGET(Actor actor) {
        actor.attemptsTo(GetAirlines.fromEndpoint("/airlines"));
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));
    }

    @Given("el {actor} establece el endpoint POST para crear una aerolinea")
    public void elActorEstableceElEndpointPOSTParaCrearUnaAerolinea(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el envia una solicitud HTTP POST con el {string} {string} {string} {string} {string} {string} {string} {string}")
    public void elEnviaUnaSolicitudHTTPPOSTConEl(String _id, String name, String country, String logo, String slogan, String head_quarters, String website, String established) {
        theActorInTheSpotlight().attemptsTo(PostAirline.fromPage(_id, name, country, logo, slogan, head_quarters, website, established));
    }

    @Given("el {actor} establece el endpoint PUT para actualizar una aerolinea")
    public void elActorEstableceElEndpointPUTParaActualizarUnaAerolinea(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el envia una solicitud HTTP PUT con el {string} {string} {string} {string} {string} {string} {string} {string}")
    public void elActorEnviaUnaSolicitudHTTPPUT(String _id, String name, String country, String logo, String slogan, String head_quarters, String website, String established) {
        theActorInTheSpotlight().attemptsTo(PutAirline.withDetails(_id, name, country, logo, slogan, head_quarters, website, established));
    }

    @Given("el {actor} establece el endpoint DELETE para eliminar una aerolinea")
    public void elActorEstableceElEndpointDELETEParaEliminarUnaAerolinea(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el envia una solicitud HTTP DELETE con el {string}")
    public void elActorEnviaUnaSolicitudHTTPDELETE(String _id) {
        theActorInTheSpotlight().attemptsTo(DeleteAirline.byId(_id));
    }


}