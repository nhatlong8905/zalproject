package zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Utilities;

import constant.Constants;

public class ProductsPage extends GeneralPage {
	private final By elementProduct= By.xpath("(//div[@id='datajetSide']/div[contains(@class,'swiper-slide-active')]/li)[1]");
	
	protected WebElement getElementProduct(){
		return Constants.WEBDRIVER.findElement(elementProduct);
	}
	
	public ItemProductPage gotoProductDetailPage()
	{
		Utilities.waitForElementClickAble(getElementProduct());
		this.getElementProduct().click();
		return new ItemProductPage();
	}
	
}
