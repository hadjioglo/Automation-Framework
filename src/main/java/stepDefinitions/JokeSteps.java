package stepDefinitions;

import io.cucumber.java.en.Given;

import java.io.IOException;

public class JokeSteps {

    @Given("get one joke from the server")
    public void getJokeFromAPI() throws IOException {
        TestJokesSerenitySteps testJokesSerenitySteps = new TestJokesSerenitySteps();
        testJokesSerenitySteps.testJoke();
    }
}
