package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The String attribute type.
 */
public final class StringAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private StringAbstractAttributeType() {
    super();
  }

  /**
   * build from json data.
   *
   * @return StringAbstractAttributeType
   */
  @JsonCreator
  public static StringAbstractAttributeType build() {
    return new StringAbstractAttributeType();
  }
}
