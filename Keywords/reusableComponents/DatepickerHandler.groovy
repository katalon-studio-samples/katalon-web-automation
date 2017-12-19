package reusableComponents
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

public class DatepickerHandler {
//	static WebElement SelectCalender=null

	@Keyword
	public static void handleDatepicker(TestObject calender, String exp_Date, String exp_Month,
			String exp_Year)throws Exception{
		String expDate = null, calYear = null,datepickerText=null,minYear=null,maxYear=null;
		int expMonth = 0, expYear = 0;
		WebElement datePicker;
		List<WebElement> noOfDays=null,noOfMonths=null,noOfYears=null;

		boolean dateNotFound = true;
		List<String> monthList = Arrays.asList("None","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec");
		def driver = DriverFactory.getWebDriver()
		WebElement SelectCalender = WebUiCommonHelper.findWebElement(calender, 20);
//		JavascriptExecutor executor = ((JavascriptExecutor)driver);
//		executor.executeScript("arguments[0].click();", SelectCalender);
		SelectCalender.click()
		// Set your expected date, month and year.
		expDate = (exp_Date);

		expMonth = Integer.parseInt(exp_Month);
		expYear = Integer.parseInt(exp_Year);


		WebElement datePicker_Heading1 =(driver).findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]"));
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.elementToBeClickable(datePicker_Heading1));
		datePicker_Heading1.click();
		//executor.executeScript("arguments[0].click();", datePicker_Heading1);
		WebElement datePicker_Heading2 =(driver).findElement(By.xpath("//div[@class='datepicker-months']/table/thead/tr[1]/th[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(datePicker_Heading2));
		datePicker_Heading2.click();


		while (dateNotFound) {

			WebElement datePicker_Heading3 =(driver).findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[2]"));
			wait.until(ExpectedConditions.visibilityOf(datePicker_Heading3));
			datepickerText =datePicker_Heading3.getText();

			String[] datepickerYear = datepickerText.split("-");
			minYear =datepickerYear[0];
			maxYear = datepickerYear[1];
			// If current selected month and year are same as expected month
			// and year then go Inside this condition.
			if((expYear >= Integer.parseInt(minYear)) && (expYear<=Integer.parseInt(maxYear)))
			{
				datePicker = (driver).findElement(By.xpath("//div[@class='datepicker-years']/table"));
				noOfYears = datePicker.findElements(By.xpath("//span[contains(@class,'year')]"));

				firstloop:
				for (WebElement year : noOfYears) {
					// Select the date from date picker when condition
					// match.
					if (year.getText().equalsIgnoreCase((String)exp_Year)) {
						year.click();
						Thread.sleep(1500);
						datePicker = (driver).findElement(By.xpath("//div[@class='datepicker-months']/table"));
						noOfMonths = datePicker.findElements(By.xpath("//span[@class='month']"));
						Thread.sleep(1000);
						for (WebElement month : noOfMonths) {
							System.out.println(" the expected month in int  is : "+expMonth);
							System.out.println(" the expected month is : "+monthList.get(expMonth));

							System.out.println(" the Actual  month is : "+month.getText());
							if ((monthList.get(expMonth)).equalsIgnoreCase(month.getText())) {
								month.click();
								datePicker = (driver).findElement(By.xpath("//div[@class='datepicker-days']/table"));
								noOfDays = datePicker.findElements(By.xpath("//td[@class='day']"));
								Thread.sleep(1500);
								for (WebElement cell : noOfDays) {
									if (cell.getText().equalsIgnoreCase(expDate)) {
										cell.click();
										break firstloop;
									}
								}
							}
						}
					}
//					else{
//					
//						throw new Exception()
//					}
				}

				dateNotFound = false;
			}else if (expYear > Integer.parseInt(maxYear)) {
				WebElement Next =(driver).findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[@class='next']"));
				if(Next.getAttribute("style").equalsIgnoreCase("visibility: visible;"))
				{// Click on next button of date picker.
					Next.click();
				}else {
					throw new Exception("This is exception")
				}
			}
			// If current selected month and year are greater than expected
			// month and year then go Inside this condition.
			else if (expYear < Integer.parseInt(minYear)) {
				WebElement Previous =(driver).findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[@class='prev']"));

				if(Previous.getAttribute("style").equalsIgnoreCase("visibility: visible;"))
				{
					// Click on previous button of date picker.
					Previous.click();
				}else{
					throw new Exception("This is exception")
				}
			}
		}
	}

}
