package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.SetKey;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import org.springframework.stereotype.Service;

/**
 * Service to set key when update productType.
 */
@Service(value = ProductTypeActionUtils.SET_KEY)
public class SetKeyService implements Updater<ProductType, UpdateAction> {

  /**
   * Set product type key.
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
