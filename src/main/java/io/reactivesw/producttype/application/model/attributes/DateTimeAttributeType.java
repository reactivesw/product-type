package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Date time attribute type.
 */
public final class DateTimeAttributeType extends AbstractAttributeType {
  /**
   * Private constructor.
   */
  private DateTimeAttributeType() {
    super();
  }

  /**
   * Build DateTimeAttributeType from json data.
   *
   * @return DateTimeAttributeType
   */
  @JsonIgnore
  public static DateTimeAttributeType build() {
    return new DateTimeAttributeType();
  }
}
