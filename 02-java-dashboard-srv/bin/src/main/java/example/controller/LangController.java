package example.controller;

import example.model.Language;
import example.repository.LangRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lang")
public class LangController extends AbstractController<Language> {
	public LangController(LangRepository repo){
		super(repo);
	}
}
