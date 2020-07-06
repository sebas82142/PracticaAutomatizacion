package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateCustomerDeleteQuestion {
	
	public static Question<Boolean> withTheMessage(String message) {
		return (actor) -> 
		{return BrowseTheWeb.as(actor).getAlert().getText().toString().equals(message);};
	}
}
