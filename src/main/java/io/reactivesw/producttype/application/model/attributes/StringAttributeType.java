package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The String attribute type.
 */
public final class StringAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private StringAttributeType() {
    super();
  }

  /**
   * build from json data.
   *
   * @return StringAttributeType
   */
  @JsonCreator
  public static StringAttributeType build() {
    return new StringAttributeType();
  }
}
