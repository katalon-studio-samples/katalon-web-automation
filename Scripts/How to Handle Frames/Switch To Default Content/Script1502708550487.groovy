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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



'Launching and Navigating to URL\r\n'
WebUI.openBrowser(GlobalVariable.URL_Iframe)

'Maximize the window\r\n'
WebUI.maximizeWindow()

'Switching to text area which is situated in Iframe'
WebUI.switchToFrame(findTestObject('Frames/textArea_Iframe'), 60)

'Fecthing the text from Text area and storing it in a variable'
Text = WebUI.getText(findTestObject('Frames/TextArea'))

'Switching back to the main window or parent window frame'
WebUI.switchToDefaultContent()

'Verifying the Actual text with Expected text from Text Area.'
WebUI.verifyEqual(Text, 'Your content goes here.')

'Getting the text of the web element and storing it in a variable'
Heading = WebUI.getText(findTestObject('Frames/Frame Heading'))

'Verifying the Actual text with Expected text from Text Area.'
WebUI.verifyEqual(Heading, 'An iFrame containing the TinyMCE WYSIWYG Editor')

