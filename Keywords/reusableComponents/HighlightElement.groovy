package reusableComponents

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
public class HighlightElement {
	
    static WebDriver driver = DriverFactory.getWebDriver()
    @Keyword
    public static void run(TestObject objectto) {
    try {
		WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
        for (int i = 0; i < 5; i++) {
			
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid red;');",
                    element);
        }
    } catch (Exception e) {
        Assert.fail(e.getMessage());
    }
}
}