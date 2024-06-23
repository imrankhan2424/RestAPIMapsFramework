package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.PayLoad;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefs extends Utils {
    RequestSpecification res;
    Response response;
    static String place_id;

    @Given("Add Place Payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        res=given().spec(Requestspecification()).body(PayLoad.AddPlacePayload(name,language,address));
    }

    @When("user call {string} api using {string} http request")
    public void userCallApiUsingHttpRequest(String resource, String requestType) {
        if(requestType.equalsIgnoreCase("POST"))
            response=res.when().post(getAPIResource(resource)).then().extract().response();
        else
            response=res.when().get(getAPIResource(resource)).then().extract().response();
    }

    @Then("verify response api status code is {int}")
    public void verifyResponseApiStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.getStatusCode(),statusCode);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String expectedResponseValue) {
        Assert.assertEquals(getJsonValue(response,key),expectedResponseValue);
    }

    @Then("verify {string} created maps to {string} using {string}")
    public void verifyCreatedMapsToUsing(String jsonNode, String expectedName, String resource) throws IOException {
        place_id=getJsonValue(response,jsonNode);
        res=given().spec(Requestspecification()).
                queryParam(jsonNode,place_id);
        userCallApiUsingHttpRequest(resource,"GET");
        Assert.assertEquals(getJsonValue(response,"name"),expectedName);
    }

    @Given("Delete Place Payload")
    public void deletePlacePayload() throws IOException {
        res=given().spec(Requestspecification()).body(PayLoad.DeletePayload(place_id));
    }
}