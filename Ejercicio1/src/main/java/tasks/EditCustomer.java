package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.GenericElementsOnPage;
import userinterface.NewCustomerPage;

public class EditCustomer implements Task{
	
	private String state;
	private String pin;

	public EditCustomer(String state, String pin) {
		this.state = state;
		this.pin = pin;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(state).into(NewCustomerPage.INPUT_STATE),
				Enter.theValue(pin).into(NewCustomerPage.INPUT_PIN),
				Click.on(GenericElementsOnPage.BTN_SUBMIT));
		actor.remember("newState", state);
		actor.remember("newPin", pin);
	}
	
	public static EditCustomer with(String state, String pin) {
		return instrumented(EditCustomer.class, state, pin);
	}

}
