package testPackage;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagePackage.LoginPage;
import pagePackage.UsersPage;

@Listeners(CustomListener.class)
public class TestActiTimeCreateUser extends BaseTest {

	@Test
	public void createuserActitime() throws IOException, InterruptedException, AWTException
	{
		
		//object creation
		
		LoginPage lp=new LoginPage(driver);
		Flib flib=new Flib();
		
		
		//method calling
		
		lp.validLoginActiTime(flib.readPropertyFile(PROP_PATH, "username"), flib.readPropertyFile(PROP_PATH, "password"));
		
		UsersPage up=new UsersPage(driver);
		up.clickOnUsersTab();
		
		Thread.sleep(2000);
		up.createUserAccount("shivanibiradar", "shivani22", "shiva", "biradar", "shivbiaa");
		Thread.sleep(2000);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.textToBePresentInElement(up.getSuccessmsg(),"created"));
		up.clickOnUsersTab();
		up.deleteTheCreatedUser("");
		
		WebDriverCommonLib wb=new WebDriverCommonLib();
		wb.hitTheEnterButton();
	}
}
