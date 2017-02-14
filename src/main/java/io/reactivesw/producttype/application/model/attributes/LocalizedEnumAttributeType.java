package io.reactivesw.producttype.application.model.attributes;

import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public final class LocalizedEnumAttributeType extends AttributeTypeBase {
  private List<LocalizedEnumValue> values;
}
