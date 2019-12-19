package common.control.base.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.control.base.IBaseControl;
import constant.Constants;

public class BaseControl implements IBaseControl {
	private String locator;
	private By byLocator;
	
	public BaseControl(String locator) {
		this.locator = locator;
	}
	
	public BaseControl(By byLocator) {
		this.byLocator = byLocator;
	}
	
	protected WebDriver getWebDriver()
	{
		return Constants.WEBDRIVER;
	}
	
	public WebElement getElement() {
		// TODO Auto-generated method stub
		return getWebDriver().findElement(this.byLocator);
	}

	public boolean isElement() {
		// TODO Auto-generated method stub
		return false;
	}
/*
	private By getByLocator() {
		String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
		String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
		switch (type) {
		case "css":
			return By.cssSelector(body);
		case "id":
			return By.id(body);
		case "link":
			return By.linkText(body);
		case "xpath":
			return By.xpath(body);
		case "text":
			return By.xpath(String.format("//*[contains(text(), '%s')]", body));
		case "name":
			return By.name(body);
		default:
			return By.xpath(locator);
		}
	}
*/
	@Override
	public void click() {
		// TODO Auto-generated method stub
		getElement().click();
	}
}
