package reusableComponents

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.ref.ReferenceQueue.Null

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class VerifyDataInWebTable {
	
	public static WebDriver driver =null;
	
	@Keyword
	public static void verify_expText_In_Colum_Table(TestObject tableObject,String expText,int expTextColNum)
	throws Exception {
boolean status = false;
boolean page = true;
String actText = null;
try {

	table: while (page) {
		driver = DriverFactory.getWebDriver()
		WebElement table =WebUiCommonHelper.findWebElement(tableObject, 20);
		if (table.isDisplayed()) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int rows_Count = rows.size();

			for (int row = 0; row < rows_Count; row++) {
				List<WebElement> cols = rows.get(row).findElements(By.tagName("td"));
				if(cols.size() ==0)
				{
					println "the cols size is Zero"
				}else{
					actText = cols.get(expTextColNum-1).getText();
					if (actText.equals(expText)) {
						println ("Succesfully Matches the Actual text is :"+actText+" the Expected text is :"+expText)
						status = true;
						page = false;
						break table;
					}
				}
				
			}
			if (status == true) {
				break;
			}
		}
		
		if (actText != expText) {
			if (driver.findElements(By.xpath("//li[@class='next']/a")).size() != 0) {
				driver.findElement(By.xpath("//li[@class='next']/a")).click();
				Thread.sleep(1500);
			} else {
				
				Assert.fail(
						"The searching Element is ::" + expText + ":: not present in table");
			}
		}
	}
} catch (Exception e) {
	Assert.fail(e.getMessage());
}
}
	
	@Keyword
	public static void verify_Deleted_ExpText_In_Colum_Table(TestObject tableObject,String expText,int expTextColNum)
	throws Exception {
boolean status = false;
boolean page = true;
String actText = null;
try {

	table: while (page) {
		driver = DriverFactory.getWebDriver()
		WebElement table =WebUiCommonHelper.findWebElement(tableObject, 20);
		if (table.isDisplayed()) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int rows_Count = rows.size();

			for (int row = 0; row < rows_Count; row++) {
				List<WebElement> cols = rows.get(row).findElements(By.tagName("td"));
				if(cols.size() ==0)
				{
					println "the cols size is Zero"
				}else{
					actText = cols.get(expTextColNum-1).getText();
					if (actText.equals(expText)) {
						Assert.fail("The searching Expected Text is ::" + expText + ":: present in table");
						println ("Succesfully Matches the Actual text is :"+actText+" the Expected text is :"+expText)
						status = true;
						page = false;
						break table;
					}
				}
				
			}
			if (status == true) {
				break;
			}
		}
		
		if (actText != expText) {
			if (driver.findElements(By.xpath("//li[@class='next']/a")).size() != 0) {
				driver.findElement(By.xpath("//li[@class='next']/a")).click();
				Thread.sleep(1500);
			} else {
				
				Assert.fail(
						"The searching Element is ::" + expText + ":: not present in table");
			}
		}
	}
} catch (Exception e) {
	Assert.fail(e.getMessage());
}
}
	@Keyword
	public static void verify_MultipleTexts_In_Colum_Table(TestObject tableObject,String expText1,int expText1ColNum,String expText2,int expText2ColNum)
	throws Exception {
boolean status = false;
boolean page = true;
String actText1 = null,actText2 = null;
try {

	table: while (page) {
		driver = DriverFactory.getWebDriver()
		WebElement table =WebUiCommonHelper.findWebElement(tableObject, 20);
		if (table.isDisplayed()) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int rows_Count = rows.size();
			//println ('the row size is '+rows_Count)
			for (int row = 0; row < rows_Count; row++) {
				List<WebElement> cols = rows.get(row).findElements(By.tagName("td"));
				
				if(cols.size() ==0)
				{
					println "the cols size is Zero"
				}else{
			//	println ('the cols size is '+cols.size())
					actText1 = cols.get(expText1ColNum-1).getText();
					actText2 = cols.get(expText2ColNum-1).getText();
					println "actual text 1 is "+actText1+" actual text 2 is "+actText2
					println "Expected text 1 is "+expText1+" Expected text 2 is "+expText2
					if ((actText1.equals(expText1))&& (actText2.equals(expText2)) ) {
						println ("Succesfully Matches the First Actual text is :"+actText1+" the First Expected text is :"+expText1)	
						println ("Succesfully Matches the Second Actual text is :"+actText2+" the Second Expected text is :"+expText2)
						status = true;
						page = false;
						break table;
					}
				}
			}
			if (status == true) {
				break;
			}
		}
		
		if ((actText1 != expText1)&& (actText2 != expText2)) {
			if (driver.findElements(By.xpath("//li[@class='next']/a")).size() != 0) {
				driver.findElement(By.xpath("//li[@class='next']/a")).click();
				Thread.sleep(1500);
			} else {
				Assert.fail(
						"The searching Elements are ::" + expText1 + ":: ::" + expText2 + ":: not present in table");
			}
		}
	}
} catch (Exception e) {
	Assert.fail(e.getMessage());
}
}
	
	
	
	@Keyword
	public static void EditDelete_Click_Operation_In_WebTable(TestObject tableObject, String expText,int expTextColNum,String clickOperation,int clickOperationColNum,String clickAttribute)
	throws Exception {
boolean status = false;
boolean page = true;
String actText = null;
try {

	table: while (page) {
		driver = DriverFactory.getWebDriver()
		WebElement table =WebUiCommonHelper.findWebElement(tableObject, 20);
		if (table.isDisplayed()) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int rows_Count = rows.size();

			for (int row = 0; row < rows_Count; row++) {
				List<WebElement> cols = rows.get(row).findElements(By.tagName("td"));
				if(cols.size() ==0)
				{
					println "the cols size is Zero"
				}else{
				actText = cols.get(expTextColNum-1).getText();
				if (actText.equals(expText)) {
					println ("Succesfully Matches the Actual text is :"+actText+" the Expected text is :"+expText)
					
					String expClickText = clickOperation.toLowerCase();
					switch(expClickText)
					{
						case "view":
						
								String actualView = cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(0).getAttribute(clickAttribute);
									if(actualView.equalsIgnoreCase("view"))
									{
										cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(0).click();
									}else{
										println "The Actual click Opertaion is ::"+actualView+":: not matching with expected Edit Operation Please check once.."
									}
									break;
								
						case "update":
				
						String actualEdit = cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(1).getAttribute(clickAttribute);
							if(actualEdit.equalsIgnoreCase("update"))
							{
								cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(1).click();
							}else{
								println "The Actual click Opertaion is ::"+actualEdit+":: not matching with expected Edit Operation Please check once.."
							}
							break;
						
						case "delete":
						String actualDelete = cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(2).getAttribute(clickAttribute);
							if(actualDelete.equalsIgnoreCase("delete"))
							{
								cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(2).click();
							}else{
								println "The Actual click Opertaion is ::"+actualDelete+":: not matching with expected Edit Operation Please check once.."
							}
							
							break;
							
						default :
						Assert.fail("The Actual Click Opertaion is ::"+expClickText+":: not matching with given values please check and verify")
					
					}
					status = true;
					page = false;
					break table;
				}
				}
					
			}
			if (status == true) {
				break;
			}
		}
		
		if (actText != expText) {
			if (driver.findElements(By.xpath("//li[@class='next']/a")).size() != 0) {
				driver.findElement(By.xpath("//li[@class='next']/a")).click();
				Thread.sleep(1500);
			} else {
				
				Assert.fail(
						"The searching Text is ::" + expText + ":: not present in table");
			}
		}
	}
} catch (Exception e) {
	Assert.fail(e.getMessage());
}
}
	@Keyword
	public static void Peform_AnchorClick_Operation_In_Table(TestObject tableObject, String expText,int expTextColNum,int clickOperationColNum)
	throws Exception {
boolean status = false;
boolean page = true;
String actText = null;
try {

	table: while (page) {
		driver = DriverFactory.getWebDriver()
		WebElement table =WebUiCommonHelper.findWebElement(tableObject, 20);
		if (table.isDisplayed()) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int rows_Count = rows.size();

			for (int row = 0; row < rows_Count; row++) {
				List<WebElement> cols = rows.get(row).findElements(By.tagName("td"));
					
				if(cols.size() ==0)
				{
					println "the cols size is Zero"
				}else{
					actText = cols.get(expTextColNum-1).getText();
					if (actText.equals(expText)) {
					println ("Succesfully Matches the Actual text is :"+actText+" the Expected text is :"+expText)
					
					cols.get(clickOperationColNum-1).findElements(By.tagName("a")).get(0).click();
		
					status = true;
					page = false;
					break table;
					}
				}
					
			}
			if (status == true) {
				break;
			}
		}
		
		if (actText != expText) {
			if (driver.findElements(By.xpath("//li[@class='next']/a")).size() != 0) {
				driver.findElement(By.xpath("//li[@class='next']/a")).click();
				Thread.sleep(1500);
			} else {
				
				Assert.fail(
						"The searching Text is ::" + expText + ":: not present in table");
			}
		}
	}
} catch (Exception e) {
	Assert.fail(e.getMessage());
}
}
}
