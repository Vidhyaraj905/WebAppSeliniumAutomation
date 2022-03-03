package SeliniumDemo;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser 
{
	static WebDriver driver;
	static Scanner s;
		public static void main(String[] args) throws InterruptedException 
		{
			System.out.println("Enter the browser name FF or GC on console and click enter");
	        s = new Scanner(System.in);
	        String browser = s.next();
	        if(browser.equals("GC"))
	         {
	        	System.setProperty("webdriver.chrome.driver","C:\\selinium\\drivers\\chromedriver.exe");
	        	driver=new ChromeDriver();
	        	System.out.println(" Driver object.. chrome browser reference: "+driver);
	     //   	driver.get("https://www.facebook.com/");
	         }
	        else if(browser.equals("FF"))
	        {
			     System.setProperty("webdriver.gecko.driver","C:\\selinium\\drivers\\geckodriver.exe");
				 driver = new FirefoxDriver();
		         System.out.println(" Driver object.. firefox browser reference: "+driver);
	        }
	        
				
		}

}
