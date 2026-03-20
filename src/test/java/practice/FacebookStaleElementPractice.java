package practice;

import java.io.IOException;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;

public class FacebookStaleElementPractice {

	@FindBy(xpath = "//input[@name='user_name']")
	WebElement emailTF;
	
	public FacebookStaleElementPractice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {

		SeleniumUtility sUtil = new SeleniumUtility();
		PropertiesUtility pUtil = new PropertiesUtility();
		String URL = pUtil.getDataFromPropertiesFile("url");
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 20);
		sUtil.accessToApplication(driver, URL);
		FacebookStaleElementPractice f = new FacebookStaleElementPractice(driver);
		f.emailTF.sendKeys("robin@gmail.com");
//		WebElement emailTF = driver.findElement(By.xpath("//input[@name='user_name']"));
//		emailTF.sendKeys("robin@gmail.com");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("robin@gmail.com");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		f.emailTF.sendKeys("hood@gmail.com");
//		emailTF.sendKeys("hood@gmail.com");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hood@gmail.com");
	}

}
