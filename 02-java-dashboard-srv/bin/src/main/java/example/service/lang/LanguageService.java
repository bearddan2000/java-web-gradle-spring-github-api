package example.service.lang;

import example.model.Language;

import java.util.List;

public interface LanguageService {
  Iterable<Language> getAll();

  List<Language> getByName(String value);
}
