package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Localized string attribute type.
 */
public final class LocalizedStringAbstractAttributeType extends AbstractAttributeType {
  /**
   * private constructor.
   */
  private LocalizedStringAbstractAttributeType() {
    super();
  }

  /**
   * build LocalizedStringAbstractAttributeType from json data.
   *
   * @return LocalizedStringAbstractAttributeType
   */
  @JsonIgnore
  public static LocalizedStringAbstractAttributeType build() {
    return new LocalizedStringAbstractAttributeType();
  }
}
