import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.MultiSelection_dropDown_Html_Path

'Launch a browser and Navigate to URL'
WebUI.openBrowser(htmlDir)

'Maximize the window'
WebUI.maximizeWindow()

'Selecting the option with Label HR'
WebUI.selectOptionByLabel(findTestObject('DropDown/comboBox_Role'), 'HR', false)

'DeSelecting the option with index 1 i.e HR'
WebUI.deselectOptionByIndex(findTestObject('DropDown/comboBox_Role'), 1)

