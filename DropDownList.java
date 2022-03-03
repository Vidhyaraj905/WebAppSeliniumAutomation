package SeliniumDemo;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends LaunchBrowser
{
	
    public static void main(String[] args) throws InterruptedException 
    {
    	LaunchBrowser.main(args);
	 	driver.get("http://leafground.com/pages/Dropdown.html");
	 	driver.manage().window().maximize();
	 
	 	System.out.println("USING INDEX");
	    WebElement drop1=driver.findElement(By.id("dropdown1"));
	    Thread.sleep(2000);
	    Select select111=new Select(drop1);  
	    select111.selectByIndex(3);
	    System.out.println("List of options under this drop down list:"+drop1.getText());
	    System.out.println("I slected:"+select111.getFirstSelectedOption().getText());
	    Thread.sleep(2000);
	    System.out.println();
	    
	 	System.out.println("USING TEXT");
	    WebElement drop2=driver.findElement(By.name("dropdown2"));
	    Select select222=new Select(drop2);
	    select222.selectByVisibleText("Appium");
	    System.out.println("List of options under this drop down list:"+drop2.getText());
	    System.out.println("I slected:"+select222.getFirstSelectedOption().getText());
	    Thread.sleep(2000);
	    System.out.println();

	 	System.out.println("USING VALUE");
	    WebElement drop3=driver.findElement(By.name("dropdown3"));
	    Select select333=new Select(drop3);
	    select333.selectByValue("1");
	    System.out.println("List of options under this drop down list:"+drop3.getText());
	    System.out.println("I slected:"+select333.getFirstSelectedOption().getText());
	    Thread.sleep(2000);
	    driver.close();
    
	    //to select multiple values from dropdown list
	    
	    System.out.println("TO SELECT MULTIPLE VALUE");
	    WebElement drop4=driver.findElement(By.xpath("//div[6]//select[1]"));
	    Select select444=new Select(drop4);
	    System.out.println("List of options under this drop down list:"+drop4.getText());

	    Thread.sleep(2000);
	    select444.selectByValue("1");
	    Thread.sleep(2000);
	    select444.selectByVisibleText("Appium");
	    Thread.sleep(2000);
	    select444.selectByIndex(3);
	    List<WebElement> allitems=select444.getAllSelectedOptions();
	    System.out.println("size:"+allitems.size());
	    
	    Thread.sleep(2000);

	    select444.deselectAll();
	    List<WebElement> allitems1=select444.getAllSelectedOptions();

	    System.out.println("size after update:"+allitems1.size());

	    driver.close();
    }
    
}

    
	    
	    