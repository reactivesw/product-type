package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.SetPlainEnumValueLabel;
import io.reactivesw.producttype.application.model.attributes.EnumAttributeType;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service(value = ProductTypeActionUtils.SET_ENUM_VALUE_LABEL)
public class SetPlainEnumValueLabelService implements Updater<ProductType, UpdateAction> {

  /**
   * set enum value label.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }
    SetPlainEnumValueLabel setPlainEnumValueLabel = (SetPlainEnumValueLabel) action;
    entity.getAttributes().forEach(
        attribute -> {
          if (attribute.getName().equals(setPlainEnumValueLabel.getAttributeName())
              && attribute.getType() instanceof EnumAttributeType) {
            ((EnumAttributeType) attribute.getType()).getValues().forEach(
                type -> {
                  if (type.getKey().equals(setPlainEnumValueLabel.getNewValue().getKey())) {
                    type.setLabel(setPlainEnumValueLabel.getNewValue().getLabel());
                  }
                }
            );
          }
        }
    );
  }
}
