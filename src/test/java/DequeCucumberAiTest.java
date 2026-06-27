import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/bdd-tdd-cuke-ai",
        glue = "stepsAi",
        plugin = "pretty",
        monochrome = true
)
public class DequeCucumberAiTest {
}
