package io.reactivesw.producttype.infrastructure.util;

import org.springframework.data.domain.AuditorAware;

/**
 * AuditorAware for ZoneDateTime.
 */
public class ZonedDateTimeAuditorAware implements AuditorAware<String> {

  /**
   * Get current auditor.
   *
   * @return null
   */
  @Override
  public String getCurrentAuditor() {
    return null;
  }
}