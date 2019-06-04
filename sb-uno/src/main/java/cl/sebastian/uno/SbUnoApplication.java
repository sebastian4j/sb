package cl.sebastian.uno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SbUnoApplication {
  @GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
  public String saludo() {
    return "hola";
  }

  public static void main(final String[] args) {
    SpringApplication.run(SbUnoApplication.class, args);
  }

}
