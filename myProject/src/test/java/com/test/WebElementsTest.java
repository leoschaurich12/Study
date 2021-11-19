package com.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select; 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class WebElementsTest {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/voalle/drivers/chromedriver");

		driver = new ChromeDriver ();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://crm.erpvoalle.com.br/users/login");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testValidationName() {

		WebElement textFieldBox1 = driver.findElement(By.name("UserLogin"));

		textFieldBox1.sendKeys("Syntesis");

		assertEquals("Syntesis", textFieldBox1.getAttribute("value"));
	}

	@Ignore
	@Test
	public void testValidateDisable() {
		WebElement textFieldBox1 = driver.findElement(By.name("txtbox1"));
		WebElement textFieldBox2 = driver.findElement(By.name("txtbox2"));

		assertTrue(textFieldBox1.isEnabled());
		assertFalse(textFieldBox2.isEnabled());
	}
	@Ignore
	@Test
	public void testValidateRadioButton() throws InterruptedException {
		List<WebElement> radios = driver.findElements(By.name("radioGroup1"));

		assertEquals("O tamanho não está de acordo", radios.size());

		for (WebElement e: radios) {
			if (e.getAttribute ("value").equals("Radio Button 3 selecionado"));{
				e.click();
			}

		}	
		Thread.sleep(5000);
		assertTrue("Solução 3 deveria estar selecionada" , radios.get(2).isSelected());
		assertFalse("Posição 4 não deveria estar selecionada" , radios.get(3).isSelected());
		assertFalse("Posição 1 não deveria estar selecionada" , radios.get(0).isSelected());
		//	assertFalse("Posição 2 não deveria estar selecionada" , radios.get(1).isSelected());		
	}

	@Ignore

	@Test
	public void testValidateCheckBox() throws InterruptedException {

		List<WebElement> listChecks = driver.findElements(By.name("chkbox"));

		assertEquals("Tamanho deveria ser 4" , 4, listChecks.size());


		for(WebElement el: listChecks) {
			if ((el.getAttribute("value").equals("Check Box 3 selecionado")) ||
					(el.getAttribute("value").equals("Check Box 4 selecionado")))	 {
				el.click(); // || significa "ou", e lembrando que && é o conectivo "e".
			}

		}
		assertTrue("Posição 3 deveria estar selecionada!" , listChecks.get(2).isSelected());
		assertFalse("Posição 4 não deveria estar selecionada!" , listChecks.get(3).isSelected());
	}

	@Ignore

	@Test	
	public void testValidateSingleSelect() throws InterruptedException{

		WebElement dropSingle = driver.findElement(By.name("dropdownList"));

		Select selectSingle = new Select(dropSingle);
		selectSingle.selectByIndex(0);
		selectSingle.selectByVisibleText("Item 7");

		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
	}

	@Ignore
	@Test
	public void testValidateMultiSelect() throws InterruptedException {
		WebElement dropMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selectMulti = new Select(dropMulti);


		selectMulti.selectByVisibleText("Item 5");
		selectMulti.selectByVisibleText("Item 8");
		selectMulti.selectByVisibleText("Item 9");

		assertEquals("Deveriam ter 3 elementos" , 2,  selectMulti.getAllSelectedOptions().size());

		assertEquals("Item 5", selectMulti.getAllSelectedOptions().get(0).getText());
		assertEquals("Item 8", selectMulti.getAllSelectedOptions().get(1).getText());
		assertEquals("Item 9", selectMulti.getAllSelectedOptions().get(2).getText());

		Thread.sleep(3000);

		selectMulti.deselectByVisibleText("Item 8");

		Thread.sleep(3000);
		assertEquals("Deveriam ter 2 elementos" , 2, selectMulti.getAllSelectedOptions().size());

		assertEquals("Item 5", selectMulti.getAllSelectedOptions().get(1).getText());
		assertEquals("Item 9", selectMulti.getAllSelectedOptions().get(2).getText());

		selectMulti.deselectAll();

	}
	@Ignore

	@Test
	public void testValidateIFrames() throws InterruptedException {

		driver.switchTo().frame("iframe_b");


		//WebElement btnAllow = driver.findElement(By.cssSelector("cc-color-override-1832638131 > div > a.cc-btn.cc-ALLOW"));
		//	assertTrue(btnAllow.isDisplayed());
		//btnAllow.click();

		List<WebElement> btnAllow = driver.findElements(By.cssSelector("a.cc-btn.cc-ALLOW"));
		assertTrue(btnAllow.get(1).isDisplayed());

		btnAllow.get(1).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("iframe d");

		WebElement btnMenu = driver.findElement(By.cssSelector(""));
		btnMenu.click();

		WebElement tfSelenium = driver.findElement(By.cssSelector(""));
		tfSelenium.sendKeys("Antonio");
		assertEquals("Antonio" , tfSelenium.getAttribute("Value"));
	}

	@Ignore
	@Test
	public void testValidatedAlerts() {

		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();

		Alert alert = driver.switchTo().alert();


		assertEquals("Eu sou um alerta!" , alert.getText());

		alert.accept();

		WebElement btnConfirm = driver.findElement(By.name("confirmbtn"));
		btnConfirm.click();

		Alert alert2 = driver.switchTo().alert();
		assertEquals("Pressione um botão!" , alert2.getText());
		alert2.dismiss();
	}

}



