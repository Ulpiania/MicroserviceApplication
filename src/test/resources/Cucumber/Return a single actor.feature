Feature: Returning a single actor
  As a user I would like to retrieve a single actor from their ID

  Scenario: I successfully retrieve a single actor from their ID
    Given I have the actors_ID
    When I Query the database using the ID
    Then I get the corresponding actor to the ID returned