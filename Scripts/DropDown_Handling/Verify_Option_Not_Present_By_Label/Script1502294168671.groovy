import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.Dropdown_Html_path

'Launch a browser and Navigate to URL'
WebUI.openBrowser(htmlDir)

'Maximize the window'
WebUI.maximizeWindow()

'Verifying the option is not Present'
WebUI.verifyOptionNotPresentByLabel(findTestObject('DropDown/dropdown_Month'), 'CEO', false, 50)

