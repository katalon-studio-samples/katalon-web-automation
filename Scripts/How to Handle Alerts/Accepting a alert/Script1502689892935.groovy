import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.Alerts_Html_path

'Launch a browser and Navigate to URL'
WebUI.openBrowser(htmlDir)

'Maximize the window of the browser'
WebUI.maximizeWindow()

'Clicking on  button'
WebUI.click(findTestObject('Alerts/button_ClickHere'))

'Accepting the Alert '
WebUI.acceptAlert()

