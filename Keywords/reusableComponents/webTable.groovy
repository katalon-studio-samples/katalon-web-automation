package reusableComponents

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class webTable {

	
@Keyword
public int Edit_Delete_Update_Anchor_actions(String ExpectedRowName, int Column, int AchorLink) throws InterruptedException {
	
	WebDriver driver = DriverFactory.getWebDriver();
	 int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String celtext=null;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

				celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]/a["+AchorLink+"]"));

						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", common);

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
					

				}
				/*
				if (celtext != ExpectedRowName) {
					if (driver.findElements(By.xpath("//li[@class='next']/a")).size() != 0) {
						driver.findElement(By.xpath("//li[@class='next']/a")).click();
						Thread.sleep(1500);
					} else {
						
						Assert.fail(
								"The searching Element is ::" + ExpectedRowName + ":: not present in table");
					}
				}*/
			}

		}
		return TestData;
	
		

	}


@Keyword
public String GetText_From_WebTable(String ExpectedRowName, int Column) throws InterruptedException {
	
	WebDriver driver = DriverFactory.getWebDriver();
	 int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String Str;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

					String celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]/span"));

					 Str=common.getText();

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
					

				}
			}

		}
		return Str;
	
		

	}



@Keyword
public String GetText_From_WebTable_Organisation(String ExpectedRowName, int Column) throws InterruptedException {
	
	WebDriver driver = DriverFactory.getWebDriver();
	 int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String Str;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

					String celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]"));

					 Str=common.getText();

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
					

				}
			}

		}
		return Str;
	
		

	}




@Keyword
public String Selecting_CheckBox_From_WebTable(String ExpectedRowName, int Column) throws InterruptedException {
	
	WebDriver driver = DriverFactory.getWebDriver();
	 int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String Str;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

					String celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]/input"));

						common.click();
							
					 Str=common.getText();

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
					

				}
			}

		}
		return Str;
	
		

	}
	
	

}
