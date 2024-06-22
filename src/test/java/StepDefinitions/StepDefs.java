package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
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