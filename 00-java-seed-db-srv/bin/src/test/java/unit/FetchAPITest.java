package unit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class FetchAPITest {

  String res = null;

  @BeforeEach
  public void callAPI()
  {
    String url = "https://api.github.com/users/bearddan2000/repos?per_page=100&page=1";
    res = example.Helper.getRepoResponse(url);
  }

  @Test
  public void getResponseContainsName() {
    String test = res;
    String expected = "name";
    Serenity.reportThat("Repo Response Contains Name",
            () -> assertThat(test).contains(expected)
    );
  }

  @Test
  public void getResponseContainsDescription() {
    String test = res;
    String expected = "description";
    Serenity.reportThat("Repo Response Contains Description",
            () -> assertThat(test).contains(expected)
    );
  }

  @Test
  public void getResponseContainsUrl() {
    String test = res;
    String expected = "clone_url";
    Serenity.reportThat("Repo Response Contains Url",
            () -> assertThat(test).contains(expected)
    );
  }
}
