package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.DeleteCustomerPage;
import userinterface.GenericElementsOnPage;

public class DeleteCustomer implements Task{
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(GenericElementsOnPage.LINK_TO_CUSTOMER.of("Delete Customer")),
				WaitUntil.the(DeleteCustomerPage.INPUT_DELETE_BY_CUSTOMER_ID, isVisible()),
				SendKeys.of(actor.recall("CustomerID").toString()).into(DeleteCustomerPage.INPUT_DELETE_BY_CUSTOMER_ID),
				Click.on(GenericElementsOnPage.BTN_SUBMIT));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actor.attemptsTo(Switch.toAlert());
		BrowseTheWeb.as(actor).getAlert().accept();
		BrowseTheWeb.as(actor).getAlert().dismiss();
	}
		
	public static DeleteCustomer withCustomerID() {
		return instrumented(DeleteCustomer.class);
	}

}
