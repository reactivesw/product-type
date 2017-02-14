package io.reactivesw.producttype.application.model.attributes;

import io.reactivesw.producttype.application.model.EnumValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public final class EnumAttributeType extends AttributeTypeBase {
  private List<EnumValue> values;
}
