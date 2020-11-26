package BOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	static WebDriver drive;

	@BeforeTest
	public void setUp() {
		drive = new ChromeDriver();
		drive.get("http://www.shino.de/parkcalc/");
		drive.manage().window().maximize();
		
	}
	
	
	
	public static WebDriver getWebdriver() {
		return drive;
	}
	
	
	@AfterTest
	public void teardown() {
		drive.close();

	}

}
