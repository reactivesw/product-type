package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.SetAttributeLabel;
import io.reactivesw.producttype.application.model.mapper.LocalizedStringMapper;
import io.reactivesw.producttype.domain.model.LocalizedStringValue;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service to set attribute label when update productType.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_LABEL)
public class SetAttributeLabelService implements Updater<ProductType, UpdateAction> {
  /**
   * Set attribute label.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    SetAttributeLabel setAttributeLabel = (SetAttributeLabel) action;
    String attributeName = setAttributeLabel.getAttributeName();
    Set<LocalizedStringValue> label = LocalizedStringMapper.toEntityDefaultNew(setAttributeLabel
        .getLabel());

    List attributes = entity.getAttributes().stream().map(
        attribute -> {
          if (Objects.equals(attribute.getName(), attributeName)) {
            attribute.setLabel(label);
          }
          return attribute;
        }).collect(Collectors.toList());

    entity.setAttributes(attributes);
  }
}
