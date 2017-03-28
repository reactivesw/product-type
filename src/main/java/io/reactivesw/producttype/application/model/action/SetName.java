package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetName implements UpdateAction {
  /**
   * The Name.
   */
  @NotNull
  @Size(min = 1)
  private String name;

  /**
   * get update service name.
   * @return set_name
   */
  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_NAME;
  }
}
