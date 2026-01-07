package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Browsertest {
	@Test
	public void main() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

		WebDriver driver = new ChromeDriver(options);
		
		// Create ChromeOptions object
//        ChromeOptions options = new ChromeOptions();
//
//        // Set headless mode (required for Linux CI / no GUI environments)
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");              // Required for some Linux CI servers
//        options.addArguments("--disable-dev-shm-usage");   // Fixes shared memory issues
//
//        // Initialize ChromeDriver with options
//        WebDriver driver = new ChromeDriver(options);

		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select s = new Select(driver.findElement(By.name("fromPort")));
		s.selectByVisibleText("Boston");
		Select s1 = new Select(driver.findElement(By.name("toPort")));
		s1.selectByVisibleText("Berlin");
		driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();
		int tr = driver.findElements(By.xpath("/html/body/div[2]/table/tbody/tr")).size();
		int c = driver.findElements(By.xpath("/html/body/div[2]/table/thead/tr/th")).size();		
		Double max=0.0;
		for (int i = 1; i <= tr; i++) {
			String a = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + i + "]/td[6]")).getText();
			String n = a.replace("$", "");
			Double d=Double.parseDouble(n);
			Double[]d1=new Double[tr];
			d1[i-1]=d;
			if(d1[i-1]>max) {
				max=d1[i-1];
			}	
		}
		System.out.println("Max :"+max);
		System.out.println("PASSED WITH CI");

	}

}
