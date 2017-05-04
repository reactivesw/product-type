package io.reactivesw.producttype.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration for CORS.
 */
// TODO: 16/12/16 add for CORS, if somethings wrong, should remove
@Configuration
public class CorsConfiguration {
  /**
   * CORS configurer web mvc configurer.
   *
   * @return the web mvc configurer
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      /**
       * add Cors rule.
       * @param registry resigtry
       */
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
      }
    };
  }
}
