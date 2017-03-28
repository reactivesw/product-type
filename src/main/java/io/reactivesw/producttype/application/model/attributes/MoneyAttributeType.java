package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Money attribute type.
 */
public final class MoneyAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private MoneyAttributeType() {
    super();
  }

  /**
   * build MoneyAttributeType from json data.
   *
   * @return MoneyAttributeType
   */
  @JsonIgnore
  public static MoneyAttributeType build() {
    return new MoneyAttributeType();
  }
}
