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

'Lauching the browser and URL'
WebUI.openBrowser(GlobalVariable.URL_Katalon_Demo)

'Maximize the Window'
WebUI.maximizeWindow()

'Waiting for page to be loaded'
WebUI.waitForPageLoad(60)

'Clicking on Make Appointment link'
WebUI.click(findTestObject('demoaut.katalon.com/link_Make Appointment'))

'Clicking on Login button'
WebUI.click(findTestObject('demoaut.katalon.com/button_Login'))

'Waiting for page to be loaded'
WebUI.waitForPageLoad(60)

'Waiting for Make Appointment heading to be visible'
WebUI.verifyElementVisible(findTestObject('demoaut.katalon.com/heading_Make Appoitment'))

'Capturing the heading and storing it in a variable'
Heading = WebUI.getText(findTestObject('demoaut.katalon.com/heading_Make Appoitment'))

'Verifying the Heading Make Appointment'
WebUI.verifyEqual(Heading, findTestData('Excel file Test Data Login').getValue(4, 1))

