package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetDescription implements UpdateAction {

  /**
   * The Description.
   */
  private String description;

  /**
   * get update service name.
   * @return set_description
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_DESCRIPTION;
  }
}
