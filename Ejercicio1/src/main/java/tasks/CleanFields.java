package tasks;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import questions.ValidateObligatoryFieldsQuestion;
import userinterface.NewCustomerPage;
import util.MessageLabelCustomer;


public class CleanFields implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue("").into(NewCustomerPage.INPUT_STATE),
				Enter.theValue("").into(NewCustomerPage.INPUT_PIN));
		actor.should(seeThat(ValidateObligatoryFieldsQuestion.state(), equalToIgnoringCase(MessageLabelCustomer.MESSAGE_OF_OBLIGATORY_STATE)));
		actor.should(seeThat(ValidateObligatoryFieldsQuestion.state() ,equalToIgnoringCase(MessageLabelCustomer.MESSAGE_OF_OBLIGATORY_STATE)));		
	}
	
	public static CleanFields andValidateMessage() {
		return instrumented(CleanFields.class);
	}

}
