package unit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class HelperTest {

    @Test
    public void getResponseLength() {
      String url = "https://api.github.com/users/bearddan2000/repos?per_page=100&page=1";
      int test = example.Helper.getRepoResponse(url).length();
      int expected = 1;
      Serenity.reportThat("Repo Response Length",
              () -> assertThat(test).isGreaterThan(expected)
      );
    }

    @Test
    public void getResponseCountContains() {
      String url = "https://api.github.com/users/bearddan2000";
      String test = example.Helper.getRepoResponse(url);
      String expected = "public_repos";
      Serenity.reportThat("Repo Count Contains",
              () -> assertThat(test).contains(expected)
      );
    }

    @Test
    public void getCountGreaterThanZero() {
      String url = "https://api.github.com/users/bearddan2000";
      int test = example.Helper.getRepoCount(url);
      int expected = 1;
      Serenity.reportThat("Repo Count Return Value",
              () -> assertThat(test).isGreaterThan(expected)
      );
    }

    @Test
    public void getResponseISNotNull() {
      String url = "https://api.github.com/users/bearddan2000/repos?per_page=100&page=1";
      String test = example.Helper.getRepoResponse(url);
      Serenity.reportThat("Repo Response Is Not Null",
              () -> assertThat(test).isNotNull()
      );
    }
}
