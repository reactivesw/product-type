package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Localized string attribute type.
 */
public final class LocalizedStringAttributeType extends AbstractAttributeType {
  /**
   * Private constructor.
   */
  private LocalizedStringAttributeType() {
    super();
  }

  /**
   * Build LocalizedStringAttributeType from json data.
   *
   * @return LocalizedStringAttributeType
   */
  @JsonIgnore
  public static LocalizedStringAttributeType build() {
    return new LocalizedStringAttributeType();
  }
}
