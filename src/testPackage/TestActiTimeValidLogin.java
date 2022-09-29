package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import pagePackage.LoginPage;


@Listeners(CustomListener.class)
public class TestActiTimeValidLogin extends BaseTest{

	@Test
	public void testValidLogin() throws IOException
	{
		//object creation
		LoginPage lp=new LoginPage(driver);
		Flib flib=new Flib();
		
		//method calling
		lp.validLoginActiTime(flib.readPropertyFile(PROP_PATH, "username"),flib.readPropertyFile(PROP_PATH, "password"));
	}
	
}
