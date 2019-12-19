package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.Utilities;
import constant.Constants;

public class CheckOutPage extends GeneralPage {
	private final By txtFirstName= By.id("AddressForm_first_name");
	private final By txtLastName= By.id("AddressForm_last_name");
	private final By txtPostCode= By.id("AddressForm_postcode");
	private final By txtAddress1= By.id("AddressForm_address1");
	private final By txtAddress2= By.id("AddressForm_address2");
	private final By txtCellPhone= By.id("AddressForm_cell_phone");
	private final By txtPhone= By.id("AddressForm_phone");
	private final By btnSave= By.xpath("//button[@title='Save & Continue']");
	private final By btnDelete= By.xpath("//a[@class='js-show_delete_address']");
	private final By btnDelAdress= By.xpath("//button[@title='Delete Address']");
	
	//get element
	protected WebElement getTxtFirstName()
	{
		return Constants.WEBDRIVER.findElement(txtFirstName);
	}
	
	protected WebElement getTxtLastName()
	{
		return Constants.WEBDRIVER.findElement(txtLastName);
	}
	
	protected WebElement getTxtPostCode()
	{
		return Constants.WEBDRIVER.findElement(txtPostCode);
	}
	
	protected WebElement getTxtAddress1()
	{
		return Constants.WEBDRIVER.findElement(txtAddress1);
	}
	
	protected WebElement getTxtAddress2()
	{
		return Constants.WEBDRIVER.findElement(txtAddress2);
	}
	
	protected WebElement getTxtCellPhone()
	{
		return Constants.WEBDRIVER.findElement(txtCellPhone);
	}
	
	protected WebElement getTxtPhone()
	{
		return Constants.WEBDRIVER.findElement(txtPhone);
	}
	
	protected WebElement getBtnSave()
	{
		return Constants.WEBDRIVER.findElement(btnSave);
	}
	
	protected WebElement getBtnDelete()
	{
		return Constants.WEBDRIVER.findElement(btnDelete);
	}
	
	protected WebElement getBtnDelAdress()
	{
		return Constants.WEBDRIVER.findElement(btnDelAdress);
	}
	
	public PaymentPage fillNewAddress(String firstName,String lastName,String postCode,String address1,String address2,String cellPhone,String phone )
	{
		if(Utilities.isPageLoad())
		{
			if(Utilities.isElement(this.btnDelete))
			{
				this.getBtnDelete().click();
				Utilities.waitForElementClickAble(this.getBtnDelAdress());
				this.getBtnDelAdress().click();
			}
			this.enterKey(getTxtFirstName(), firstName);
			this.enterKey(getTxtLastName(), lastName);
			this.enterKey(getTxtPostCode(), postCode);
			Utilities.setValue(getTxtAddress1(), address1);
			//this.getTxtAddress1().sendKeys(address1);		
			this.enterKey(getTxtAddress2(), address2);
			this.enterKey(getTxtCellPhone(), cellPhone);
			this.enterKey(getTxtPhone(), phone);
			Utilities.waitForElementClickAble(this.getBtnSave());
			this.getBtnSave().click();
		}
		return new PaymentPage();
	}
	
}
