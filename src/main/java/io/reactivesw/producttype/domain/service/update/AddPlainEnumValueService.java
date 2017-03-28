package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.EnumValue;
import io.reactivesw.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.producttype.application.model.attributes.EnumAttributeType;
import io.reactivesw.producttype.application.model.mapper.EnumValueMapper;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.ADD_PLAIN_ENUM_VALUE)
public class AddPlainEnumValueService implements Updater<ProductType, UpdateAction> {
  /**
   * add enum value.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    AddPlainEnumValue addPlainEnumValue = (AddPlainEnumValue) action;
    String attributeName = addPlainEnumValue.getAttributeName();
    EnumValue enumValue = EnumValueMapper.toEntity(addPlainEnumValue.getValue());

    entity.getAttributes()
        .stream()
        .forEach(
            attribute -> {
              if (Objects.equals(attributeName, attribute.getName())) {
                EnumAttributeType enumAttributeType = (EnumAttributeType) attribute
                    .getType();
                // TODO: 16/12/12 if values is null?
                enumAttributeType.getValues().add(enumValue);
                attribute.setType(enumAttributeType);
              }
            });
  }
}
