package RelearnPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Paralleltest {

	WebDriver driver1;
	WebDriver driver2;

	@Test

	public void PT1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:\\Softwares\\chromedriver.exe");
		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://www.youtube.com/watch?v=DusDZQcgPFE");
		Thread.sleep(5000);
		driver1.quit();


	}
	@Test

	public void PT2() throws InterruptedException
	{
		driver2 = new FirefoxDriver();
		driver2.manage().window().maximize();
		driver2.get("https://www.google.com");
		Thread.sleep(5000);
		driver2.quit();


	}


}
