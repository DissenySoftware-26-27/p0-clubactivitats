package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"test/features/"},
    glue = {"steps"},
    plugin = {"pretty", "html:target/cucumber.html"}
)
class Runner {}