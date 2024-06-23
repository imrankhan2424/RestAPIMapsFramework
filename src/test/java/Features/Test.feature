Feature: Validation of Rest Maps API

  Scenario: Validation of Add Place Api

    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user call "" api using "POST" http request
    Then verify response api status code is 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then verify place_Id created maps to "<name>" using "getPlaceAPI"