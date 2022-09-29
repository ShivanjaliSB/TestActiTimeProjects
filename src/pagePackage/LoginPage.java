package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declaration
	
		@FindBy(name="username") private WebElement usn;
		@FindBy(name="pwd") private WebElement pass;
		@FindBy(id="loginButton") private WebElement loginButton;
		@FindBy(id="keepLoggedInCheckBox") private WebElement checkbox;
		@FindBy(xpath = "//a[contains(text(),'Actimind')") private WebElement linkActiTime;
		@FindBy(xpath = "//img[contains(@src,'timer')]") private WebElement logoActiTime;
		
		//intialization
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}

		//utiliazation
		
		public WebElement getUsn() {
			return usn;
		}

		public WebElement getPass() {
			return pass;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}

		public WebElement getCheckbox() {
			return checkbox;
		}

		public WebElement getLinkActiTime() {
			return linkActiTime;
		}

		public WebElement getLogoActiTime() {
			return logoActiTime;
		}
		
		//operational method
		
		public void validLoginActiTime(String validUsername,String validPassword)
		{
			usn.sendKeys(validUsername);
			pass.sendKeys(validPassword);
			loginButton.click();
		}
		
		public void invalidLoginActiTime(String invalidusername,String invalidPassword) throws InterruptedException
		{
			usn.sendKeys(invalidusername);
			pass.sendKeys(invalidPassword);
			loginButton.click();
			Thread.sleep(2000);
			usn.clear();
		}
}
