package userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DeleteCustomerPage {
	
	public static final Target INPUT_DELETE_BY_CUSTOMER_ID = Target.the("input delete by customer id")
			.located(By.xpath("//input[@name='cusid']"));
	
}