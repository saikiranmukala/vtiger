package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_003 extends BaseClass {

	@Test(groups = {"Smoke"})
	public void LE_003() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		String lName = eUtil.getSingleDataFromExcelFile("Leads", 7, 1);
		String company = eUtil.getSingleDataFromExcelFile("Leads", 7, 2);
		String title = eUtil.getSingleDataFromExcelFile("Leads", 7, 3);
		String email = eUtil.getSingleDataFromExcelFile("Leads", 7, 4);
		String city = eUtil.getSingleDataFromExcelFile("Leads", 7, 5);
		String state = eUtil.getSingleDataFromExcelFile("Leads", 7, 6);
		String country = eUtil.getSingleDataFromExcelFile("Leads", 7, 7);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company, title, email, city, state, country);
	}

}
