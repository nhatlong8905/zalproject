package zalora;


import org.testng.Assert;
import org.testng.annotations.*;

import com.google.common.base.Verify;

import common.Utilities;
import constant.Constants;
import data.object.User;



public class ZaloraTest extends BaseTest{
	
	String userName = Utilities.randomEmailName();
	String password = Constants.PASSWORD;
	String firstName = Constants.CKFIRSTNAME;
	String lastName = Constants.CLASSNAME;
	String postCode = Constants.POSTCODE;
	String address1 = Constants.ADDRESS1;
	String address2 = Constants.ADDRESS2;
	String cellPhone = Constants.CELLPHONE;
	String phone = Constants.PHONE;
	String cardNum = Constants.CARNUMBER;
	String month = Constants.CMONTH;
	String Year = Constants.CYEAR;
	String sCVC = Constants.CVC;
	String nameCard = Constants.NAMECARD;
	User user = new User(userName, Constants.PASSWORD, Constants.SEX, Constants.FIRSTNAME, Constants.DAY, Constants.MONTH, Constants.YEAR);
	
	@Test(invocationCount = 1)
	public void TC01()
	{
		//1. Open Web
		HomePage homepage= new HomePage();
		homepage.open();
		
		//2.Go to the register Page
		RegisterPage regPage= homepage.gotoRegisterPage();
		
		//3.Register account 
		 CustomerDetailsPage cusPage= regPage.register(user);
		
		// 4-5. Register successful and The user should be redirected to the customer details page
		String emailCus= cusPage.getContentEmail();
		Assert.assertEquals(Utilities.CompareString(emailCus, userName),true);
		
		//6. logout account
		homepage= cusPage.gotoLogout();
		
		//7. Login with exist account
		//LoginPage login= homepage.gotoLoginPage();
		LoginPageControl login= homepage.gotoLoginPage();
		
		//8. Login and go to the customer details page
		cusPage= login.login(userName, password);
		
		//9.1 Order Women
		ProductsPage pPageWomen=login.gotoWonmenProduct();
		ItemProductPage itemPW = pPageWomen.gotoProductDetailPage();
		itemPW.addItemToBag();
		
		//9.2 Order Men
		ProductsPage pPageMen=login.gotoMenProduct();
		ItemProductPage itemPMen = pPageMen.gotoProductDetailPage();
		itemPMen.addItemToBag();
		
		//10. Navigate to cart
		CartPage cartPage= itemPMen.gotoCartPage();
		CheckOutPage ckPage = cartPage.gotoCheckOutPage();
		
		//11. go to checkout and fill information
		PaymentPage pageMent = ckPage.fillNewAddress(firstName, lastName, postCode, address1, address2, cellPhone, phone);
		
		//12.Check payment panel is visible on screen.
		Assert.assertEquals(pageMent.checkPanelCreditExist(),true);
		
		//12.1 go to credit card and fill information
		pageMent.fillCreditCard(cardNum, month, Year, sCVC, nameCard);
	}
}
