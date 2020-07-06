package userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class EditCustomerPage {
	
	public static final Target LABEL_VALIDATE_STATE = Target.the("label validate state message")
			.located(By.xpath("//label[@id='message5']"));
	public static final Target LABEL_VALIDATE_PIN = Target.the("label validate pin message")
			.located(By.xpath("//label[@id='message6']"));
	public static final Target LABEL_TABLE_STATE = Target.the("label to validate change in the state")
			.located(By.xpath("//tr[td[text()='State']]/td[2]]"));
	public static final Target LABEL_TABLE_PIN = Target.the("label to validate change in the pin")
			.located(By.xpath("//tr[td[text()='Pin']]/td[2]]"));

}
