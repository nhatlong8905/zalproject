package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import common.Utilities;
import constant.Constants;

public class GeneralPage {
	private final By iconUser = By.xpath("//i[contains(@class,'account icon_user')]");
	private final By iconCart = By.xpath("//a[@href='/cart/?from=header']");
	private final By tabLogin = By.xpath("//a[@href='customer/account/login/?from=header']");
	private final By tabLogout = By.xpath("//a[@href='customer/account/logout/?from=header']");
	private final By tabRegister = By.xpath("//a[@href='customer/account/create/?from=header']");
	private final By tabWomen = By.xpath("//a[@href='/women/?from=header']");
	private final By tabMen = By.xpath("//a[@href='/men/?from=header']");
	private final By btnClosePopup=By.xpath("//a[@id='js-stickyNewsletter__close--btn']");
	
	// get elements
	protected WebElement getIconUser() {
		return Constants.WEBDRIVER.findElement(iconUser);
	}
	
	protected WebElement getIconCart() {
		return Constants.WEBDRIVER.findElement(iconCart);
	}
	
	protected WebElement getTabLogin() {
		return Constants.WEBDRIVER.findElement(tabLogin);
	}
	
	protected WebElement getTabLogout() {
		return Constants.WEBDRIVER.findElement(tabLogout);
	}
	
	protected WebElement getTabRegister() {
		return Constants.WEBDRIVER.findElement(tabRegister);
	}
	
	protected WebElement getTabWomen() {
		return Constants.WEBDRIVER.findElement(tabWomen);
	}
	
	protected WebElement getTabMen() {
		return Constants.WEBDRIVER.findElement(tabMen);
	}
	
	protected WebElement getBtnClosePopup(){
		return Constants.WEBDRIVER.findElement(this.btnClosePopup);
	}
	/**
	 * Navigate to LoginPage
	 * @return LoginPage
	 */
	public LoginPageControl gotoLoginPage() {
		Utilities.waitForElementClickAble(getIconUser());
		this.getIconUser().click();
		Utilities.waitForElementClickAble(getTabLogin());
		this.getTabLogin().click();
		//return new LoginPage();
		return new LoginPageControl();
	}
	
	public CartPage gotoCartPage() {
		//Utilities.delay(1);
		Utilities.waitForElementClickAble(getIconCart());
		this.getIconCart().click();
		return new CartPage();
	}
	/**
	 * Navigate to Register page
	 * @return Register page
	 */
	public RegisterPage gotoRegisterPage() {
		Utilities.waitForElementClickAble(getIconUser());
		this.getIconUser().click();
		Utilities.waitForElementClickAble(getTabRegister());
		this.getTabRegister().click();
		return new RegisterPage();
	}
	
	/**
	 * Logout
	 */
	public HomePage gotoLogout() {
		Utilities.waitForElementClickAble(getIconUser());
		this.getIconUser().click();
		Utilities.waitForElementClickAble(getTabLogout());
		this.getTabLogout().click();
		
		return new HomePage();
	}
	
	public ProductsPage gotoWonmenProduct()
	{
		Utilities.waitForElementClickAble(getTabWomen());
		this.getTabWomen().click();
		
		return new ProductsPage();
	}
	
	public ProductsPage gotoMenProduct()
	{
		Utilities.waitForElementClickAble(getTabMen());
		this.getTabMen().click();
		
		return new ProductsPage();
	}
	
	public void closePopup() 
	{
		if(Utilities.isElement(this.btnClosePopup))
		{
			if(this.getBtnClosePopup().isDisplayed())
			{
				this.getBtnClosePopup().click();
			}
		}
	}
	
	public void enterKey(WebElement element, String value)
	{
		if(Utilities.haveElementDisplay(element))
		{
			Utilities.waitForElementClickAble(element);
			Actions ac= new Actions(Constants.WEBDRIVER);
			ac.moveToElement(element);
			ac.perform();
			element.sendKeys(value);
		}
	}
}
