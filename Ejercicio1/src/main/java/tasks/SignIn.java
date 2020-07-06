package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import userinterface.GenericElementsOnPage;
import userinterface.LoginPage;

public class SignIn implements Task{
	
	private String email;

	public SignIn(String email) {
		this.email = email;
	}
	

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.wasAbleTo(Open.url("http://demo.guru99.com/V4/index.php"),
				Click.on(LoginPage.LINK_CLICK_HERE),
				SendKeys.of(email).into(LoginPage.BTN_EMAIL_ID),
				Click.on(GenericElementsOnPage.BTN_SUBMIT));
		actor.remember("username", LoginPage.LABEL_USERNAME.resolveFor(actor).getText().toString());
		actor.remember("password", LoginPage.LABEL_PASSWORD.resolveFor(actor).getText().toString());		
	}
	
	public static SignIn with(String email) {
		return instrumented(SignIn.class, email);
	}

}
