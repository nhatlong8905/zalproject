package common.control.base.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import common.Utilities;
import common.control.base.IEditable;
import constant.Constants;

public class TextBox extends BaseControl implements IEditable {

	public TextBox(String locator) {
		super(locator);
	}
	
	public TextBox(By byLocator) {
		super(byLocator);
	}

	public void enter(CharSequence... value) {
		// TODO Auto-generated method stub
		if(Utilities.haveElementDisplay(getElement()))
		{
			Utilities.waitForElementClickAble(getElement());
			Actions ac= new Actions(getWebDriver());
			ac.moveToElement(getElement());
			ac.perform();
			getElement().sendKeys(value);
		}
	}

}
