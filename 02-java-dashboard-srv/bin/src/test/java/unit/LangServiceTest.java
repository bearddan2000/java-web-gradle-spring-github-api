package unit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import example.service.lang.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes=example.Main.class)
@ExtendWith(SerenityJUnit5Extension.class)
public class LangServiceTest {

  @Autowired
  LanguageServiceImpl langService;

  @Test
  public void getAllCount() {
    Iterable<example.model.Language> abl = langService.getAll();
    List<example.model.Language> lst = new ArrayList<example.model.Language>();
    for (Iterator<example.model.Language> itr = abl.iterator(); itr.hasNext(); ) {
      lst.add(itr.next());
    }
    int test = lst.size();
    Serenity.reportThat("Count number of languages returned",
            () -> assertThat(test).isGreaterThan(0)
    );
  }
  @Test
  public void getByName() {
    String test = "java";
    List<example.model.Language> lst = langService.getByName(test);
    
    Serenity.reportThat("Check languages exists",
            () -> assertThat(lst.size()).isGreaterThan(0)
    );
  }

}
