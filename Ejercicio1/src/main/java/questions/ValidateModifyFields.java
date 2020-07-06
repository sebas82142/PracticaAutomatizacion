package questions;
import static userinterface.EditCustomerPage.LABEL_VALIDATE_PIN;
import static userinterface.EditCustomerPage.LABEL_VALIDATE_STATE;

import net.serenitybdd.screenplay.Question;

public class ValidateModifyFields {
	
	public static Question<Boolean> withNewState() {
		return (actor) -> 
		{return LABEL_VALIDATE_STATE.resolveFor(actor).getText().equals(actor.recall("newState"));};
	}
	
	public static Question<Boolean> withNewPin() {
		return (actor) -> 
		{return LABEL_VALIDATE_PIN.resolveFor(actor).getText().equals(actor.recall("newPin"));};
	}
	
}