package io.reactivesw.producttype.application.model.attributes;

import io.reactivesw.producttype.application.model.LocalizedEnumValue;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The Localized enum attribute type.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public final class LocalizedEnumAbstractAttributeType extends AbstractAttributeType {
  /**
   * Localized Enum Value list.
   */
  private List<LocalizedEnumValue> values;
}
