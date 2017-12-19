import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.MultiSelection_dropDown_Html_Path

'Launch a browser and Navigate to URL'
WebUI.openBrowser(htmlDir)

'Verfying the Options in a  dropdown'
CustomKeywords.'reusableComponents.VerifyExpectedAndActualOptionsInDropdown.VerifyExpectedAndActual'(findTestObject('DropDown/comboBox_Role'), 
    ['Admin', 'HR', 'Networking', 'Developer', 'Tester'])

