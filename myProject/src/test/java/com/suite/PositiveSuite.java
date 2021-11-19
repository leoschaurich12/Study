package com.suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.test.CacheTest;
import com.test.navegationTabsTest;
import com.test.WebElementsTest;

@RunWith(Categories.class)
@SuiteClasses({CacheTest.class, navegationTabsTest.class, WebElementsTest.class})

public class PositiveSuite {

}

