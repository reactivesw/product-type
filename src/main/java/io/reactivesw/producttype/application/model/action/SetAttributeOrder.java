package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.attributes.AttributeDefinitionView;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Be used to set attributeOrder when update productType.
 */
@Getter
@Setter
public class SetAttributeOrder implements UpdateAction {
  /**
   * The Attributes.
   */
  @NotNull
  @Size(min = 1)
  private List<AttributeDefinitionView> attributes;

  /**
   * Get update service name.
   * @return set_attribute_order
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_ATTRIBUTE_ORDER;
  }
}
