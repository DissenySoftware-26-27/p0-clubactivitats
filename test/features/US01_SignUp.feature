Feature: US01 - User Sign Up with Email and Password Validation
  As a new user
  I want to sign up with a valid email and a secure password
  So that I can access the application safely


  Scenario: Successful registration with valid email and strong password
    Given no user exists with email "newuser@example.com"
    When I register with email "newuser@example.com" and password "StrongPass123"
    Then the registration should be successful

  Scenario: Registration with a weak password (less than 8 characters)
    Given no user exists with email "newuser@example.com"
    When I register with email "newuser@example.com" and password "weak"
    Then the system displays the message "Weak password - must be at least 12 characters with 1 capital letter and 1 number"

  Scenario: Registration with an existing email
    Given the following user exists:
      | email                 | password      |
      | existinguser@domain.com | Password123! |
    When I register with email "existinguser@domain.com" and password "AnotherPass456"
    Then the system displays the message "Email already registered - please log in"

  Scenario: Registration with an invalid email
    Given no user exists with email "invalidemail"
    When I register with email "invalidemail" and password "ValidPass123"
    Then the system displays the message "Invalid email format"

  Scenario: Existing user email "ajaleo@gmail.com" that I know that he is in the DataBase
    Given some users already registered
    When I attempt to sign up with the email "ajaleo@gmail.com"
    Then the system displays the message "Email already registered - please log in"


  