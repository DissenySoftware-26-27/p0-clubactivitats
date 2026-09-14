package steps;
import controller.Controller;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import resources.WorldState;

/* IMPORTANT: modificador de visibilitat "public", sinó el Runner no troba els steps indicats amb "glue" */
public class CreditStepDefs {

    private Controller virtualCardController;
    private final WorldState state;

    public CreditStepDefs(WorldState state) {
        this.state = state;
    }

    @Before
    public void beforeScenario() {
        virtualCardController = new Controller();
    }

    @Given("the virtual card balance is {double}")
    public void the_virtual_card_balance_is(double balance) {
        virtualCardController.createNewCardForUser("johndoe");
        virtualCardController.topUpVirtualCard("johndoe", balance);
    }

    @When("the virtual card is withdrawn the amount of {double}")
    public void the_virtual_card_is_withdrawn_the_amount_of(Double amount) {
        state.message = virtualCardController.withdrawVirtualCard("johndoe", amount);
    }
}