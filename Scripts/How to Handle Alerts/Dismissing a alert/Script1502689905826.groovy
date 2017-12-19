import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.Alert2_Html_Path;

'Open browser'
WebUI.openBrowser(htmlDir)

'Maximize the window of the browser'
WebUI.maximizeWindow()

'Clicking on  button'
WebUI.click(findTestObject('Alerts/button_ClickHere'))

'Dismiss the Alert '
WebUI.dismissAlert()

