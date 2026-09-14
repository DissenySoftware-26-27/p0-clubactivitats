Feature: US01 - SignUp with Email and Password Validation - version tables
  As a user
  I want to sign up with a valid email and a secure password
  So that I can access the application safely

  Scenario Outline: User sign-up validation with email and password
    Given some users already registered in the system
    When I attempt to sign up with the email "<email>" and password "<password>"
    Then the system shows the message "<message>"

    Examples:
      | email                     | password       | message                                                          |
      | newuser@example.com        | abc123         | Weak password - must be at least 12 characters with 1 capital letter and 1 number |
      | newuser@example.com        | abc12345       | Weak password - must be at least 12 characters with 1 capital letter and 1 number |
      | newuser@example.com        | Password1234   | Registration successful                                           |
      | newuserexample.com         | Password1234   | Invalid email format                                              |
      | ajaleo@gmail.com           | ajaleoPassw7   | Email already registered - please log in                          |
      | dtomacal@yahoo.cat         | Qwertyft5      | Email already registered - please log in                          |
      | newuser@example.com        | abc12          | Weak password - must be at least 12 characters with 1 capital letter and 1 number  |
      | newuser@example.com        | passwordabcd12 | Weak password - must be at least 12 characters with 1 capital letter and 1 number |
