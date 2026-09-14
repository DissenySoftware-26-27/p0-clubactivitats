Feature: US03 - Virtual card is credited with amount
  As a registered user
  I want to withdraw from virtual card successfully
  So that I can book an activity from the catalog

  Scenario: Withdraw from virtual card successfully
    Given the virtual card balance is 30.0
    When the virtual card is withdrawn the amount of 30.0
    Then the system displays the message "Successful withdrawn"

  Scenario: Withdraw too much credit from virtual card
    Given the virtual card balance is 10.0
    When the virtual card is withdrawn the amount of 30.0
    Then the system displays the message "The virtual card has not enough credit"
