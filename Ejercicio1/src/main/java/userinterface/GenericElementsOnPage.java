package userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class GenericElementsOnPage {
	
	public static final Target BTN_SUBMIT = Target.the("button for submit")
			.located(By.xpath("//input[@type=\"submit\"]"));
	public static final Target LINK_TO_CUSTOMER = Target.the("Link new customer")
			.locatedBy("//li[a[text()='{0}']]");
}