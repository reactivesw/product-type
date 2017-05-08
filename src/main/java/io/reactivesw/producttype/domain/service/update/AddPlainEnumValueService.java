package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.EnumValue;
import io.reactivesw.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.producttype.application.model.attributes.EnumAttributeType;
import io.reactivesw.producttype.application.model.mapper.EnumValueMapper;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * Service to add plainEnumValue when update productType.
 */
@Service(value = ProductTypeActionUtils.ADD_PLAIN_ENUM_VALUE)
public class AddPlainEnumValueService implements Updater<ProductType, UpdateAction> {

  /**
   * Add enum value.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    AddPlainEnumValue addPlainEnumValue = (AddPlainEnumValue) action;
    String attributeName = addPlainEnumValue.getAttributeName();
    EnumValue enumValue = EnumValueMapper.toEntity(addPlainEnumValue.getValue());

    Consumer<AttributeDefinition> attributeDefinitionConsumer = (attribute) -> {
      EnumAttributeType enumAttributeType = (EnumAttributeType) attribute
          .getType();
      // TODO: 16/12/12 if values is null?
      enumAttributeType.getValues().add(enumValue);
      attribute.setType(enumAttributeType);
    };
    entity.getAttributes().stream().filter(attribute -> attribute.getName().equals(attributeName))
        .forEach(attributeDefinitionConsumer);
  }
}
