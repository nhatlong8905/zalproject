package zalora;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import common.Utilities;
import constant.Constants;

public class ItemProductPage extends GeneralPage {
	
	private final By cbInternational=By.id("SizeSystem");
	private final By cbSize=By.id("productSizeSelect");
	private final By btnAddBag=By.id("AddToCart");
	private final By panelMyBag=By.xpath("//div[contains(@class,'minicart__popup')]");
	private final By lOpCBInter= By.xpath("//select[@id='SizeSystem']/option");
	private final By lOpCBSize= By.xpath("//select[@id='productSizeSelect']/option");
	
	
	protected List<WebElement> getlOpCBInter(){
		return Constants.WEBDRIVER.findElements(this.lOpCBInter);
	}
	
	protected List<WebElement> getlOpCBSize(){
		return Constants.WEBDRIVER.findElements(this.lOpCBSize);
	}
	
	protected WebElement getCBInternational(){
		return Constants.WEBDRIVER.findElement(this.cbInternational);
	}
	
	protected WebElement getCBSize(){
		return Constants.WEBDRIVER.findElement(this.cbSize);
	}
	
	protected WebElement getBtnAddBag(){
		return Constants.WEBDRIVER.findElement(this.btnAddBag);
	}
	
	protected WebElement getPanelMyBag(){
		return Constants.WEBDRIVER.findElement(this.panelMyBag);
	}
	
	private int findItemVisible(List<WebElement> lstElement)
	{
		int item = 0;
		for(int i=1;i<lstElement.size()-1;i++)
		{
			WebElement opt = lstElement.get(i);
			if(!Utilities.isAttribtuePresent(opt, "disabled"))
			{
				return i;
			}
		}
		return item;
	}
	
	public void addItemToBag()
	{
		if(Utilities.isPageLoad())
		{
			closePopup();
			if(Utilities.isElement(this.cbInternational) && Utilities.haveElementDisplay(this.cbInternational))
			{
				int itemInter = findItemVisible(this.getlOpCBInter());
				Utilities.waitForElementClickAble(getCBInternational());
				Select cbInter = new Select(this.getCBInternational());
				cbInter.selectByIndex(itemInter);
			}
			if(Utilities.isElement(this.cbSize) && Utilities.haveElementDisplay(this.cbSize))
			{
				int itemSize = findItemVisible(this.getlOpCBSize());
				Utilities.waitForElementClickAble(getCBSize());
				Select cbSize = new Select(this.getCBSize());
				cbSize.selectByIndex(itemSize);
			}
			this.getBtnAddBag().click();
			if(Utilities.haveElementDisplay(this.panelMyBag))
			{
				Utilities.waitForElementClickAble(this.getPanelMyBag());
				this.getPanelMyBag().click();
			}
			
		}
	}
		
}
