package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimplifiedPersonInteracao {

	private WebDriver driver;
	
	@Test
	public void testValidationLogin() throws InterruptedException {
		driver.manage().window().maximize();
		
		testLoginCRM();
		testValidationPasswordCRM();
		testLoginButton();
		getUserLogger();
		getFilterAll ();
		clickAfterFilter ();
		validateColor();
		clickUpdate(); 
	}	

	public void testLoginCRM () throws InterruptedException {

		WebElement textFieldBox1 = driver.findElement(By.id("UserLogin"));
		textFieldBox1.sendKeys("syntesis");
		assertEquals("syntesis", textFieldBox1.getAttribute("value"));
		
	}

	public void testValidationPasswordCRM() throws InterruptedException {

		WebElement textFieldBox1 = driver.findElement(By.id("UserPassword2"));
		textFieldBox1.sendKeys("332211");
		assertEquals("332211", textFieldBox1.getAttribute("value"));
		
	}

	public void testLoginButton()  throws InterruptedException {

		WebElement textFieldBox1 = driver.findElement(By.id("ButtonLogin"));
		assertEquals("entrar", textFieldBox1.getText());
		textFieldBox1.click();
		
	}
	public void getUserLogger() {

		WebElement voalleImage = driver.findElement(By.xpath("//*[@id=\"neo-logo\"]/img"));

		assertTrue(voalleImage.isEnabled());
	}
	public void getFilterAll () throws InterruptedException { //escrevendo "linux"no campo de pesquisa
		WebElement textFieldBox5 = driver.findElement(By.id("filterAll"));
		textFieldBox5.sendKeys("linux");
		assertEquals("linux", textFieldBox5.getAttribute("value"));
		Thread.sleep(2000);
	}

	public void clickAfterFilter () throws InterruptedException {
		WebElement Box10 = driver.findElement
				(By.xpath("//*[@id=\"react-portal\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[1]/span/span[1]/input"));
		Box10.click();
		Thread.sleep(3000);
	}
	public void validateColor() throws InterruptedException {
		WebElement campo1 = driver.findElement(By.xpath("//*[@id=\"react-portal\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div"));
		Color elementColor = Color.fromString((campo1).getCssValue("background-color"));
		assertEquals(elementColor+"", "Color: rgba(250, 82, 57, 1)");
		Thread.sleep(3000);
	}
	
	public void clickUpdate() throws InterruptedException {
		WebElement Button10 = driver.findElement
				(By.xpath("//*[@id=\"react-portal\"]/div/div/div/div[2]/div/div[1]/div[1]/span/button"));
		Button10.click();
		Thread.sleep(10000);
	}
	
	@BeforeTest
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/voalle/drivers/chromedriver");
		driver = new ChromeDriver ();
		driver.manage().window().setSize(new Dimension(1366, 760));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://crm.erpvoalle.com.br/people_simplified");

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}

}

