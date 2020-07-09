package test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.CategoryPageClass;
import util.BrowserFactory;

public class AddContactTest {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		driver = BrowserFactory.startBrowser();
	}

	
	  @Test (priority = 2) 
	  public void togglebutton() throws InterruptedException {
	  CategoryPageClass cataddpage1 = PageFactory.initElements(driver, CategoryPageClass.class); 
	  cataddpage1.Togglebar(); 
	  }
	  @Test (priority = 4) 
	  public void RemoveBars() throws InterruptedException {
		  CategoryPageClass cataddpage1_1 = PageFactory.initElements(driver, CategoryPageClass.class); 
		  cataddpage1_1.RemoveOne();
		  cataddpage1_1.RemoveAll();
	  }
	  
	  @Test(priority = 3) 
	  public void DuplicateItem() throws InterruptedException {
	  CategoryPageClass cataddpage2 = PageFactory.initElements(driver,
	  CategoryPageClass.class); 
	  cataddpage2.AddCategory(); 
	  cataddpage2.Duplicate();
	  }
	 
	@Test(priority = 1)
	public void validateMonthDropDownBox() throws InterruptedException {
	CategoryPageClass cataddpage3 = PageFactory.initElements(driver, CategoryPageClass.class);
		cataddpage3.monthTest();
		
				
	}
	
	@AfterTest
	public void closing() {
		BrowserFactory.tearDown();

	}
}
	