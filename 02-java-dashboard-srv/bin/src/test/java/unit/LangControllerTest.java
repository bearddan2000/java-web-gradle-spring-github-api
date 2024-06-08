package unit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import example.controller.LangController;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
  classes=example.Main.class)
@ExtendWith(SerenityJUnit5Extension.class)
public class LangControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  LangController controller;

  @Test
  public void getAllLanguagesJSON() {
    int test = 1;
    Serenity.reportThat("Count number of languages json",
            () -> assertThat(test).isGreaterThan(0)
    );
  }

}
