package io.reactivesw.producttype.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 17/2/21.
 */
@RestController
@Configuration
public class IndexController {

  /**
   * service name.
   */
  @Value("${spring.controller.name}")
  private String serviceName;

  /**
   * this api is used for health check.
   *
   * @return service name.
   */
  @GetMapping("/")
  public String index() {
    return serviceName + ", system time: " + System.currentTimeMillis();
  }
}
