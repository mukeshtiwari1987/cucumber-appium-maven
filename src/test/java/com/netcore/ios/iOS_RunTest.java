package com.netcore.ios;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report"}
)
public class iOS_RunTest extends AbstractTestNGCucumberTests {
}
