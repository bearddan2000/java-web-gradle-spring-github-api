package feature;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import org.junit.jupiter.api.Assertions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import example.model.Portal;
import example.model.Language;
import example.service.lang.*;

@SpringBootTest(classes=example.Main.class)
public class Lang {

  @Autowired
  LanguageServiceImpl langService;

  String test;

  Language langModel;

  Portal portalModel;

  @Given("I have repo name {string} with a language")
  public void langRepoName(String str) {
    test = str;
  }

  @When("I lookup language {string} in language table")
  public void langScanName(String lang) {
    if (langService == null) {
      System.out.println("langService is null");
      return ;
    } else if (lang == null || lang.equals("")) {
        System.out.println("lang is null or empty");
        return ;
    }
    langModel = langService.getByName(lang).get(0);
  }

  @Then("I check langModel not null")
  public void langModelNotNull() {
    portalModel = new Portal();

    if(langModel != null)
      portalModel.setLangId(langModel.getId().intValue());

    Assertions.assertTrue(langModel != null);
  }

  @And("I check portalModel langId is set")
  public void portalModelLangIdSet() {
     Assertions.assertTrue(portalModel.getLangId() > 0);
  }
}
