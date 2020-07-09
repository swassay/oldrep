package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.BasePage;

public class CategoryPageClass extends BasePage {
	WebDriver driver;
	boolean yes_no;
	boolean find;
	int rand = BasePage.randomNumber();
	String newValue = "NewCategory" + rand;

//	+++++++++++++++++++++++++++++++++++++++++
	// locate element
	// category data input box
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CategoryDataInputBox_LOCATOR;

	// add category button
	@FindBy(how = How.XPATH, using = "//input[@value = 'Add category']")
	WebElement AddCategory_LOCATOR;

	// category dropdown menu
	@FindBy(how = How.NAME, using = "category")
	WebElement CategoryDropDown_LOCATOR;

	// adding duplicate category alert message element
	@FindBy(how = How.XPATH, using = "//body//child::span//preceding::text()[1]")
	WebElement VerifyMsg_LOCATOR;

	// month dropdown element
	
	 @FindBy(how = How.NAME, using = "due_month") WebElement
	 MONTHDROPDOWN;
	 

	@FindBy(how = How.NAME, using = ("allbox"))
	WebElement findBOX;
	@FindBy(how = How.NAME, using = ("submit"))
	WebElement REMOVE_findBOX;
	
	@FindBy(how = How.NAME, using = ("todo[09]"))
	WebElement SINGLE_findBOX;
	@FindBy(how = How.NAME, using = ("submit"))
	WebElement SUBMIT_SINGLE_findBOX;
	
	
	
	
	  public void Togglebar() throws InterruptedException { 
		  System.out.println("In Togglebar");
		  findBOX.click(); 
		  System.out.println("Test passed");
			Thread.sleep(2000);
		//	TimeElement(driver, 5, findBOX);
			Assert.assertTrue(findBOX.isSelected(), "ToggleAllCheckbox is not selected!" );
			System.out.println("Toggle test passed");
		}
			/*
			 * public void verifyAllfindboxesareSelected() { List<WebElement> findboxes =
			 * driver.findElements(By.xpath("//input[@type='checkbox']")); for (int i = 0; i
			 * <findboxes.size(); i++) { //findboxes.get(i).click();
			 * 
			 * if (findboxes.get(i).isSelected()) { System.out.println(i +
			 * " findBox is selected "); } else { System.out.println(i +
			 * " findBox is not selected "); }}
			 * 
			 * 
			 * }
			 */	  
	  
	  public void verifyAllCheckboxesareSelected() {
		  System.out.println("In verifyAllCheckboxes");
		//////*[@id="todos-content"]/form/ul/li/input
			List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
			//List<WebElement> checkboxes = driver.findElements(By.name("allbox"));
			  System.out.println("Checking size");
			  System.out.println("Checkbox size:" +checkboxes.size());
			for (int i = 0; i <checkboxes.size(); i++) {
				

				if (checkboxes.get(i).isSelected()) {
					System.out.println(i + " checkBox is selected ");
				} 
				else {
					System.out.println(i + " checkBox is not selected ");
				}
			}
	}


	  public void RemoveOne() { 
		  SUBMIT_SINGLE_findBOX.click();
	//	  verifyListRemoved();
	  }
	  
	  
	  public void RemoveAll() { 
			/*
			 * REMOVE_findBOX.click(); 
			 * verifyListRemoved();
			 */
 
	  } 
	  
		/*
		 * public void verifyListRemoved() { List<WebElement> boxes =
		 * driver.findElements(By.xpath("//input[@type='findbox']"));
		 * Assert.assertTrue(boxes.isEmpty(), "findbox removed!");
		 * System.out.println("Test pass");
		 */
	  
	 // }
	 

	// methods
	  	public void AddCategory() throws InterruptedException {

	  		 System.out.println("Entered add category"); 
	  // added new dropdown item, created dropdown object using Select class
	  	CategoryDataInputBox_LOCATOR.sendKeys(newValue);
	    AddCategory_LOCATOR.click();
	  
		 System.out.println("Clicked");
	  Select drpCategory = new Select(CategoryDropDown_LOCATOR); 
	  Thread.sleep(10);
	  
	  List<WebElement> dropdownItems = drpCategory.getOptions(); 
		 System.out.println("No of items: " +dropdownItems.size());
	  // finding which item in list
	  for (WebElement dropdowncategory : dropdownItems)
	  {
	  
	  if (dropdowncategory.getText().equals(newValue)) { Assert.assertTrue(true);
	  yes_no = true; 
	  System.out.println("New added category is " +
	  dropdowncategory.getText()); }
	  
	  }
	  
	  // printing yes_no from finding drop down element 
	  if 
	  (yes_no == true) {
	  
	  } 
	  	else { System.out.println("New added category is NOT found");
	  
	  }
	  
	  // now selecting new item from dropdown list
	  drpCategory.selectByVisibleText(newValue);
	  
	  WebElement option = drpCategory.getFirstSelectedOption();
	  String defaultItem  = option.getText(); 
	  System.out.println("Value selected in dropdown now is " + defaultItem);
	  
	  // finding if new item is displayed on top of the page on right side
	  
	  String newCat = driver.findElement(By.xpath("//span[contains (text(), '" +
	  newValue + "')]")).getText(); 
	  // 
	 
	  if (newCat.equalsIgnoreCase(newValue)) {
	  System.out.println("New item is Displayed to be Removed"); } else {
	  System.out.println("New item Missing!!!"); } 
	  
	  	}
	  
	  	
	  public void Duplicate() throws InterruptedException {
	  
	  String expectedString = "The category you want to add already exists: " +
	  newValue; System.out.println(expectedString); // added new dropdown item
	  CategoryDataInputBox_LOCATOR.sendKeys(newValue); 
	  AddCategory_LOCATOR.click();
	  
	  WebElement element = driver.findElement(By.cssSelector("body"));
	  
	  boolean feedbackVisible = element.isDisplayed();
	  System.out.println(feedbackVisible);
	  System.out.println(driver.findElement(By.cssSelector("body")).getText().
	  substring(0, 55)); 
	  Thread.sleep(5000); //
	  WebElement YesElement =
	  driver.findElement(By.xpath("//a[contains (text(), 'Yes')]"));
	  YesElement.click();
	  
	  }
	 
	public void monthTest() throws InterruptedException
	{
int i=12;
System.out.println("Printing months");
Thread.sleep(5000);
Select dropDown = new Select(MONTHDROPDOWN);

		 List<WebElement>dropActual=dropDown.getOptions();
		 for (WebElement element:dropActual)
		 System.out.println((element.
				 getAttribute("value")));
		 int option =dropDown.getOptions().size();
			System.out.println("actual"+(option-1));
			System.out.println("i="+i);
			Assert.assertEquals(i, option-1, "Failed Month Test");
			System.out.println("Printing months - Exiting");
	}		
		
	private void TimeElement(WebDriver driver, int time, WebElement LOCATOR) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(LOCATOR));

	}

}
