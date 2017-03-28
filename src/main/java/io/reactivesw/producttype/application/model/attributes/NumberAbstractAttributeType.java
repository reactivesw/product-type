package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Number attribute type.
 */
public final class NumberAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private NumberAbstractAttributeType() {
    super();
  }

  /**
   * build NumberAbstractAttributeType from json data.
   *
   * @return NumberAbstractAttributeType
   */
  @JsonIgnore
  public static NumberAbstractAttributeType build() {
    return new NumberAbstractAttributeType();
  }
}
