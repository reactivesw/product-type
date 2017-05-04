package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Type for product attributes which only allows {@code true} or {@code false} as value.
 */
public final class BooleanAttributeType extends AbstractAttributeType {

  /**
   * Private constructor.
   */
  private BooleanAttributeType() {
    super();
  }

  /**
   * Build BooleanAttributeType from json data.
   *
   * @return BooleanAttributeType
   */
  @JsonCreator
  public static BooleanAttributeType build() {
    return new BooleanAttributeType();
  }
}
