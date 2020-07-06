package userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

	public static final Target LINK_CLICK_HERE = Target.the("user")
			.located(By.xpath("//a[text()='here']"));
	public static final Target BUTTON_VIDEO_CLOSE = Target.the("button video close")
			.located(By.xpath("//a[text()='here']"));
	public static final Target BTN_EMAIL_ID = Target.the("input for email")
			.located(By.xpath("//input[@name=\"emailid\"]"));
	public static final Target LABEL_USERNAME = Target.the("label to get username")
			.located(By.xpath("(//td[@align=\"center\"])[3]"));
	public static final Target LABEL_PASSWORD = Target.the("label to get password")
			.located(By.xpath("(//td[@align=\"center\"])[5]"));
	public static final Target INPUT_USERNAME = Target.the("input the username")
			.located(By.xpath("//input[@name=\"uid\"]"));
	public static final Target INPUT_PASSWORD = Target.the("input the password")
			.located(By.xpath("//input[@name=\"password\"]"));
	public static final Target LABEL_PIN = Target.the("label pin")
			.located(By.xpath("//tr[@align='center']/td"));
	
}