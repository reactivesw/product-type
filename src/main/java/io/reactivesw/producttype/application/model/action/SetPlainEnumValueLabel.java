package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.PlainEnumValue;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetPlainEnumValueLabel implements UpdateAction {

  /**
   * The Attribute name.
   */
  private String attributeName;

  /**
   * The New value.
   */
  private PlainEnumValue newValue;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_ENUM_VALUE_LABEL;
  }
}
