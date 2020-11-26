package BOM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EconomyLotParking extends BaseClass {
	
	
	
	//test with empty entry date & leave date
	@Test (priority = 1)
	public void ChooseaParkingLot01 () {
		new Select(BaseClass.getWebdriver().findElement(By.id("ParkingLot"))).selectByVisibleText("Economy Parking");
		drive.findElement(By.xpath("/html/body/form/input[2]")).click();
		assertEquals(errormessageforinvalidentries(), "ERROR! ENTER A CORRECTLY FORMATTED DATE");
	
	}
	//test with valid entry date &  empty leave date

	@Test (priority = 2)
	public void ChooseaParkingLot02 () throws InterruptedException {
		new Select(BaseClass.getWebdriver().findElement(By.id("ParkingLot"))).selectByVisibleText("Economy Parking");

		drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).clear();
		drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).sendKeys("11/20/2020");
		
		drive.findElement(By.xpath("/html/body/form/input[2]")).click();
		assertEquals(errormessageforinvalidentries(), "ERROR! ENTER A CORRECTLY FORMATTED DATE");
	
	}
	
		
	
	//test with valid entry date & leave date

	@Test (priority = 3)
	public void ChooseaParkingLot03 () throws InterruptedException {
		new Select(BaseClass.getWebdriver().findElement(By.id("ParkingLot"))).selectByVisibleText("Economy Parking");

		drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).clear();
		drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).sendKeys("11/20/2020");
		
		drive.findElement(By.xpath("//*[@id=\"LeavingDate\"]")).clear();
		drive.findElement(By.xpath("//*[@id=\"LeavingDate\"]")).sendKeys("11/21/2020");
	
		drive.findElement(By.xpath("/html/body/form/input[2]")).click();
		assertEquals(price(), "$ 9.00");
		drive.findElement(By.xpath("/html/body/form/input[2]")).click();
		assertEquals(time(), "        (1 Days, 0 Hours, 0 Minutes)");
	
	}
	
	
	//test Leaving Date Or Time Is Before Your Starting Date or Time

		@Test (priority = 4)
		public void ChooseaParkingLot04 () throws InterruptedException {
			

			new Select(BaseClass.getWebdriver().findElement(By.id("ParkingLot"))).selectByVisibleText("Economy Parking");

			drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).clear();
			drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).sendKeys("11/22/2020");
			
			drive.findElement(By.xpath("//*[@id=\"LeavingDate\"]")).clear();
			drive.findElement(By.xpath("//*[@id=\"LeavingDate\"]")).sendKeys("11/21/2020");
		
			drive.findElement(By.xpath("/html/body/form/input[2]")).click();

			assertEquals(errormessageforinvaliddates(), "ERROR! Your Leaving Date Or Time Is Before Your Starting Date or Time");
		
		}
	
		
		

		//test with valid entry date & leave date & enter time enter & time leave

			@Test (priority = 5)
			public void ChooseaParkingLot05 () throws InterruptedException  {
				
				Thread.sleep(1000);
				new Select(BaseClass.getWebdriver().findElement(By.id("ParkingLot"))).selectByVisibleText("Economy Parking");

				drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).clear();
				drive.findElement(By.xpath("//*[@id=\"StartingDate\"]")).sendKeys("11/21/2020");
				
				drive.findElement(By.xpath("//*[@id=\"StartingTime\"]")).clear();
				drive.findElement(By.xpath("//*[@id=\"StartingTime\"]")).sendKeys("1:30");
				
				drive.findElement(By.xpath("//*[@id=\"LeavingDate\"]")).clear();
				drive.findElement(By.xpath("//*[@id=\"LeavingDate\"]")).sendKeys("11/24/2020");
				
				drive.findElement(By.xpath("//*[@id=\"LeavingTime\"]")).clear();
				drive.findElement(By.xpath("//*[@id=\"LeavingTime\"]")).sendKeys("2:30");
				
				drive.findElement(By.xpath("/html/body/form/input[2]")).click();

				assertEquals(price(), "$ 29.00");

				assertEquals(time(), "        (3 Days, 1 Hours, 0 Minutes)");
			
			}
		
	
	
	
	
	public String price() {
		return drive.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/b")).getText();
	}
	
	public String time() {
		return drive.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[2]/b")).getText();
	}
	
	
	public String errormessageforinvalidentries() {
		return drive.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/b")).getText();
	}
	
	public String errormessageforinvaliddates() {
		return drive.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]")).getText();
	}
}
