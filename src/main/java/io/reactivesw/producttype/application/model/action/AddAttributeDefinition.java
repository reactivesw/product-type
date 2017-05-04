package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.AttributeDefinitionDraft;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Be used to add attributeDefinition when update productType.
 */
@Getter
@Setter
public class AddAttributeDefinition implements UpdateAction {
  /**
   * The Attribute.
   */
  private AttributeDefinitionDraft attribute;

  /**
   * Return update service name.
   *
   * @return add_attribute_definition
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.ADD_ATTRIBUTE_DEFINITION;
  }
}
