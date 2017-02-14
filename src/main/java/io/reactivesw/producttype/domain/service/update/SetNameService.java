package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.producttype.application.model.action.SetName;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import io.reactivesw.producttype.infrastructure.update.Updater;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/30.
 */
@Service(value = ProductTypeActionUtils.SET_NAME)
public class SetNameService extends Updater {
  /**
   * set product type name.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    SetName setName = (SetName) action;
    entity.setName(setName.getName());
  }
}
