package com.test;

import org.junit.Test;

import com.core.BaseTest;
import com.page.LoginPage;
import com.page.MainPage;



public class LoginTest extends BaseTest{
	private LoginPage login;
	private MainPage main;


	@Test 
	public void testValidLogin() {
		login = new LoginPage();
		login.open();
		login.setEnvironment("trindade");
		login.setUsername("aluno01");
		login.setPassword("123456");

		main = new MainPage();

		main = login.submitLogin();

		main.clickAvatar();

	}

}

