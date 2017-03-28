package io.reactivesw.producttype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Davis on 17/2/14.
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
