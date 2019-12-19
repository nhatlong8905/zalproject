package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Utilities;
import constant.Constants;

public class CustomerDetailsPage extends GeneralPage {

	private final By lblEmail= By.xpath("//div[@class='b-account__info box']/span[@class='b-account__infoContent']");
	protected WebElement getLblEmail()
	{
		return Constants.WEBDRIVER.findElement(this.lblEmail);
	}
	
	public String getContentEmail()
	{
		String contentEmail="";
		if(Utilities.isPageLoad())
		{
			contentEmail= this.getLblEmail().getText();
		}
		return contentEmail;
	}
}
