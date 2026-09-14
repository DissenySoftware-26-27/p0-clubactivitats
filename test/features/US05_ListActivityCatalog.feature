Feature: US05 - List the activity catalog
  As a registered user
  I want to view the full list of activities
  So that I can choose an activity from the catalog

  Scenario: List all activities in the catalog when the user clicks to view activities
    Given I am a user on the activities page and some activities are already added in the system
    When I click on "View Activities"
    Then the system should display the following activities:
      | El camí des Correu     |
      | La Foradada            |
      | Museu Miró             |

  Scenario: List all activities in the catalog when activities are available
    Given the following activities are in the catalog:
      | La Seu Vella          |
      | Puigmal               |
      | La Molina             |
      | Cavalls del Vent      |
    When I click on "View Activities"
    Then the system should display the following activities:
      | Cavalls del Vent      |
      | La Molina             |
      | La Seu Vella          |
      | Puigmal               |

  Scenario: No activities in the catalog
    Given no activities are in the catalog
    When I click on "View Activities"
    Then the system displays the message "No activities found"
