package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonLib extends BaseTest{

	//to get the title of page
	public void verifyPageTitle(String expectedTitle,String pageName)
	{
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("the title is matched for"+pageName);
		}
		
		else
		{
			System.out.println("the title is not matched for"+pageName);
		}
	}
	
	public String getTitleOfWebPage(String pageName)
	{
		String titleOfPage = driver.getTitle();
		return titleOfPage;
		
	}
	
	
	//overloding
	public void SwitchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void SwitchToFrame(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void SwitchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	//method chaining
	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}
	
	//dropdown methods
	public void selectOptionsOfDropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	
	public void selectOptionsOfDropdown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	
	public void selectOptionsOfDropdown(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	
	//popups
	public void acceptAlertPopup()
	{
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	
	public void acceptConfirmationPopup()
	{
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	
	public void dismissConfirmationPopup()
	{
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
	
	//action class
	public void rightClick(WebElement target)
	{
		Actions act=new Actions(driver);
		act.contextClick(target).perform();
	}
	
	public void doubleClick(WebElement target)
	{
		Actions act=new Actions(driver);
		act.doubleClick(target).perform();
	}
	public void mouseHover(WebElement target)
	{
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
		
	}
	public void dragAndDrop(WebElement src,WebElement des)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src,des).perform();
	}
	
	
	
	//Robot class
	public void hitTheEnterButton() throws AWTException
	{
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void copyTheText() throws AWTException
	{
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_C);
		ro.keyRelease(KeyEvent.VK_C);
		ro.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void pasteTheText() throws AWTException
	{
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_P);
		ro.keyRelease(KeyEvent.VK_P);
		ro.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	//scrolling operation
	public void scrollDown(int pixelcounts)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixelcounts+")");
	}
	
	public void scrollUp(int pixelcounts)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+(-pixelcounts)+")");
	}
	
	public void scrollLeft(int pixelcounts)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+(-pixelcounts)+",0)");
	}
	
	public void scrollRight(int pixelcounts)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+pixelcounts+",0)");
	}
	
	//to find particular element on webpage
	public void scrollTillAPerticularWebElement(WebElement target)
	{
		Point loc =target.getLocation();
		int xaxis = loc.getX();
		int yaxis = loc.getY();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
		
	}
	
	
	public void getAllOptionsOfDropDown(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allops=sel.getOptions();
		
		for(WebElement op:allops)
		{
			String text=op.getText();
			System.out.println(text);
		}
	}
}
