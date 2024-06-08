package unit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class MainTest {

  @Test
  public void getRoundedCount() {
    final int raw = 2400;
    int test = example.Main.roundToNearesttHundred(raw);
    int expected = 25;
    Serenity.reportThat("Repo Rounded Count",
            () -> assertThat(test).isEqualTo(expected)
    );
  }

}
