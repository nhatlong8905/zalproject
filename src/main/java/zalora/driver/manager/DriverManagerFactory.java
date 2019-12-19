package zalora.driver.manager;

import zalora.browser.chrome.ChromeDriverManager;
import zalora.driver.DriverType;

public class DriverManagerFactory {
	
	public static DriverManager getDriverManager(DriverType type)
	{
		DriverManager driverManager;
		switch(type)
		{
			case Chrome:
				driverManager= new ChromeDriverManager();
			case Firefox:
			case IE:
			case Edge:
			default:
				driverManager=new ChromeDriverManager();
		}
		return driverManager;
	}

}
