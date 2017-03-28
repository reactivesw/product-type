package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import io.reactivesw.producttype.application.model.action.AddLocalizedEnumValue;
import io.reactivesw.producttype.application.model.attributes.LocalizedEnumAbstractAttributeType;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.ADD_LOCALIZED_ENUM_VALUE)
public class AddLocalizedEnumValueService implements Updater<ProductType, UpdateAction> {
  /**
   * add localized enum value.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    AddLocalizedEnumValue addLocalizedEnumValue = (AddLocalizedEnumValue) action;
    String attributeName = addLocalizedEnumValue.getAttributeName();
    LocalizedEnumValue value = addLocalizedEnumValue.getValue();

    entity.getAttributes().stream()
        .forEach(attribute -> {
          if (Objects.equals(attributeName, attribute.getName())) {
            LocalizedEnumAbstractAttributeType lenumAttribute =
                (LocalizedEnumAbstractAttributeType) attribute.getType();
            lenumAttribute.getValues().add(value);
            attribute.setType(lenumAttribute);
          }
        });

  }
}
