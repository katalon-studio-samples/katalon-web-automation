import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.MultiSelection_dropDown_Html_Path

'Launch a browser and naviagte to URL'
WebUI.openBrowser(htmlDir)

'Maximize the window'
WebUI.maximizeWindow()

'Capturing the Toal Number of  Values in the dropdown and storing it in a variable'
TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('DropDown/comboBox_Role'))

println('No of Roles are :' + TotalOptions)

'Verifying the number of Options in the dropdown with Expected result'
WebUI.verifyEqual(TotalOptions, 5)

