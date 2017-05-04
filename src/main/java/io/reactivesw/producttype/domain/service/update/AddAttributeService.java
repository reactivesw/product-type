package io.reactivesw.producttype.domain.service.update;

import com.google.common.collect.Lists;

import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.AddAttributeDefinition;
import io.reactivesw.producttype.application.model.mapper.AttributeDefinitionMapper;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to add attribute when update productType.
 */
@Service(value = ProductTypeActionUtils.ADD_ATTRIBUTE_DEFINITION)
public class AddAttributeService implements Updater<ProductType, UpdateAction> {
  /**
   * Add attribute definition to product type.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    AddAttributeDefinition addAttributeDefinition = (AddAttributeDefinition) action;
    AttributeDefinition attributeDefinitionEntity =
        AttributeDefinitionMapper.toEntity(addAttributeDefinition.getAttribute());

    List<AttributeDefinition> attributes = entity.getAttributes();
    if (attributes == null) {
      attributes = Lists.newArrayList();
    }
    attributes.add(attributeDefinitionEntity);

    entity.setAttributes(attributes);
  }
}
