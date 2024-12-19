package TestRunnerPkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/features"},
		glue = {"StepDefinations"},
		plugin = {"pretty", "html:target/cucumber-reports"},
		dryRun = false,
		monochrome = true
		
		)

public class TestRunner {

}
