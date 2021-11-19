package com.core;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public abstract class BaseTest {


	@AfterTest
	public void tearDown() throws IOException {

		DriverFactory.killDriver();
	}
}


