package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "steps",                           
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    plugin = {"pretty", "html:target/relatorio-teste.html"}
)
public class RunnerTest {
    
}