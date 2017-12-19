import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Invoking Browser'
WebUI.openBrowser('')

'Launch the url'
WebUI.navigateToUrl('http://demoaut.katalon.com/')

'Click on Make Appointment Button'
WebUI.click(findTestObject('Page_CURA Healthcare Service/a_Make Appointment'))

'Click on Login Button'
WebUI.click(findTestObject('Page_CURA Healthcare Service (1)/button_Login'))

'Select the Hongkong CURA Healthcare Center from dropdown'
WebUI.selectOptionByValue(findTestObject('Page_CURA Healthcare Service (2)/select_facility'), 'Hongkong CURA Healthcare Center', 
    true)

'Check Hospital readmission check box'
WebUI.check(findTestObject('Page_CURA Healthcare Service (2)/input_hospital_readmission'))

'Check on Medicadi radio button'
WebUI.check(findTestObject('Page_CURA Healthcare Service (2)/input_Medicaid Radio'))

'Check the None Radio Button'
WebUI.verifyElementChecked(findTestObject('Page_CURA Healthcare Service (2)/input_Medicaid Radio'), 30)

'Check on Medicadi radio button'
WebUI.check(findTestObject('Page_CURA Healthcare Service (2)/input_None Radio'))

'Verify unchecked status of Medicaid Radio button'
WebUI.verifyElementNotChecked(findTestObject('Page_CURA Healthcare Service (2)/input_Medicaid Radio'), 30)

'Verify the checked status of the None Radio Button'
WebUI.verifyElementChecked(findTestObject('Page_CURA Healthcare Service (2)/input_None Radio'), 30)

'Click on calendar icon'
WebUI.click(findTestObject('Page_CURA Healthcare Service (2)/div_input-group-addon'))

'Click on Calendar date'
WebUI.click(findTestObject('Page_CURA Healthcare Service (2)/td_3'))

'Enter katalon text in comments box'
WebUI.setText(findTestObject('Page_CURA Healthcare Service (2)/textarea_comment'), 'Katalon')

'Click on Book Appointment'
WebUI.click(findTestObject('Page_CURA Healthcare Service (2)/button_Book Appointment'))

'Close the Browser'
WebUI.closeBrowser()

