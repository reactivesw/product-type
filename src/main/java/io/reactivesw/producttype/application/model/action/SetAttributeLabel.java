package io.reactivesw.producttype.application.model.action;

import io.reactivesw.model.LocalizedString;
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
public class SetAttributeLabel implements UpdateAction {
  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Label.
   */
  @NotNull
  private LocalizedString label;

  /**
   * get update service name.
   * @return set_attribute_label
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_LABEL;
  }
}
