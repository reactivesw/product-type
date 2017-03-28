package io.reactivesw.producttype.application.model.attributes;

import io.reactivesw.producttype.application.model.EnumValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The Enum attribute type.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public final class EnumAttributeType extends AbstractAttributeType {
  /**
   * enum value list.
   */
  private List<EnumValue> values;
}
