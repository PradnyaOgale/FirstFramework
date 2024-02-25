package First_Framework;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.First_Framework.stepdefinitions", 
dryRun = false, plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class TestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
	return super.scenarios();
	}

	
}
