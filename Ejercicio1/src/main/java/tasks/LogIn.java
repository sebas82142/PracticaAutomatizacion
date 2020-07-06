package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import userinterface.GenericElementsOnPage;
import userinterface.LoginPage;

public class LogIn implements Task{
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.wasAbleTo(Open.url("http://demo.guru99.com/V4/index.php"),
				SendKeys.of(actor.recall("username")).into(LoginPage.INPUT_USERNAME),
				SendKeys.of(actor.recall("password")).into(LoginPage.INPUT_PASSWORD),
		Click.on(GenericElementsOnPage.BTN_SUBMIT));
		actor.remember("PIN", LoginPage.LABEL_PIN.resolveFor(actor).getText().toString().substring(16, 22));
	}
	
	public static LogIn withCredentialSystem() {
		return instrumented(LogIn.class);
	}

}