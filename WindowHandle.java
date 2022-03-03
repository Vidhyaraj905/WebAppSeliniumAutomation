package SeliniumDemo;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowHandle extends LaunchBrowser
{
	public static void main(String[] args) throws InterruptedException 
	{
		LaunchBrowser.main(args);
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
				
		String Parentwindow=driver.getWindowHandle();
		System.out.println("Parent Window handle:" +Parentwindow);
		System.out.println("Parent Window URL:" +driver.getCurrentUrl());
		System.out.println("Parent Window Title:" +driver.getTitle());
		System.out.println();
		
		//to handle single pop up window
      /*
		driver.findElement(By.xpath("//button[@onclick='openWin();']")).click();
		
		Set<String> WindowCount=driver.getWindowHandles();
		for(String Windowhandle:WindowCount)
		{
			System.out.println(Windowhandle);
			System.out.println("Total number of windows:" +WindowCount.size());
			System.out.println();


			if(!Windowhandle.equals(Parentwindow))
			{
				driver.switchTo().window(Windowhandle);
				driver.manage().window().maximize();
				System.out.println("Child Window handle:" +Parentwindow);
				System.out.println("Child Window URL:" +driver.getCurrentUrl());
				System.out.println("Child Window Title:" +driver.getTitle());
				driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']")).click();
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Vidhya@gmail.com");
				Thread.sleep(2000);
				driver.close();
			}
		}
		
		*/
		//to handle multiple pop up windows
		
		driver.findElement(By.xpath("//button[@onclick='openWindows()']")).click();
		Set<String> WindowCount=driver.getWindowHandles();
		ArrayList<String> tabs=new ArrayList<>(WindowCount);
		System.out.println("Total number of Windows:" +WindowCount.size());
		for(String Windowhandle:WindowCount)
		{
			if(!Windowhandle.equals(Parentwindow))
			{
				driver.switchTo().window(tabs.get(2));
				driver.manage().window().maximize();
				
				System.out.println();
				Thread.sleep(3000);
				System.out.println("Child Window handle:" +Windowhandle);
				System.out.println("Child Window URL:" +driver.getCurrentUrl());
				System.out.println("Child Window Title:" +driver.getTitle());
				System.out.println();

				Thread.sleep(4000);
				
				driver.findElement(By.id("home")).click();
				Thread.sleep(4000);
			    driver.close();
			    
				Thread.sleep(4000);
				
			    driver.switchTo().window(tabs.get(1));
			    driver.manage().window().maximize();
			   
			    System.out.println();
				System.out.println("Child Window handle:" +Windowhandle);
				System.out.println("Child Window URL:" +driver.getCurrentUrl());
				System.out.println("Child Window Title:" +driver.getTitle());
				System.out.println();
				
				Thread.sleep(4000);

			    driver.findElement(By.linkText("Go to Home Page")).click();
			    Thread.sleep(4000);
			    driver.close();

				Thread.sleep(4000);
			 
			    
			}
			/*
			else       // parent window    //div[@id='contentblock']//div[3]//div[1]//div[1]//button[1]
			{
				driver.findElement(By.xpath("//div[4]//div[1]//div[1]//button[1]")).click();
			}
			*/
		}
	}
}