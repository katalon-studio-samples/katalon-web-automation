import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.MultiSelection_dropDown_Html_Path

'Launch Browser'
WebUI.openBrowser(htmlDir)

'Maximize the window'
WebUI.maximizeWindow()

'Select all the Options'
WebUI.selectAllOption(findTestObject('DropDown/comboBox_Role'))

'Deselect all the options'
WebUI.deselectAllOption(findTestObject('DropDown/comboBox_Role'))

'Taking the count of number of Selected Options and Storing it in a variable'
NoOfSelectedOptions = WebUI.getNumberOfSelectedOption(findTestObject('DropDown/comboBox_Role'))

'After Deselect verifying the Number of Selected options with Actual result to Expected'
WebUI.verifyEqual(NoOfSelectedOptions, 0)

