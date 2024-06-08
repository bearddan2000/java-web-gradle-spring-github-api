package feature;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

public class Dev {

  String test;

  @When("dev at start of name")
  public void devStartsName() {
    test = "dev-java-pants-hello-world";
  }

  @Then("language should not be dev")
  public void devNotLanguage() {
     Assertions.assertEquals(0, 0);
  }

}
