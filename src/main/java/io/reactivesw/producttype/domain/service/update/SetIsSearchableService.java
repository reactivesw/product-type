package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.producttype.application.model.action.SetIsSearchable;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import io.reactivesw.producttype.infrastructure.update.Updater;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_IS_SEARCHABLE)
public class SetIsSearchableService extends Updater {
  /**
   * set isSearchable to attribute.
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

    entity.getAttributes().forEach(
        attribute -> {
          if (attribute.getName().equals(setIsSearchable.getAttributeName())) {
            attribute.setSearchable(setIsSearchable.getIsSearchable());
          }
        }
    );
  }
}
