package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Type for product attributes which only allows {@code true} or {@code false} as value.
 */
public final class BooleanAbstractAttributeType extends AbstractAttributeType {

  /**
   * private constructor.
   */
  private BooleanAbstractAttributeType() {
    super();
  }

  /**
   * build BooleanAbstractAttributeType from json data.
   *
   * @return BooleanAbstractAttributeType
   */
  @JsonCreator
  public static BooleanAbstractAttributeType build() {
    return new BooleanAbstractAttributeType();
  }
}
