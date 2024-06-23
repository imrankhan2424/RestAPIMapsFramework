package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.APIResources;
import resources.PayLoad;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefs extends Utils {
    RequestSpecification res;
    Response response;

    @Given("Add Place Payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        res=given().spec(Requestspecification()).body(PayLoad.AddPlacePayload(name,language,address));
    }

    @When("user call {string} api using {string} http request")
    public void userCallApiUsingHttpRequest(String resource, String requestType) {
        APIResources apiResources=APIResources.valueOf(resource);
        System.out.println(apiResources.getPath());
        if(requestType.equalsIgnoreCase("POST"))
            response=res.when().post(apiResources.getPath()).then().extract().response();
        else
            response=res.when().get(apiResources.getPath()).then().extract().response();
    }

    @Then("verify response api status code is {int}")
    public void verifyResponseApiStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.getStatusCode(),statusCode);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String expectedResponseValue) {
        Assert.assertEquals(getJsonValue(response,key),expectedResponseValue);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String arg0, String arg1) {
    }


}