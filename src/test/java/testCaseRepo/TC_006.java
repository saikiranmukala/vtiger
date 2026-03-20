package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.HomePage;
import objectRepo.OrganizationsPage;

public class TC_006 extends BaseClass{

	@Test(groups = {"Regression"})
	public void ORG_003() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsMenu();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrganizationIcon();
		String orgName = eUtil.getSingleDataFromExcelFile("Organizations", 7, 1);
		String email = eUtil.getSingleDataFromExcelFile("Organizations", 7, 2);
		String industry = eUtil.getSingleDataFromExcelFile("Organizations", 7, 3);
		String ownership = eUtil.getSingleDataFromExcelFile("Organizations", 7, 4);
		String billingCity = eUtil.getSingleDataFromExcelFile("Organizations", 7, 5);
		String billingState = eUtil.getSingleDataFromExcelFile("Organizations", 7, 6);
		String billingCountry = eUtil.getSingleDataFromExcelFile("Organizations", 7, 7);
		int randNum = jUtil.generateRandomNumber(10000);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createNewOrganization(orgName+randNum, email, industry, ownership, billingCity, billingState, billingCountry);
	}
}
