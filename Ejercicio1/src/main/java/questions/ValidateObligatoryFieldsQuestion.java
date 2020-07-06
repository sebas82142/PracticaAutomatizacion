package questions;

import static userinterface.EditCustomerPage.LABEL_VALIDATE_STATE;
import static userinterface.EditCustomerPage.LABEL_VALIDATE_PIN;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateObligatoryFieldsQuestion implements Question<String>{
	
	private Target labelField;

	public ValidateObligatoryFieldsQuestion(Target labelField) {
		this.labelField = labelField;
	}

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(labelField).viewedBy(actor).asString();
	}
	
	public static ValidateObligatoryFieldsQuestion state() {
		return new ValidateObligatoryFieldsQuestion(LABEL_VALIDATE_STATE);
	}
	
	public static ValidateObligatoryFieldsQuestion pin() {
		return new ValidateObligatoryFieldsQuestion(LABEL_VALIDATE_PIN);
	}

}
