package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Money attribute type.
 */
public final class MoneyAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private MoneyAbstractAttributeType() {
    super();
  }

  /**
   * build MoneyAbstractAttributeType from json data.
   *
   * @return MoneyAbstractAttributeType
   */
  @JsonIgnore
  public static MoneyAbstractAttributeType build() {
    return new MoneyAbstractAttributeType();
  }
}
