package steps;



import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import resources.WorldState;

public class ActivityCatalogStepDefs {


    private List<String> displayedActivities;
    Controller controller;
    private final WorldState state;

    public ActivityCatalogStepDefs(WorldState state) {
        this.state = state;

        controller = new Controller();
        displayedActivities = new ArrayList<>();
    }

    @Given("I am a user on the activities page and some activities are already added in the system")
    public void i_am_a_user_on_the_activities_page() {
        // Code to navigate or set up the activities page.
        controller.iniActivitatsList();
    }

    @When("I click on {string}")
    public void i_click_on_view_activities(String buttonName) {
        // Simulate clicking "View Activities" and display the sorted activities
        displayedActivities.clear();
        displayedActivities.addAll(controller.listActivities());
        if (displayedActivities.isEmpty()) {
            state.message = "No activities found";
        }
    }

    @Then("the system should display the following activities:")
    public void the_system_should_display_the_following_activities(List<String> expectedActivities) {
        // Compare the expected activities with the actual list from the system
        assert (expectedActivities.equals(displayedActivities));
    }

    @Given("the following activities are in the catalog:")
    public void theFollowingActivitiesAreInTheCatalog(List<String> inputActivities) {
        // Add the provided activities to the catalog
        controller.clearActivities(); // Clear previous entries
        controller.addAllActivities(inputActivities);
    }


    @Given("no activities are in the catalog")
    public void noActivitiesAreInTheCatalog() {
        controller.clearActivities(); // Clear previous entries
    }
}
