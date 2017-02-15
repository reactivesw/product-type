package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.producttype.application.model.mapper.LocalizedStringMapper;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
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
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_INPUTTIP)
public class SetAttributeInputTipService implements Updater<ProductType, UpdateAction> {
  /**
   * set attribute input tip.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    SetAttributeInputTip setAttributeInputTip = (SetAttributeInputTip) action;
    String attributeName = setAttributeInputTip.getAttributeName();
    Set<LocalizedStringValue> inputTip = LocalizedStringMapper.modelToEntityDefaultNew(
        setAttributeInputTip.getInputTip());

    List<AttributeDefinition> attributes = entity.getAttributes().stream()
        .map(
            attribute -> {
              if (Objects.equals(attributeName, attribute.getName())) {
                attribute.setInputTip(inputTip);
              }
              return attribute;
            }
        ).collect(Collectors.toList());

    entity.setAttributes(attributes);
  }
}
