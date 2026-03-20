package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class LoginOperationVTiger {

	public static void main(String[] args) throws IOException, InterruptedException {

		SeleniumUtility sUtil = new SeleniumUtility();
		PropertiesUtility pUtil = new PropertiesUtility();
		ExcelUtility eUtil = new ExcelUtility();
		String URL = pUtil.getDataFromPropertiesFile("url");
		String UN = pUtil.getDataFromPropertiesFile("username");
		String PWD = pUtil.getDataFromPropertiesFile("password");
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 15);
		sUtil.accessToApplication(driver, URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		String lName = eUtil.getSingleDataFromExcelFile("Leads", 4, 1);
		String company = eUtil.getSingleDataFromExcelFile("Leads", 4, 2);
		String leadSource = eUtil.getSingleDataFromExcelFile("Leads", 4, 3);
		String noOfEmp = eUtil.getSingleDataFromExcelFile("Leads", 4, 4);
		String mobile = eUtil.getSingleDataFromExcelFile("Leads", 4, 5);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company, leadSource, noOfEmp, mobile);
		hp.signOutOperation(driver);
		driver.quit();
		
	}

}
