package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public LoginPage open() {
		getDriver().get("https://crm.erpvoalle.com.br/users/login"); //página referente ao CRM
		return this;		
	}

	public LoginPage setUsername(String username) {
		WebElement tfUsername = getDriver().findElement(By.id("UserLogin"));
		tfUsername.sendKeys(username);
		return this;
	}

	public LoginPage setPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.id("UserPassword2"));
		tfPass.sendKeys(pass);
		return this;
	}

}




