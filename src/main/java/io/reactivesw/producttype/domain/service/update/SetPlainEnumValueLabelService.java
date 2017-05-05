package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.EnumValue;
import io.reactivesw.producttype.application.model.action.SetPlainEnumValueLabel;
import io.reactivesw.producttype.application.model.attributes.EnumAttributeType;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Service to set plainEnumValue when update productType.
 */
@Service(value = ProductTypeActionUtils.SET_ENUM_VALUE_LABEL)
public class SetPlainEnumValueLabelService implements Updater<ProductType, UpdateAction> {

  /**
   * Set enum value label.
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
    Predicate<EnumValue> valuePredicate = type -> type.getKey()
        .equals(setPlainEnumValueLabel.getNewValue().getKey());
    Consumer<EnumValue> valueConsumer = type -> type
        .setLabel(setPlainEnumValueLabel.getNewValue().getLabel());
    entity.getAttributes().stream()
        .filter(attribute -> attribute.getName().equals(setPlainEnumValueLabel.getAttributeName()))
        .filter(attribute -> attribute.getType() instanceof EnumAttributeType).map(
        AttributeDefinition::getType).map(EnumAttributeType.class::cast)
        .map(EnumAttributeType::getValues)
        .forEach(type -> type.stream().filter(valuePredicate).forEach(valueConsumer));

  }
}
