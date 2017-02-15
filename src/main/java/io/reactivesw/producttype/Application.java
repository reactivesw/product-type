package io.reactivesw.producttype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by Davis on 17/2/14.
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "io.reactivesw")
public class Application {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
