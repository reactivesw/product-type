package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Be used to set key when update productType.
 */
@Getter
@Setter
public class SetKey implements UpdateAction {
  /**
   * The Key.
   */
  private String key;

  /**
   * Get update service name.
   * @return set_key
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_KEY;
  }
}
