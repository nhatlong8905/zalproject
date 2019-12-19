package zalora;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constant.Constants;
import zalora.driver.DriverType;
import zalora.driver.manager.DriverManagerFactory;

public class BaseTest {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Run beforeMethod");
		Constants.driverManager=DriverManagerFactory.getDriverManager(DriverType.Chrome);
		Constants.WEBDRIVER=Constants.driverManager.getWebDriver();
		Constants.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Run afterMethod");
		Constants.WEBDRIVER.quit();
	}
}
