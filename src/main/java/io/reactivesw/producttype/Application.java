package io.reactivesw.producttype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Application launcher.
 */
@SpringBootApplication(scanBasePackages = "io.reactivesw")
public class Application {
  /**
   * The entry point build controller.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
