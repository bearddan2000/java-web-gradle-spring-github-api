package example.service.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.model.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LanguageServiceImpl implements LanguageService {

  @Autowired
  private example.repository.LangRepository dao;

  Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);

  @Override
  public Iterable<Language> getAll(){
    return dao.findAll();
  }

  @Override
  public List<Language> getByName(String value){

    List<Language> lst = new ArrayList<Language>();

    if(value == null || value == ""){
      logger.warn("value is empty");
      return null;
    }

    Iterable<example.model.Language> abl = getAll();

    for (Iterator<example.model.Language> itr = abl.iterator(); itr.hasNext(); ) {
      example.model.Language lang = itr.next();
      if (lang.getName().equals(value)) {
        lst.add(lang);
        break;
      }
    }

    return lst;
  }
}
