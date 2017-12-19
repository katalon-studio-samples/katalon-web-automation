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

'Select the dropdown value by Select option By Label Method'
WebUI.selectOptionByLabel(findTestObject('DropDown/dropdown_Month'), 'Apr', false)

'Verifying the Option is Selected by Label option'
WebUI.verifyOptionSelectedByLabel(findTestObject('DropDown/dropdown_Month'), 'Apr', false, 60)

