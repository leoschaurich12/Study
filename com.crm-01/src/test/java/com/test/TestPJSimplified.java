package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestPJSimplified  {

	private WebDriver driver;

	@Test
	public void testValidationLogin() throws InterruptedException {
		driver.manage().window().maximize();
		testLoginCRM();
		testValidationPasswordCRM();
		testLoginButton();
		getUserLogger();
		clickAddButton2();
		clickPersonType();
		testClientName ();
		testClickContinue();
		
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

	public void clickAddButton2() throws InterruptedException {

		WebElement testAddButton = driver.findElement(By.xpath("//*[@id=\"react-portal\"]/div/div/div/div[2]/div/div[1]/div[3]/div[1]/span/button"));
		testAddButton.click();
		Thread.sleep(5000);
	}

	public void clickAddButton() throws InterruptedException {

		WebElement testAddButton = driver.findElement(By.xpath("//*[@id=\"react-portal\"]/div/div/div/div[2]/div/div[1]/div[3]/div[1]/span/button"));
		testAddButton.click();
		Thread.sleep(5000);
	}

	public void clickPersonType() throws InterruptedException { //metodo abrir modal para para adionar a PJ 

		WebElement clickModalPersonType = driver.findElement(By.xpath("//*[@id=\"typeTxId\"]"));
		clickModalPersonType.click();
		WebElement textFieldBox3 = driver.findElement(By.id("typeTxId"));
		textFieldBox3.sendKeys("Pessoa Juridica");
		textFieldBox3.sendKeys(Keys.DOWN);
		textFieldBox3.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	public void testClientName () throws InterruptedException {

		WebElement testName = driver.findElement(By.id("name"));
		testName.sendKeys("Biro Biro Empresa de Esportivos Eirelli");
		WebElement testName2 = driver.findElement(By.id("name2"));
		testName2.sendKeys("Casa dos Esportes");
		WebElement CNPJ = driver.findElement(By.id("txId"));
		CNPJ.sendKeys("32165412000128");
		WebElement EmailName = driver.findElement(By.id("email"));
		EmailName.sendKeys("birobiro_casadosesportes@gmail.com");
		Thread.sleep(5000);
	}
		
	public void testClickContinue() throws InterruptedException {

		WebElement testClientButton = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/button[1]/span[1]/div/span"));
		testClientButton.click();
		Thread.sleep(5000);
	}
		
	@BeforeTest
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/voalle/drivers/chromedriver");
		driver = new ChromeDriver ();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://crm.erpvoalle.com.br/people_simplified");

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}

}
