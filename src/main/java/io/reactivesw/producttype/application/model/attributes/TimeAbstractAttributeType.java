package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Time attribute type.
 */
public final class TimeAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private TimeAbstractAttributeType() {
    super();
  }

  /**
   * build a new object.
   *
   * @return TimeAbstractAttributeType
   */
  @JsonIgnore
  public static TimeAbstractAttributeType build() {
    return new TimeAbstractAttributeType();
  }
}
