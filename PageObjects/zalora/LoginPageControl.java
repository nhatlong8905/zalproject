package zalora;

import org.openqa.selenium.By;

import common.control.base.imp.Button;
import common.control.base.imp.TextBox;

public class LoginPageControl extends GeneralPage {

	TextBox txtUserName = new TextBox(By.id("LoginForm_email")); 
	TextBox txtPassword = new TextBox(By.id("LoginForm_password"));	
	Button btnLogin = new Button(By.xpath("//button[@type='submit' and contains(.,'Log in')]"));
		
	public CustomerDetailsPage login(String username, String password) {
		txtUserName.enter(username);
		txtPassword.enter(password);
		this.closePopup();
		btnLogin.click();
		
		return new CustomerDetailsPage();
	}
		
}
