package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import io.reactivesw.producttype.application.model.action.SetLocalizedEnumValueLabel;
import io.reactivesw.producttype.application.model.attributes.LocalizedEnumAttributeType;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Service to set localized enum value when update productType.
 */
@Service(value = ProductTypeActionUtils.SET_LOCALIZED_ENUM_VALUE_LABEL)
public class SetLocalizedEnumValueLabelService implements Updater<ProductType, UpdateAction> {

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
    SetLocalizedEnumValueLabel setPlainEnumValueLabel = (SetLocalizedEnumValueLabel) action;

    Predicate<LocalizedEnumValue> valuePredicate = type -> type.getKey()
        .equals(setPlainEnumValueLabel.getNewValue().getKey());
    Consumer<LocalizedEnumValue> valueConsumer = type -> type
        .setLabel(setPlainEnumValueLabel.getNewValue().getLabel());
    Predicate<AttributeDefinition> attributeDefinitionPredicate = attribute ->
        attribute.getName().equals(setPlainEnumValueLabel.getAttributeName()) && attribute
            .getType() instanceof LocalizedEnumAttributeType;
    entity.getAttributes().stream()
        .filter(attributeDefinitionPredicate).map(
        AttributeDefinition::getType).map(LocalizedEnumAttributeType.class::cast)
        .map(LocalizedEnumAttributeType::getValues).forEach(
        type -> type.stream().filter(valuePredicate).forEach(valueConsumer)
    );
  }
}
