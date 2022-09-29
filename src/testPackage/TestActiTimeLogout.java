package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;

@Listeners(CustomListener.class)
public class TestActiTimeLogout extends BaseTest{

	@Test
	public void testActiTimeLogout() throws IOException {
		

	//object creation
	LoginPage lp=new LoginPage(driver);
	Flib flib=new Flib();
	
	//method calling 
	lp.validLoginActiTime(flib.readPropertyFile(PROP_PATH, "username"), flib.readPropertyFile(PROP_PATH, "password"));
	
	
	HomePage hp=new HomePage(driver);
	hp.logoutActitime();
	}
}
