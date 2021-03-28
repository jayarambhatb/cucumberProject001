package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/Features"	, 
	glue ={"src.test.java.StepDefinitions"},
	monochrome=true

		)
public class TestRunner {

}
