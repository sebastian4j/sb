package cl.sebastian.uno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.sebastian.uno.repositories.AuthorRepository;

@Controller
public class AuthorController {
  private final AuthorRepository ar;

  public AuthorController(final AuthorRepository ar) {
    super();
    this.ar = ar;
  }

  @GetMapping("/authors")
  public String getAuthors(final Model model) {
    model.addAttribute("authors", ar.findAll());
    return "authors";
  }
}
