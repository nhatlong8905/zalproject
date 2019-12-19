package common;

import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constants;

public class Utilities {
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	public static JavascriptExecutor jsExecutor() {
		return (JavascriptExecutor) Constants.WEBDRIVER;
	}
	public static void waitForElementClickAble(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER,10);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static boolean haveElementDisplay(By locator)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public static boolean haveElementDisplay(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER,10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public static boolean haveElementInvisible(By locator)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER,10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public static void delay(double timeInSecond) {
		try {
			Thread.sleep((long)(timeInSecond * 1000));
		} catch (Exception e) {
			
		}
	}
	
	public static boolean isPageLoad(long timeout) {
		delay(2);
		JavascriptExecutor js = (JavascriptExecutor)Constants.WEBDRIVER;
		String jsStatus = "Begin";		
		long loop = timeout;
		while (loop > 0 && !jsStatus.equals("complete"))
		{	
			try {
				loop = loop - Constants.SLEEP_TIME;
				jsStatus = js.executeScript("return document.readyState").toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				jsStatus = e.getMessage();
				return false;
			}
		}
		if(jsStatus.equals("complete"))
		{
			return true;
		}
		return true;
	}

	public static boolean isPageLoad()
	{
		return isPageLoad(Constants.SHORT_TIME);
	}
	
	public static boolean isAttribtuePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}
	
	public static boolean isElement(By element)
	{
		return Constants.WEBDRIVER.findElements(element).size() != 0;
	}
	
	public static boolean CompareString(String src, String des)
	{
		String eNameSRC=src.split("@")[0];
		String eNameDes=des.split("@")[0];
		String newSrc= eNameSRC.substring(0, 3);
		String newDes= eNameDes.substring(0, 3);
		if(newSrc.equals(newDes))
		{
			return true;
		}
		return false;
	}
	
	public static String randomEmailName() {
		String mail = "zalora@gmail.com";
		Date date= new Date();
		long timeNow = date.getTime();
		Timestamp ts= new Timestamp(timeNow);
		
		String newMail= mail.split("@")[0]+ "+" + ts.getTime() +"@"+ mail.split("@")[1];
		return newMail;
	}
	
	public static void setValue(WebElement element,String value) {
		try {
			String js = String.format("arguments[0].value='%s';", value);
			jsExecutor().executeScript(js, element);
		} catch (Exception e) {
			
		}
	}
}
