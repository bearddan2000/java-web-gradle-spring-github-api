package example.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

  @GetMapping("/")
  public String home1(Model model) {

    model.addAttribute("lst", new String[]{"java", "groovy"});
    return "/index";
  }

  @GetMapping("/403")
  public String error403() {
      return "/error/403";
  }
}
