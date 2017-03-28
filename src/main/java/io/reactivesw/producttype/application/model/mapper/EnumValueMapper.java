package io.reactivesw.producttype.application.model.mapper;

import io.reactivesw.producttype.application.model.EnumValue;
import io.reactivesw.producttype.application.model.PlainEnumValue;

/**
 * Enum Mapper Class.
 */
public final class EnumValueMapper {

  /**
   * Instantiates a new Enum value mapper.
   */
  private EnumValueMapper() {}

  /**
   * convert PlainEnumValue to EnumValue.
   *
   * @param plainEnumValue the PlainEnumValue
   * @return the EnumValue
   */
  public static EnumValue toEntity(PlainEnumValue plainEnumValue) {
    return new EnumValue(plainEnumValue.getKey(), plainEnumValue.getLabel());
  }
}
