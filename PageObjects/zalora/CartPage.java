package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Utilities;
import constant.Constants;

public class CartPage {
	private final By btnCheckOut = By.xpath("//a[contains(@class,'sel-cart-checkout-button')]");
	
	protected WebElement getBtnCheckOut()
	{
		return Constants.WEBDRIVER.findElement(btnCheckOut);
	}
	
	public CheckOutPage gotoCheckOutPage()
	{
		if(Utilities.isPageLoad())
		{
			if(Utilities.haveElementDisplay(btnCheckOut))
			{
				Utilities.waitForElementClickAble(getBtnCheckOut());
				getBtnCheckOut().click();
			}
		}
		return new CheckOutPage();
	}
	
}
