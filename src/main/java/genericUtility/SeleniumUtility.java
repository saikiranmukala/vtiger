package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * This is an Utility class which has functionalities present in Selenium library
 * @author QSP
 * @version 25-10-03
 */
public class SeleniumUtility {

	/**
	 * This is a generic method to access a web application
	 * @param driver
	 * @param URL
	 */
	public void accessToApplication(WebDriver driver, String URL)
	{
		driver.get(URL);
	}
	
	/**
	 * This is a generic method to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This is a generic method to provide implicit wait
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver, int maxTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	
	////////*********** Handling Dropdowns ***********///////////
	
	/**
	 * This is a generic method to select an option in dropdown by using its index
	 * @param dropdownEle
	 * @param index
	 */
	public void selectOptionByIndex(WebElement dropdownEle, int index)
	{
		Select sel = new Select(dropdownEle);
		sel.selectByIndex(index);
	}
	
	/**
	 * This is a generic method to select an option in dropdown by using its value attribute
	 * @param dropdownEle
	 * @param valueSttribute
	 */
	public void selectOptionByValue(WebElement dropdownEle, String valueAttribute)
	{
		Select sel = new Select(dropdownEle);
		sel.selectByValue(valueAttribute);
	}
	
	/**
	 * This is a generic method to select an option in dropdown by using its visible text
	 * @param dropdownEle
	 * @param visibleText
	 */
	public void selectOptionByVisibleText(WebElement dropdownEle, String visibleText)
	{
		Select sel = new Select(dropdownEle);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This is a generic method to deselect an option in dropdown by using its value attribute
	 * @param dropdownEle
	 * @param valueSttribute
	 */
	public void deselectOptionByValue(WebElement dropdownEle, String valueSttribute)
	{
		Select sel = new Select(dropdownEle);
		sel.deselectByValue(valueSttribute);
	}
	
	/**
	 * This is a generic method to deselect an option in dropdown by using its index
	 * @param dropdownEle
	 * @param index
	 */
	public void deselectOptionByIndex(WebElement dropdownEle, int index)
	{
		Select sel = new Select(dropdownEle);
		sel.deselectByIndex(index);
	}
	
	//////////********** Handling Alert popup ***********///////////
	
	/**
	 * This is a generic method to accept an alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This is a generic method to dismiss an alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This is a generic method to fetch alert message
	 * @param driver
	 * @return
	 */
	public String getAlertMessage(WebDriver driver)
	{
		String value = driver.switchTo().alert().getText();
		return value;
	}
	
	/**
	 * This is a generic method to pass prompt to alert popup
	 * @param driver
	 * @param value
	 */
	public void passPromptToAlert(WebDriver driver, String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	///////////*********** Handling Mouse Actions ***********/////////////
	
	/**
	 * This is a generic method to perform mouse hovering action on a webelement
	 * @param driver
	 * @param targetEle
	 */
	public void mouseHoveringAction(WebDriver driver, WebElement targetEle)
	{
		Actions act = new Actions(driver);
		act.moveToElement(targetEle).perform();
	}
	
	/**
	 * This is a generic method to perform double click operation on a webelement
	 * @param driver
	 * @param targetEle
	 */
	public void doubleClickOperation(WebDriver driver, WebElement targetEle)
	{
		Actions act = new Actions(driver);
		act.doubleClick(targetEle).perform();
	}
	
	////////////************* Taking webpage Screenshot *********//////////
	
	/**
	 * This is a generic method to capture the screenshot of a webpage
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String getWebpageScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();			//used for listeners
	}
}
