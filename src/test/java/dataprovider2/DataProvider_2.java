package dataprovider2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_2 
{
	
	WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider = "dp")
	void login(String name,String pass) throws InterruptedException
	{
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys(pass);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
		String exp_title = "actiTIME - Login";
		String act_title = driver.getTitle();
		System.out.println(act_title);
		
		//Assert.assertEquals(exp_title, act_title);
		sa.assertEquals(exp_title,act_title );
		sa.assertAll();
		
	}
	
	@AfterClass
	void closeapp()
	{
		
		driver.quit();
	}
	
	@DataProvider(name="dp")
	String [][] loginData()
	{
		String data[][]= {
				            {"admin","manager"}
				            
				            
			            	
				
				          
				
						};
		
		return data;
	}

}
