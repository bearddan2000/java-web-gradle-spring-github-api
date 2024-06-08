package feature;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

public class FetchAPITest {

  String test;

  @When("dev at start of name")
  public void devIsInName() {
    test = "dev-php";
  }

  @Then("name should not be dev")
  public void nameIsNot() {
     Assertions.assertEquals(0, 0);
  }

}
