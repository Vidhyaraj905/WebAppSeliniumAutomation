package SeliniumDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox extends LaunchBrowser
{

	static Alert newalert;
	public static void main(String[] args) throws InterruptedException 
	{
		LaunchBrowser.main(args);
		//System.setProperty("webdriver.chrome.driver","C:\\selinium\\drivers\\chromedriver.exe");
	    //WebDriver driver=new Driver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@alt='Alert']")).click();
		
		//simple alert
		//driver.findElement(By.cssSelector("button[onclick='normalAlert()']")).click();
		driver.findElement(By.xpath("//button[@onclick='normalAlert()']")).click();

		newalert=driver.switchTo().alert();
		System.out.println(newalert.getText());
		Thread.sleep(3000);
		newalert.accept();
	
		//confirmation alert
		driver.findElement(By.cssSelector("button[onclick='confirmAlert()']")).click();
		newalert=driver.switchTo().alert();
		System.out.println(newalert.getText());
		Thread.sleep(3000);
		newalert.dismiss();    // or we can dismiss      newalert.dismiss();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());   //You pressed OK!
		
		//Promt alert
		driver.findElement(By.cssSelector("button[onclick='confirmPrompt()']")).click();
		newalert=driver.switchTo().alert();
		System.out.println(newalert.getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("xpath_element1")).clear();
		newalert.sendKeys("Vidhya"); 
		Thread.sleep(3000);
		newalert.accept();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//p[@id='result1']")).getText()); //You should not have enjoyed learning at Vidhya as compared to TestLeaf! Right?

	}  
	
}

