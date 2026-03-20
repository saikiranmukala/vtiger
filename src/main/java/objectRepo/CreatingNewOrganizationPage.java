package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

/**
 * This is a Creating New Organization page POM class
 * @author QSP
 * @version 25-10-06
 */
public class CreatingNewOrganizationPage {

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameTextField;
	
	@FindBy(xpath = "//input[@name='website']")
	private WebElement websiteTextField;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneTextField;
	
	@FindBy(xpath = "//input[@name='email1']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@id='ownership']")
	private WebElement ownershipTextField;
	
	@FindBy(xpath = "//input[@id='bill_city']")
	private WebElement billingCityTextField;
	
	@FindBy(xpath = "//input[@id='bill_state']")
	private WebElement billingStateTextField;
	
	@FindBy(xpath = "//input[@id='bill_country']")
	private WebElement billingCountryTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getOwnershipTextField() {
		return ownershipTextField;
	}

	public WebElement getBillingCityTextField() {
		return billingCityTextField;
	}

	public WebElement getBillingStateTextField() {
		return billingStateTextField;
	}

	public WebElement getBillingCountryTextField() {
		return billingCountryTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This is a business library to create new Organization
	 * @param orgName
	 * @param website
	 * @param phone
	 */
	public void createNewOrganization(String orgName, String website, String phone)
	{
		getOrgNameTextField().sendKeys(orgName);
		getWebsiteTextField().sendKeys(website);
		getPhoneTextField().sendKeys(phone);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create new Organization
	 * @param orgName
	 * @param email
	 * @param industry
	 * @param ownership
	 */
	public void createNewOrganization(String orgName, String email, String industry, String ownership)
	{
		getOrgNameTextField().sendKeys(orgName);
		getEmailTextField().sendKeys(email);
		SeleniumUtility sUtil = new SeleniumUtility();
		sUtil.selectOptionByValue(getIndustryDropdown(), industry);
		getOwnershipTextField().sendKeys(ownership);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create new Organization
	 * @param orgName
	 * @param email
	 * @param industry
	 * @param ownership
	 * @param billingCity
	 * @param billingState
	 * @param billingCountry
	 */
	public void createNewOrganization(String orgName, String email, String industry, String ownership,
			String billingCity, String billingState, String billingCountry)
	{
		getOrgNameTextField().sendKeys(orgName);
		getEmailTextField().sendKeys(email);
		SeleniumUtility sUtil = new SeleniumUtility();
		sUtil.selectOptionByValue(getIndustryDropdown(), industry);
		getOwnershipTextField().sendKeys(ownership);
		getBillingCityTextField().sendKeys(billingCity);
		getBillingStateTextField().sendKeys(billingState);
		getBillingCountryTextField().sendKeys(billingCountry);
		getSaveButton().click();
	}
}
