import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Storing the URL in a variable'
def htmlDir = RunConfiguration.getProjectDir() + GlobalVariable.Alert2_Html_Path

'Open browser'
WebUI.openBrowser(htmlDir)

'Maximize the window of the browser'
WebUI.maximizeWindow()

'Clicking on  button'
WebUI.click(findTestObject('Alerts/button_ClickHere'))

'Using the current driver Instance'
WebDriver driver = DriverFactory.getWebDriver()

'Passing the text in the text box in the Alert\r\n'
driver.switchTo().alert().sendKeys('Testing')

'Dismiss the Alert '
WebUI.dismissAlert()

