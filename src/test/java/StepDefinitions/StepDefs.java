package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import resources.PayLoad;

import static io.restassured.RestAssured.given;

public class StepDefs {
    RequestSpecification res;

    @Given("Add Place Payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) {
        RequestSpecification req=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON)
                .addQueryParam("key","qaclick123")
                .build();
        res=given().spec(req).body(PayLoad.AddPlacePayload(name,language,address));
    }

    @When("user call {string} api using {string} http request")
    public void userCallApiUsingHttpRequest(String resource, String requestType) {

    }

    @Then("verify response api status code is {int}")
    public void verifyResponseApiStatusCodeIs(int statusCode) {
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String actualResponseValue, String expectedResponseValue) {
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String arg0, String arg1) {
    }


}