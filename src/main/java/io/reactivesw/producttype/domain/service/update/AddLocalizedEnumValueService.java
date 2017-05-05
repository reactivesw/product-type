package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import io.reactivesw.producttype.application.model.action.AddLocalizedEnumValue;
import io.reactivesw.producttype.application.model.attributes.LocalizedEnumAttributeType;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * Service to add localizedEnumValue when update productType.
 */
@Service(value = ProductTypeActionUtils.ADD_LOCALIZED_ENUM_VALUE)
public class AddLocalizedEnumValueService implements Updater<ProductType, UpdateAction> {

  /**
   * Add localized enum value.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    AddLocalizedEnumValue addLocalizedEnumValue = (AddLocalizedEnumValue) action;
    String attributeName = addLocalizedEnumValue.getAttributeName();
    LocalizedEnumValue value = addLocalizedEnumValue.getValue();

    Consumer<AttributeDefinition> attributeDefinitionConsumer = (attribute) -> {
      LocalizedEnumAttributeType lenumAttribute =
          (LocalizedEnumAttributeType) attribute.getType();
      lenumAttribute.getValues().add(value);
      attribute.setType(lenumAttribute);
    };
    entity.getAttributes().stream().filter(attribute -> attribute.getName().equals(attributeName))
        .forEach(attributeDefinitionConsumer);
  }
}
