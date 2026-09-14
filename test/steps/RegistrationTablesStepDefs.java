package steps;

import controller.Controller;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import resources.WorldState;

public class RegistrationTablesStepDefs {
    private Controller authController;
    private final WorldState state;
    public RegistrationTablesStepDefs(WorldState state) {
        this.state = state;
    }

    @Before
    public void beforeScenario() {
        authController = new Controller();
    }


    @When("I attempt to sign up with the email {string} and password {string}")
    public void iAttemptToSignUpWithTheEmailAndPassword(String arg0, String arg1) {
        state.message = authController.signUp(arg0, arg1);
    }

    @Given("some users already registered in the system")
    public void someUsersAlreadyRegisteredInTheSystem() {
        authController.initializeUsers();
    }
}
