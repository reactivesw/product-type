package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Date time attribute type.
 */
public final class DateTimeAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private DateTimeAbstractAttributeType() {
    super();
  }

  /**
   * build DateTimeAbstractAttributeType from json data.
   *
   * @return DateTimeAbstractAttributeType
   */
  @JsonIgnore
  public static DateTimeAbstractAttributeType build() {
    return new DateTimeAbstractAttributeType();
  }
}
