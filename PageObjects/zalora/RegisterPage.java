package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import constant.Constants;
import data.object.User;

public class RegisterPage extends GeneralPage{
	
	private final By txtEmail = By.id("RegistrationForm_email");
	private final By txtPassword = By.id("RegistrationForm_password");
	private final By rdFemale = By.id("RegistrationForm_gender_0");
	private final By rdMale = By.id("RegistrationForm_gender_1");
	private final By txtFirstName = By.id("RegistrationForm_first_name");
	private final By cbDay = By.id("RegistrationForm_day");
	private final By cbMonth = By.id("RegistrationForm_month");
	private final By cbYear = By.id("RegistrationForm_year");
	private final By btnReg = By.id("send");
	
	// get elements
	protected WebElement getTxtEmail() {
		return Constants.WEBDRIVER.findElement(txtEmail);
	}
	// get elements
	protected WebElement getTxtPassword() {
		return Constants.WEBDRIVER.findElement(txtPassword);
	}
	// get elements
	protected WebElement getRdFemale() {
		return Constants.WEBDRIVER.findElement(rdFemale);
	}
	// get elements
	protected WebElement getRdMale() {
		return Constants.WEBDRIVER.findElement(rdMale);
	}
	
	// get elements
	protected WebElement getTxtFirstName() {
		return Constants.WEBDRIVER.findElement(txtFirstName);
	}

	// get elements
	protected WebElement getCbDay() {
		return Constants.WEBDRIVER.findElement(cbDay);
	}

	// get elements
	protected WebElement getCbMonth() {
		return Constants.WEBDRIVER.findElement(cbMonth);
	}

	// get elements
	protected WebElement getCbYear() {
		return Constants.WEBDRIVER.findElement(cbYear);
	}

	// get elements
	protected WebElement getBtnReg() {
		return Constants.WEBDRIVER.findElement(btnReg);
	}
	
	public CustomerDetailsPage register(User user) {
		
		this.closePopup();
		this.enterKey(this.getTxtEmail(), user.getEmail());
		this.enterKey(this.getTxtPassword(),user.getPassword());
		if(user.getSex().equals("Female"))
		{
			this.getRdFemale().click();
		}
		else if (user.getSex().equals("Male"))
		{
			this.getRdMale().click();
		}
		Select sDay=new Select(this.getCbDay());
		sDay.selectByValue(user.getDay());
		Select sMonth=new Select(this.getCbMonth());
		sMonth.selectByValue(user.getMonth());
		Select sYear=new Select(this.getCbYear());
		sYear.selectByValue(user.getYear());
		this.getBtnReg().click();
		
		return new CustomerDetailsPage();
	}
}
