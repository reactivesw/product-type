package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.producttype.application.model.action.SetKey;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import io.reactivesw.producttype.infrastructure.update.Updater;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/2.
 */
@Service(value = ProductTypeActionUtils.SET_KEY)
public class SetKeyService extends Updater {

  /**
   * set product type key.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    SetKey setKey = (SetKey) action;
    entity.setKey(setKey.getKey());
  }
}
