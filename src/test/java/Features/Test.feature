Feature: Validation of Rest Maps API

  @AddPlace @Regression
  Scenario Outline: Validation of Add Place Api

    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user call "AddplaceAPI" api using "POST" http request
    Then verify response api status code is 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then verify "place_id" created maps to "<name>" using "GetplaceAPI"

  Examples:
    |name  |language| address  |
    |Imran |English |Jharkhand |
    |Khan  |French  |New York  |

  @DeletePlace @Regression
  Scenario: Verify if Delete Place functionality is working

    Given Delete Place Payload
    When user call "DeleteplaceAPI" api using "POST" http request
    Then verify response api status code is 200
    And "status" in response body is "OK"