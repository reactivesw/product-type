package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Time attribute type.
 */
public final class TimeAttributeType extends AbstractAttributeType {
  /**
   * Private constructor.
   */
  private TimeAttributeType() {
    super();
  }

  /**
   * Build a new object.
   *
   * @return TimeAttributeType
   */
  @JsonIgnore
  public static TimeAttributeType build() {
    return new TimeAttributeType();
  }
}
