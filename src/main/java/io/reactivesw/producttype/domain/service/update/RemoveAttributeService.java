package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.exception.NotExistException;
import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.RemoveAttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.REMOVE_ATTRIBUTE_DEFINITION)
public class RemoveAttributeService implements Updater<ProductType, UpdateAction> {
  /**
   * remove attribute from product type.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    String attributeName = ((RemoveAttributeDefinition) action).getName();

    List updateAttributes = entity.getAttributes().stream().filter(
        attribute -> !Objects.equals(attribute.getName(), attributeName)
    ).collect(Collectors.toList());

    if (updateAttributes.size() == entity.getAttributes().size()) {
      throw new NotExistException("can not find attribute by name : " + attributeName);
    }

    entity.setAttributes(updateAttributes);
  }
}

