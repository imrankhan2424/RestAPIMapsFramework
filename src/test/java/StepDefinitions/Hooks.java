package StepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void Prerequisite() throws IOException {
        System.out.println("Inside Hooks");
        StepDefs stepDefs=new StepDefs();
        stepDefs.addPlacePayloadWith("Sahil","Hindi","Jamshedpur");
        stepDefs.userCallApiUsingHttpRequest("AddplaceAPI","POST");
        stepDefs.verifyCreatedMapsToUsing("place_id","Sahil","GetplaceAPI");
    }
}
