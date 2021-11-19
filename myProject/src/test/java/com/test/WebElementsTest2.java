package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class WebElementsTest2 {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/voalle/drivers/chromedriver");
		driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://crm.erpvoalle.com.br/people_simplified");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testValidationLogin() throws InterruptedException {

		testLoginCRM();
		testValidationPasswordCRM();
		testLoginButton();
		getUserLogger();

	}	

	public void testLoginCRM () throws InterruptedException {

		WebElement textFieldBox1 = driver.findElement(By.id("UserLogin"));

		textFieldBox1.sendKeys("syntesis");

		assertEquals("syntesis", textFieldBox1.getAttribute("value"));

		Thread.sleep(5000);
	}
	public void testValidationPasswordCRM() throws InterruptedException {

		WebElement textFieldBox1 = driver.findElement(By.id("UserPassword2"));

		textFieldBox1.sendKeys("332211");

		assertEquals("332211", textFieldBox1.getAttribute("value"));

		Thread.sleep(5000);
	}

	public void testLoginButton()  throws InterruptedException {
		WebElement textFieldBox1 = driver.findElement(By.id("ButtonLogin"));

		assertEquals("entrar", textFieldBox1.getText());
		textFieldBox1.click();

		Thread.sleep(10000);
	}

	public void getUserLogger() {

		WebElement voalleImage = driver.findElement(By.xpath("//*[@id=\"neo-logo\"]/img"));

		assertTrue(voalleImage.isEnabled());
	}
}

