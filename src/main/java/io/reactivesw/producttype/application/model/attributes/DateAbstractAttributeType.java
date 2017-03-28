package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Date attribute type.
 */
public final class DateAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private DateAbstractAttributeType() {
    super();
  }

  /**
   * build DateAbstractAttributeType from json data.
   *
   * @return DateAbstractAttributeType
   */
  @JsonIgnore
  public static DateAbstractAttributeType build() {
    return new DateAbstractAttributeType();
  }
}
