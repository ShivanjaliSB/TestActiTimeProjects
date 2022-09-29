package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	//declaration
	@FindBy(linkText ="Users") private WebElement userstab;
	@FindBy(xpath = "//input[contains(@value,'Create')]") private WebElement createUserButton;
	@FindBy(name="username") private WebElement username;
	@FindBy(name="passwordText") private WebElement password;
	@FindBy(name="passwordTextRetype") private WebElement retypePassword;
	@FindBy(name="firstName") private WebElement firstName;
	@FindBy(name="lastName") private WebElement lastName;
	@FindBy(xpath="//input[contains(@value,'User')]") private WebElement finalUserCreateButton;
	@FindBy(xpath="//a[contains(text(),'surajtsawant')]") private WebElement createdUser;
	@FindBy(xpath="//input[contains(@value,'Delete')]") private WebElement deleteThisUser;
	@FindBy(xpath="//span[@class='successmsg']") private WebElement successmsg;
	
	
	//initialization
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getUserstab() {
		return userstab;
	}
	public WebElement getCreateUserButton() {
		return createUserButton;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getRetypePassword() {
		return retypePassword;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getFinalUserCreateButton() {
		return finalUserCreateButton;
	}
	
	
	public WebElement getSuccessmsg() {
		return successmsg;
	}

	public WebElement getCreatedUser() {
		return createdUser;
	}
	public WebElement getDeleteThisUser() {
		return deleteThisUser;
	}
	

	//operational methods
	public void clickOnUsersTab()
	{
		userstab.click();
	}
	
	
public void createUserAccount(String usersusername,String userspassword,String usersretypepassword,String usersfirstname,String userslastname)
{
	

	createUserButton.click();
	username.sendKeys(usersusername);
	password.sendKeys(userspassword);
	retypePassword.sendKeys(usersretypepassword);
	firstName.sendKeys(usersfirstname);
	lastName.sendKeys(userslastname);
	finalUserCreateButton.click();
	

}

public void deleteTheCreatedUser(String usersusername) {
	// TODO Auto-generated method stub
	createdUser.click();
	deleteThisUser.click();
}
}