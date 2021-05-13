package LoginTestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenUsingJxl {

	String[][] data=null;
	WebDriver driver;

	@DataProvider(name="provideData")
	public String[][] dataprovidermethod() throws BiffException, IOException {
		data=readDataUsingJxl();
		return data;
	}


	public String[][] readDataUsingJxl() throws BiffException, IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\kaviya.dhananjayan\\Desktop\\TestDataJxl.xls");
		Workbook workbook=Workbook.getWorkbook(file);
		Sheet sheet=workbook.getSheet(0);
		int rowCount=sheet.getRows();
		int columnCount=sheet.getColumns();

		String testdata[][]= new String[rowCount-1][columnCount];

		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				testdata[i-1][j] =sheet.getCell(j, i).getContents();
			}
		}
		return testdata;
	}

	@BeforeTest
	public void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaviya.dhananjayan\\Desktop\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test(dataProvider="provideData")
	public void login(String uname, String pword){


		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);

		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(pword);

		WebElement loginbtn = driver.findElement(By.id("btnLogin"));
		loginbtn.click();
	}
}
