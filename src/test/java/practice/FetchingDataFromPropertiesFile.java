package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;

public class FetchingDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\E4-Selenium\\TestData.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		String value = prop.getProperty("url");
		PropertiesUtility pUtil = new PropertiesUtility();
		String URL = pUtil.getDataFromPropertiesFile("url");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
//		String value1 = prop.getProperty("username");
		String UN = pUtil.getDataFromPropertiesFile("username");
		System.out.println(UN);
		
	}

}
