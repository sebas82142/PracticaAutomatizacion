package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import userinterface.DeleteCustomerPage;
import userinterface.GenericElementsOnPage;

public class GoToEditCustomer implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Open.url("http://demo.guru99.com/V4/manager/EditCustomer.php"),
				Enter.theValue(actor.recall("CustomerID")).into(DeleteCustomerPage.INPUT_DELETE_BY_CUSTOMER_ID),
				Click.on(GenericElementsOnPage.BTN_SUBMIT));
	}
	
	public static GoToEditCustomer page() {
		return instrumented(GoToEditCustomer.class);
	}

}
