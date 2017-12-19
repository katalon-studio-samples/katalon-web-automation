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

'Invoking the browser'
WebUI.openBrowser('')
'Passing the URL'
WebUI.navigateToUrl('http://demoaut.katalon.com/')
'Click on the make Appointment Button'
WebUI.click(findTestObject('Page_CURA Healthcare Service/a_Make Appointment'))
'Decalre username variable and assign the value'
def userName = 'katalon'
'Enter text to username field'
WebUI.setText(findTestObject('Page_CURA Healthcare Service (1)/input_username'), userName)
'Get the attribute value of username text field'
input_Value = WebUI.getAttribute(findTestObject('Page_CURA Healthcare Service (1)/input_username'), 'value')
'verify the entered text and attribute value'
WebUI.verifyMatch(userName, input_Value, false)

WebUI.closeBrowser()

