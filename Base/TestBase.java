package com.Pixelogic.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		prop= new Properties();
		FileInputStream ip=new FileInputStream("src/main/java/com/Pixelogic/Config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void Initialzation () {

		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if (prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.geckodriver", "drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
	}
	
	public void OpenUrl(String Url) {
		driver.manage().window().maximize();
		driver.navigate().to(Url);
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
}

