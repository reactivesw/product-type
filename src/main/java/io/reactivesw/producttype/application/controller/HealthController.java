package io.reactivesw.producttype.application.controller;

import static io.reactivesw.producttype.infrastructure.Router.PRODUCT_TYPE_HEALTH_CHECK;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to check service health.
 */
@RestController
public class HealthController {
  /**
   * Log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(HealthController.class);

  /**
   * Service name.
   */
  private transient String serviceName;

  /**
   * Instantiates a new Health controller.
   *
   * @param serviceName the service name
   */
  public HealthController(@Value("${spring.application.name}")String serviceName) {
    this.serviceName = serviceName;
  }

  /**
   * This api is used for health check.
   *
   * @return service name.
   */
  @GetMapping(PRODUCT_TYPE_HEALTH_CHECK)
  public String healthCheck() {
    LOG.info("Enter.");

    Long currentTime=System.currentTimeMillis();
    LOG.info("Exit. Service name: {}, current time: {}.", serviceName,
        currentTime);
    return serviceName + ", system time: " + currentTime;

  }
}
