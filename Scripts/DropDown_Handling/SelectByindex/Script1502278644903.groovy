import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.Dropdown_Html_path

'Open browser'
WebUI.openBrowser(htmlDir)

'Maximize the Window'
WebUI.maximizeWindow()

'Select the dropdown value by Select option By index Method'
WebUI.selectOptionByIndex(findTestObject('DropDown/dropdown_Month'), 2)

'Verifying the Option is Selected by Index option'
WebUI.verifyOptionSelectedByIndex(findTestObject('DropDown/dropdown_Month'), 2, 60)

