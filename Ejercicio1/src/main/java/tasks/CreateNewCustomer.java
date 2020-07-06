package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.Map;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.GenericElementsOnPage;
import userinterface.NewCustomerPage;

public class CreateNewCustomer implements Task{
	
	private Map<String, String> data;

	public CreateNewCustomer(Map<String, String> data) {
		this.data = data;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(GenericElementsOnPage.LINK_TO_CUSTOMER.of("New Customer")));
		actor.attemptsTo(WaitUntil.the(NewCustomerPage.INPUT_NAME_CUSTOMER, isVisible()));
		actor.attemptsTo(SendKeys.of(data.get("NameCustomer")).into(NewCustomerPage.INPUT_NAME_CUSTOMER));
		if (data.get("Gender").equals("Male")) {
			Click.on(NewCustomerPage.RADIO_BTN_GENDER.of("m"));
		}
		else {
			Click.on(NewCustomerPage.RADIO_BTN_FEMALE_GENDER);
		}
		actor.attemptsTo(SendKeys.of(data.get("DateOfBirth")).into(NewCustomerPage.CALENDAR_DATE_BIRTH),
	    			SendKeys.of(data.get("Address")).into(NewCustomerPage.INPUT_ADDRESS),
	    			SendKeys.of(data.get("City")).into(NewCustomerPage.INPUT_CITY),
	    			SendKeys.of(data.get("State")).into(NewCustomerPage.INPUT_STATE),
	    			SendKeys.of(actor.recall("PIN")).into(NewCustomerPage.INPUT_PIN),
	    			SendKeys.of(data.get("PhoneNumber")).into(NewCustomerPage.INPUT_PHONE_NUMBER),
	    			SendKeys.of(data.get("Email")).into(NewCustomerPage.INPUT_EMAIL),
	    			SendKeys.of(data.get("Password")).into(NewCustomerPage.INPUT_PASSWORD),		
	    			Click.on(GenericElementsOnPage.BTN_SUBMIT));
		actor.remember("CustomerID", NewCustomerPage.LABEL_CUSTOMER_ID.resolveFor(actor).getText().toString());
			
	}
		
	public static CreateNewCustomer with(Map<String, String> data) {
		return instrumented(CreateNewCustomer.class, data);
	}
}