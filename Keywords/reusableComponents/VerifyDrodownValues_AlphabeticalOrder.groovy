package reusableComponents
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import java.util.*
import internal.GlobalVariable
import org.openqa.selenium.By
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.testng.Assert
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper


public class VerifyDrodownValues_AlphabeticalOrder {
	static WebDriver driver = DriverFactory.getWebDriver()
	//static WebElement element = null
	@Keyword
	public static void verifyOptionsInDropdownInAphabeticalOrder(TestObject objectto) {
		WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
	Select ele = new Select(element)
	List<String> expectedOptions = new ArrayList<>()
	List<String> actualOptions = new ArrayList<>()
	for (WebElement option : ele.getOptions()) {
	System.out.println("Dropdown options are: " + option.getText())
	actualOptions.add(option.getText())
	expectedOptions.add(option.getText())
	}
	Collections.sort(actualOptions)
	System.out.println("Numbers of options present in the dropdown: " + actualOptions.size())
	Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray())
	System.out.println("Yes Dropdown values are in Alphabetical order")
	
	}
}
