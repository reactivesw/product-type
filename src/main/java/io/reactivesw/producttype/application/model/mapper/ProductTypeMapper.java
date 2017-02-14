package io.reactivesw.producttype.application.model.mapper;

import io.reactivesw.model.Reference;
import io.reactivesw.producttype.application.model.ProductTypeDraft;
import io.reactivesw.producttype.application.model.ProductTypeView;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.util.ReferenceTypes;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/7.
 */
public final class ProductTypeMapper {
  /**
   * Model to product type entity.
   *
   * @param draft the product type draft
   * @return the product type entity
   */
  public static ProductType modelToEntity(ProductTypeDraft draft) {
    ProductType entity = new ProductType();
    entity.setName(draft.getName());
    entity.setKey(draft.getKey());
    entity.setDescription(draft.getDescription());
    entity.setAttributes(AttributeDefinitionMapper.modelToEntity(draft.getAttributes()));
    return entity;
  }

  /**
   * Entity to product type.
   *
   * @param entity the product type entity
   * @return the product type
   */
  public static ProductTypeView entityToModel(ProductType entity) {
    ProductTypeView model = new ProductTypeView();
    model.setName(entity.getName());
    model.setDescription(entity.getDescription());
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setId(entity.getId());
    model.setKey(entity.getKey());
    model.setVersion(entity.getVersion());
    model.setAttributes(AttributeDefinitionMapper.entityToModel(entity.getAttributes()));
    return model;
  }

  /**
   * convert List of ProductType to List of ProductTypeView.
   *
   * @param entities the List of ProductType
   * @return the List of ProductTypeView
   */
  public static List<ProductTypeView> entityToModel(List<ProductType> entities) {
    return entities.stream()
        .map(entity -> {
          return entityToModel(entity);
        }).collect(Collectors.toList());
  }

  public static Reference entityToReference(String productTypeId) {
    Reference reference = null;
    if (StringUtils.isNotBlank(productTypeId)) {
      reference = new Reference(ReferenceTypes.PRODUCTTYPE.getType(), productTypeId);
    }
    return reference;
  }
}
