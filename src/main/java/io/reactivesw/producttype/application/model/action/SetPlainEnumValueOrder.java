package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.PlainEnumValue;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetPlainEnumValueOrder implements UpdateAction {

  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Values.
   */
  @NotNull
  @Size(min = 1)
  private List<PlainEnumValue> values;

  /**
   * get update service name.
   * @return set_enum_value_order
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_ENUM_VALUE_ORDER;
  }
}
