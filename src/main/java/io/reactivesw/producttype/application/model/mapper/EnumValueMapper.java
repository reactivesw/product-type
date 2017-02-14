package io.reactivesw.producttype.application.model.mapper;


import io.reactivesw.producttype.application.model.EnumValue;
import io.reactivesw.producttype.application.model.PlainEnumValue;

/**
 * Created by Davis on 16/12/12.
 */
public final class EnumValueMapper {
  public static EnumValue modelToEntity(PlainEnumValue plainEnumValue) {
    return new EnumValue(plainEnumValue.getKey(), plainEnumValue.getLabel());
  }
}
