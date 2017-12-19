import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.osgi.framework.util.FilePath as FilePath
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

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
FilePath = WebUI.getAttribute(findTestObject('Upload File object/Upload File'), 'value')

'Verifying the Actual path and Expected path of file'
WebUI.verifyMatch(FilePath, 'C:\\fakepath\\Desert.jpg', false)

