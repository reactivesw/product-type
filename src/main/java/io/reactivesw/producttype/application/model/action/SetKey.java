package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/8.
 */
@Getter
@Setter
public class SetKey implements UpdateAction {
  /**
   * The Key.
   */
  private String key;

  /**
   * get update service name.
   * @return set_key
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_KEY;
  }
}
