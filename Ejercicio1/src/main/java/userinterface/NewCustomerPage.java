package userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class NewCustomerPage {
	
	public static final Target LINK_NEW_CUSTOMER = Target.the("Link new customer")
			.located(By.xpath("//a[text()='Edit Customer']"));
	public static final Target INPUT_NAME_CUSTOMER = Target.the("input customer name")
			.located(By.xpath("//input[@name=\"name\"]"));
	public static final Target RADIO_BTN_GENDER = Target.the("click gender radio button")
			.locatedBy("//input[@value='f']");
	public static final Target RADIO_BTN_FEMALE_GENDER = Target.the("click gender radio button")
			.located(By.xpath("(//input[@type='radio'])[2]"));
	public static final Target CALENDAR_DATE_BIRTH = Target.the("input Date of birth")
			.located(By.xpath("//input[@name=\"dob\"]"));
	public static final Target INPUT_ADDRESS = Target.the("input address")
			.located(By.xpath("//textarea[@name=\"addr\"]"));
	public static final Target INPUT_CITY = Target.the("input city")
			.located(By.xpath("//input[@name=\"city\"]"));
	public static final Target INPUT_STATE = Target.the("input State")
			.located(By.xpath("//input[@name=\"state\"]"));
	public static final Target INPUT_PIN = Target.the("click PIN")
			.located(By.xpath("//input[@name=\"pinno\"]"));
	public static final Target INPUT_PHONE_NUMBER = Target.the("click Number Phone")
			.located(By.xpath("//input[@name=\"telephoneno\"]"));
	public static final Target INPUT_EMAIL = Target.the("click Email")
			.located(By.xpath("//input[@name=\"emailid\"]"));
	public static final Target INPUT_PASSWORD = Target.the("click password")
			.located(By.xpath("//input[@name=\"password\"]"));
	public static final Target CLICK_SUBMIT = Target.the("click submit")
			.located(By.xpath("//input[@type=\"submit\"]"));
	public static final Target LABEL_CUSTOMER_ID = Target.the("label customer id")
			.located(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]"));
	
}