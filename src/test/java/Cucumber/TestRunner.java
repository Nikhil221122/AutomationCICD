package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber", // Path to your feature files
		glue = "NikhilProjects.StepDefinitions", // Path to your step definitions
		monochrome = true, tags = "@ErrorValidation", plugin = { "pretty", "html:target/cucumber-reports" } // Optional,
																											// for
																											// reporting
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
