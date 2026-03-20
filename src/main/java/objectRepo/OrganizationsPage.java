package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a Organizations page POM class
 * @author QSP
 * @version 25-10-06
 */
public class OrganizationsPage {

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrganizationIcon;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewOrganizationIcon() {
		return createNewOrganizationIcon;
	}
	
	/**
	 * This is a business library to click on Create New Organization icon
	 */
	public void clickOnCreateNewOrganizationIcon()
	{
		getCreateNewOrganizationIcon().click();
	}
}
