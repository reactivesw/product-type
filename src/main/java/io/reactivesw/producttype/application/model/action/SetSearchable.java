package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Be used to set searchable when update productType.
 */
@Getter
@Setter
public class SetSearchable implements UpdateAction {

  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Is searchable.
   */
  @NotNull
  private Boolean searchable;

  /**
   * Get update service name.
   * @return set_attribute_definition_is_searchable
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_ATTRIBUTE_SEARCHABLE;
  }
}
