package stepDefinitions;

import net.serenitybdd.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class JokeSerenityTest {

    @Steps
    private JokeSteps jokeSteps;

    @Test
    public void jokeTest() throws IOException {
        jokeSteps.getJokeFromAPI();
    }
}
