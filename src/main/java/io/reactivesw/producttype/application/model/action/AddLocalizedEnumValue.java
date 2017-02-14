package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class AddLocalizedEnumValue implements UpdateAction {
  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Value.
   */
  @NotNull
  private LocalizedEnumValue value;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.ADD_LOCALIZED_ENUM_VALUE;
  }
}
