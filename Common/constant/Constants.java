package constant;

import org.openqa.selenium.WebDriver;
import zalora.driver.manager.DriverManager;

public class Constants {

	public static WebDriver WEBDRIVER;
	public static DriverManager driverManager;
	public static final String Zalora_URL = "https://www.zalora.sg/";
	public static final long SLEEP_TIME =1;
	public static final long SHORT_TIME =10;
	
	// activated account 
	public static final String EMAILNAME = "";
	public static final String PASSWORD = "Abcd1234";
	public static final String SEX = "Male";
	public static final String FIRSTNAME = "Nhat";
	public static final String DAY = "11";
	public static final String MONTH = "05";
	public static final String YEAR = "1990";
	
	
	//The information of checkout
	public static final String CKFIRSTNAME = "Nhat";
	public static final String CLASSNAME = "Phan";
	public static final String POSTCODE = "523444";
	public static final String ADDRESS1 = "1 tran hung dao";
	public static final String ADDRESS2 = "1 nguyen trai";
	public static final String CELLPHONE = "99934567";
	public static final String PHONE= "99987654";
	
	//The information of credit card 
	public static final String CARNUMBER = "5161111122223456";
	public static final String CMONTH = "04";
	public static final String CYEAR = "2020";
	public static final String CVC = "333";
	public static final String NAMECARD = "phan truong nhat";
}
