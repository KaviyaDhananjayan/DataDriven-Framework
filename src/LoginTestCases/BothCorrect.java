package LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	
	@Test
	@Parameters({"usernm","pwd"})
	public void loginWithBothCorrect(String uname, String pword){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaviya.dhananjayan\\Desktop\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(pword);
		
		WebElement loginbtn = driver.findElement(By.id("btnLogin"));
		loginbtn.click();
		
		driver.quit();
	}


}
