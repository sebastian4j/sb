package cl.sebastian.uno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.sebastian.uno.repositories.BookRepository;

@Controller
// NO RestController, retorna el nombre del html
public class BookController {
  private final BookRepository br;

  public BookController(final BookRepository br) {
    super();
    this.br = br;
  }

  @GetMapping("/books")
  public String getBooks(final Model model) {
    model.addAttribute("books", br.findAll());
    return "books";
  }
}
