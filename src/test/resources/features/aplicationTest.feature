Feature: propertyfinder Testing

  Scenario: Scenario A:
    Given Open http://propertyfinder.qa
    When  Search for VILLA to BUY in location THE PEARL with minimum 3BEDS and maximum 7BEDS
    Then Sort the villas from maximum price to lowest price
    And Fetch all the prices of the listing and save it in a csv file with format : listing title - price

  Scenario: Scenario B:
    Given Open https://propertyfinder.ae
    When Click on FIND AGENTS tab (present on top panel)
    Then Filter agents who can speak "HINDI, ENGLISH, ARABIC"
    And Note down the total count of agents
    And Now further filter agents from India
    And Note down the total count of agents

  Scenario: Scenario C:
    Given Open https://propertyfinder.ae
    When Click on FIND AGENTS tab (present on top panel)Select the First agent
    And Capture following info in a text file
    And Capture Screenshot of the page, change language to Arabic ,Capture screenshot again








