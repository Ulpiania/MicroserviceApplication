Feature: Deleting an Actor
  As a user I would like to delete an actor from my table

  Scenario: I successfully delete an actor from my table
    Given I have the actors ID
    When An Actor is deleted from the table
    Then I get the Deleted return string