package com.netcore.android;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report"}
)
public class android_RunTest extends AbstractTestNGCucumberTests {
}
