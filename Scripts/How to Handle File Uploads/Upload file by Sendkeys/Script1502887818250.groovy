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
import org.eclipse.osgi.framework.util.FilePath as FilePath
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.UploadFile_Html_Path

'Open browser'
WebUI.openBrowser(htmlDir)

'Maximize the window\r\n'
WebUI.maximizeWindow()

def imgDir = RunConfiguration.getProjectDir() + GlobalVariable.Image_Upload_Path

'Passing the URL of image location'
WebUI.sendKeys(findTestObject('Upload File object/Upload File'), imgDir)

'Capturing the Attribute value and Storing it in a Variable'
FakePath = WebUI.getAttribute(findTestObject('Upload File object/Upload File'), 'value')


'Verifying the Actual path and Expected path of file'
WebUI.verifyMatch(FakePath, 'C:\\fakepath\\Desert.jpg', false)

