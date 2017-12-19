import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.osgi.framework.util.FilePath as FilePath
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.UploadFile_Html_Path

def imgDir = RunConfiguration.getProjectDir() + GlobalVariable.Image_Upload_Path

'Open browser'
WebUI.openBrowser(htmlDir)

'Maximize the window\r\n'
WebUI.maximizeWindow()

'Passing the path of the file'
WebUI.uploadFile(findTestObject('Upload File object/Upload File'), imgDir)

'Capturing the file name after upload and storing it in a variable'
FilePath = WebUI.getAttribute(findTestObject('Upload File object/Upload File'), 'value')

'Verifying the Actual path and Expected path of file'
WebUI.verifyMatch(FilePath, 'C:\\fakepath\\Desert.jpg', false)

