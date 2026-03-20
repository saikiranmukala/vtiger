package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_001 extends BaseClass{

	@Test(groups = {"Smoke", "Sanity"})
	public void LE_001() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		String fName = eUtil.getSingleDataFromExcelFile("Leads", 1, 1);
		String lName = eUtil.getSingleDataFromExcelFile("Leads", 1, 2);
		String company = eUtil.getSingleDataFromExcelFile("Leads", 1, 3);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fName, lName, company);
	}
}
