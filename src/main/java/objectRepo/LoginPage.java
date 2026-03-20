package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a Login page POM class
 * @author QSP
 * @version 25-10-06
 */
public class LoginPage {

	//Declaration or Locating the webelements
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	//Initialization of webelements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//public getters
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	//Utilization of webelements
	
	/**
	 * This is a business library to perform login operation to VTiger application
	 * @param UN
	 * @param PWD
	 */
	public void loginToApplication(String UN, String PWD)
	{
		getUsernameTextField().sendKeys(UN);
		getPasswordTextField().sendKeys(PWD);
		getLoginButton().click();
	}
}
