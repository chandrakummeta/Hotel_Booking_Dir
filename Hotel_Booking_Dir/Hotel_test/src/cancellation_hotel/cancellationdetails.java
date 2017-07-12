//----------------------------------------------------------------
//AUTHOR NAME :- Pooja Chawla
//Objective:  cancelbooking method to delete records and remove booking details
//CREATED DATE :- 10/07/2017
//VERSION :- 1.0
//===============================================================

package cancellation_hotel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import executionEngine.utility;

public class cancellationdetails 
{
	private static WebDriver driver = null;

	public static void cancelbooking()
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
			String attributeid=null;
			String xpathdeletebutton=null;
			int countbooking=3;	
			int val=97;
			String [] deleteData = new String[countbooking];
			
			
			//Launch the Online Hotel Booking Website
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			for(int i=1;i<=countbooking;i++)
			{
				
				firstname = "Name_" +(char)val;
				surname = "Surname_" +(char)val;
				val++;
				price = "10";
				deposit="true";
				checkin="2017-07-21";
				checkout="2017-07-22";
						        		
				WebElement formElement = driver.findElement(By.id("bookings"));
				
				List<WebElement> allFormChildElements = formElement.findElements(By.xpath("*"));
				for(WebElement item : allFormChildElements )
				{
					String textvalue = item.getText();
										
					if(utility.matcher(firstname, textvalue))
					{
						attributeid = item.getAttribute("id");
						deleteData[i-1]=attributeid;
						break;						
					}
									
				}
				
				
			}
		    
			for(int j=0;j<countbooking;j++)
			{
				xpathdeletebutton = ".//*[@id='" + deleteData[j] +"']/div[7]/input";
				int k=j+1;
				System.out.println("\ndeleting record"+k+"......");
				driver.findElement(By.xpath(xpathdeletebutton)).click();
		        Thread.sleep(1000);
			}
			
			System.out.println("\nCancellation done......\n");			
		
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
