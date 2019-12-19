package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import common.Utilities;
import constant.Constants;

public class PaymentPage {
	private final By txtCardNum = By.id("cc__card");
	private final By cbMonth = By.id("CreditcardForm_cc_exp_month");
	private final By cbYear = By.id("CreditcardForm_cc_exp_year");
	private final By txtCVC = By.id("cc__cvc");
	private final By txtNameCard = By.id("cc__holder");
	private final By btnContinue= By.xpath("//button[@title='continue to last step']");
	private final By tabCredit= By.xpath("//a[@href='#adyen_creditcard']");
	private final By tabDelivery= By.xpath("//a[@href='#cod']");
	private final By tabPaypal= By.xpath("//a[@href='#paypal']");
	private final By tabGooglePay= By.xpath("//a[@href='#adyen_google_pay']");
	
	private final By panelPayment= By.xpath("//div[@id='payment' and @style='display: block;']");
	
	
	protected WebElement getTxtCardNum()
	{
		return Constants.WEBDRIVER.findElement(this.txtCardNum);
	}
	
	protected WebElement getCBMonth()
	{
		return Constants.WEBDRIVER.findElement(this.cbMonth);
	}

	protected WebElement getCBYear()
	{
		return Constants.WEBDRIVER.findElement(this.cbYear);
	}
	
	protected WebElement getTxtCVC()
	{
		return Constants.WEBDRIVER.findElement(this.txtCVC);
	}
	
	protected WebElement getTxtNameCard()
	{
		return Constants.WEBDRIVER.findElement(this.txtNameCard);
	}
	
	protected WebElement getBtnContinue()
	{
		return Constants.WEBDRIVER.findElement(this.btnContinue);
	}
	
	protected WebElement getTabCredit()
	{
		return Constants.WEBDRIVER.findElement(this.tabCredit);
	}

	protected WebElement getTabDelivery()
	{
		return Constants.WEBDRIVER.findElement(this.tabDelivery);
	}

	protected WebElement getTabPaypal()
	{
		return Constants.WEBDRIVER.findElement(this.tabPaypal);
	}

	protected WebElement getTabGooglePay()
	{
		return Constants.WEBDRIVER.findElement(this.tabGooglePay);
	}
	
	protected WebElement getPanelPayment()
	{
		return Constants.WEBDRIVER.findElement(this.panelPayment);
	}
	
	public boolean checkPanelCreditExist()
	{
		return Utilities.haveElementDisplay(this.panelPayment);
	}
	
	public void fillCreditCard(String cardNum, String month, String Year, String sCVC, String nameCard)
	{
		if(Utilities.isPageLoad())
		{
			Utilities.waitForElementClickAble(this.getTabCredit());
			this.getTabCredit().click();
			this.getTxtCardNum().sendKeys(cardNum);
			Select cbM = new Select(this.getCBMonth());
			cbM.selectByVisibleText(month);
			Select cbY = new Select(this.getCBYear());
			cbY.selectByVisibleText(Year);
			this.getTxtCVC().sendKeys(sCVC);
			this.getTxtNameCard().sendKeys(nameCard);
			Utilities.waitForElementClickAble(this.getBtnContinue());
			this.getBtnContinue().click();
		}
	}
}
