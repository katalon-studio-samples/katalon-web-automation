import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.Dropdown_Html_path

'Open browser'
WebUI.openBrowser(htmlDir)

'Maximize the window'
WebUI.maximizeWindow()

'Selecting the month from Select By value method'
WebUI.selectOptionByValue(findTestObject('DropDown/dropdown_Month'), '3', false)

'Verifying the Option is Selected by Value option'
WebUI.verifyOptionSelectedByValue(findTestObject('DropDown/dropdown_Month'), '3', false, 60)

