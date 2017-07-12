//----------------------------------------------------------------
//AUTHOR NAME :- Pooja Chawla
//Objective:  savebooking method to insert records and save booking details
//CREATED DATE :- 06/07/2017
//VERSION :- 1.0
//===============================================================

package booking_hotel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import executionEngine.utility;


public class bookingdetails 
{
	private static WebDriver driver = null;

	public static void savebooking()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	        
			driver = new ChromeDriver();
	        
			String firstname=null;
			String surname=null;
			String price=null;
			String checkin=null;
			String checkout=null;
			String deposit=null;
			String URL = "http://hotel-test.equalexperts.io";
			int countbooking=3;		
			int val=97;
			
			boolean insertfirstname=false;
			boolean insertsurname=false;
			boolean insertprice=false;
			boolean insertcheckin=false;
			boolean insertcheckout=false;
			boolean insertdeposit=false;

						
			for(int i=1;i<=countbooking;i++)
			{
				firstname = "Name_" +(char)val;
				surname = "Surname_" +(char)val;
				val++;
				price = "10";
				deposit="true";
				checkin="2017-07-21";
				checkout="2017-07-22";
				
				insertfirstname=false;
				insertsurname=false;
				insertprice=false;
				insertcheckin=false;
				insertcheckout=false;
				insertdeposit=false;

				//Launch the Online Hotel Booking Website
		        driver.get(URL);
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
			    
		        driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys(firstname);
		        Thread.sleep(500);
		        driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys(surname);
		        Thread.sleep(500);
		        driver.findElement(By.xpath(".//*[@id='totalprice']")).sendKeys(price);
		        Thread.sleep(500);
		        
		        if(deposit=="true")
			        {
			        Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='depositpaid']")));
			        dropdown.selectByVisibleText("true");
			        }
		        else	        	
			        {
		        	Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='depositpaid']")));
			        dropdown.selectByVisibleText("false");	
			        }
		        
		        driver.findElement(By.xpath(".//*[@id='checkin']")).sendKeys(checkin);
		        Thread.sleep(500);

		        driver.findElement(By.xpath(".//*[@id='checkout']")).sendKeys(checkout);
		        Thread.sleep(500);

		        driver.findElement(By.xpath(".//*[@id='form']/div/div[7]/input")).click();
		        
		       	              
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(3000);
				
				System.out.println("\nInserting record " +i+".....\n");
				
				
				List<WebElement> el = driver.findElements(By.cssSelector("*"));
				
				String Contents = "";
				for ( WebElement e : el ) 
				{
				  Contents  = e.getText();
				  
				  insertfirstname=utility.matcher(firstname, Contents);
				  insertsurname=utility.matcher(surname, Contents);
				  insertprice=utility.matcher(price, Contents);
				  insertcheckin=utility.matcher(checkin, Contents);
				  insertcheckout=utility.matcher(checkout, Contents);
				  insertdeposit=utility.matcher(deposit, Contents);
				  if(insertfirstname || insertsurname ||insertprice ||insertcheckin ||insertcheckout ||insertdeposit)
				  {
					 
					  break;
				  }
				  else
				  {
					  //continue with loop
				  }
				
				}
								
			}
		    

			System.out.println("\nBooking done......\n");

					
			
	        Thread.sleep(3000);
			driver.close();
			driver.quit();
		    
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
