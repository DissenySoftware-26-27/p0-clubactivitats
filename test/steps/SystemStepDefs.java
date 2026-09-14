package steps;

import io.cucumber.java.en.Then;
import resources.WorldState;

public class SystemStepDefs {

    private WorldState state;
    public SystemStepDefs(WorldState state) {
        this.state = state;
    }

    @Then("the system displays/shows the message {string}")
    public void the_system_displays_the_message(String expectedMessage) {
        assert(state.message.equals(expectedMessage));
    }
}