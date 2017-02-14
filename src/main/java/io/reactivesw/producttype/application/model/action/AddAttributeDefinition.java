package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.AttributeDefinitionDraft;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/8.
 */
@Getter
@Setter
public class AddAttributeDefinition implements UpdateAction {
  /**
   * The Attribute.
   */
  private AttributeDefinitionDraft attribute;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.ADD_ATTRIBUTE_DEFINITION;
  }
}
