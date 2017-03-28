package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The type Set attribute type.
 */
public final class SetAbstractAttributeType extends AbstractAttributeType {
  /**
   * attribute type.
   */
  private transient AttributeType elementType;

  /**
   * build from json data.
   *
   * @param elementType SetAbstractAttributeType
   */
  @JsonCreator
  private SetAbstractAttributeType(final AttributeType elementType) {
    super();
    this.elementType = elementType;
  }

  /**
   * Gets element type.
   *
   * @return the element type
   */
  public AttributeType getElementType() {
    return elementType;
  }

  /**
   * build from AttributeType.
   *
   * @param elementType the element type
   * @return the set attribute type
   */
  @JsonIgnore
  public static SetAbstractAttributeType build(final AttributeType elementType) {
    return new SetAbstractAttributeType(elementType);
  }
}
