package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Browsertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
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
	}

}
