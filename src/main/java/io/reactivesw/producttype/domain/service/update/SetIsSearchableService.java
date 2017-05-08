package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.SetIsSearchable;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Set isSearchable when update productType.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_SEARCHABLE)
public class SetIsSearchableService implements Updater<ProductType, UpdateAction> {

  /**
   * Set isSearchable to attribute.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }

    SetIsSearchable setIsSearchable = (SetIsSearchable) action;

    entity.getAttributes().stream()
        .filter(attribute -> attribute.getName().equals(setIsSearchable.getActionName()))
        .forEach(attribute -> attribute.setSearchable(setIsSearchable.getIsSearchable()));
  }
}
