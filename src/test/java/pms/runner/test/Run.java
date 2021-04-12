package pms.runner.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
				 features = "src/test/resources/features", 
				 glue = { "pms/cucumber/test" }, 
				 monochrome = true,
				 publish = true)
public class Run {

}
