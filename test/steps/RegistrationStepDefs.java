package steps;

import controller.Controller;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.WorldState;

import java.util.Map;

public class RegistrationStepDefs {
    private Controller authController;
    private final WorldState state;

    public RegistrationStepDefs(WorldState state) {
        this.state = state;
    }

    @Before
    public void beforeScenario() {
        authController = new Controller();
    }


    // Step definitions
    @Given("no user exists with email {string}")
    public void no_user_exists_with_email(String email) {
        authController.removeUser(email);
    }

    @Given("some users already registered")
    public void someUsersAlreadyRegistered() {
        authController.initializeUsers();
    }

    @Given("the following user exists:")
    public void the_following_user_exists(Map<String, String> users) {
        // Simulate adding existing users to the system
        for  (Map.Entry<String, String> entry : users.entrySet()) {
            authController.addUser(entry.getKey(), entry.getValue());
        }
    }

    @Given("a user has an account with username {string}")
    public void aUserHasAnAccountWithUsername(String arg0) {
        authController.addUser(arg0, "password");
    }

    @When("I register with email {string} and password {string}")
    public void i_register_with_email_and_password(String email, String password) {
        state.message = authController.signUp(email, password);
    }

    @When("I attempt to sign up with the email {string}")
    public void iAttemptToSignUpWithTheEmail(String arg0) {
        state.message = authController.signUp(arg0, "password");
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        assert(state.message.equals("Registration successful"));
    }




}
