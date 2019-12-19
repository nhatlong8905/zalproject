package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.Utilities;
import constant.Constants;


public class LoginPage extends GeneralPage {

	private final By txtUsername = By.id("LoginForm_email");
	private final By txtPassword = By.id("LoginForm_password");
	private final By btnLogin = By.xpath("//button[@type='submit' and contains(.,'Log in')]");
	
	// get elements
	protected WebElement getTxtUsername() {
		return Constants.WEBDRIVER.findElement(txtUsername);
	}
	
	protected WebElement getTxtPassword() {
		return Constants.WEBDRIVER.findElement(txtPassword);
	}
	
	protected WebElement getBtnLogin() {
		return Constants.WEBDRIVER.findElement(btnLogin);
	}
	
	public CustomerDetailsPage login(String username, String password) {
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.closePopup();
		Utilities.waitForElementClickAble(getBtnLogin());
		Actions acLogin= new Actions(Constants.WEBDRIVER);
		acLogin.moveToElement(this.getBtnLogin()).click(this.getBtnLogin()).perform();
		
		return new CustomerDetailsPage();
	}
		
}
