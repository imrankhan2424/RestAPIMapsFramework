package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StepDefs {
    @Given("AddPlace Payload is available")
    public void add_place_payload_is_available() {
        RequestSpecification res=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
                .addQueryParam("key","qaclick123").build();
//        given().spec(res).when().post("");
    }
    @When("user call {string} api using {string} http request")
    public void userCallApiUsingHttpRequest(String arg0, String arg1) {
    }

    @Then("verify response api status code is {int}")
    public void verifyResponseApiStatusCodeIs(int arg0) {
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String arg0, String arg1) {
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String arg0, String arg1) {
    }
}