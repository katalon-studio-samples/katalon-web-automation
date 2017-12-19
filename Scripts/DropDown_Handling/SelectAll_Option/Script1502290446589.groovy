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

'Selecting all Options'
WebUI.selectAllOption(findTestObject('DropDown/comboBox_Role'))

'Capturing the Number of selected Values and storing it in a variable'
SelectedOptions = WebUI.getNumberOfSelectedOption(findTestObject('DropDown/comboBox_Role'))

'Verifying the number of selected options with Expected result'
WebUI.verifyEqual(SelectedOptions, 5)

