package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Be used to add localizedEnumValue when update productType.
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

  /**
   * Get update service name.
   *
   * @return add_localized_enum_value
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.ADD_LOCALIZED_ENUM_VALUE;
  }
}
