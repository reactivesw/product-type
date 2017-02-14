package io.reactivesw.producttype.application.model.mapper;

import com.google.common.collect.Lists;
import io.reactivesw.producttype.application.model.AttributeDefinitionDraft;
import io.reactivesw.producttype.application.model.attributes.AttributeDefinitionView;
import io.reactivesw.producttype.application.model.attributes.AttributeType;
import io.reactivesw.producttype.domain.model.AttributeDefinition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/8.
 */
public final class AttributeDefinitionMapper {

  /**
   * Model to entity set.
   *
   * @param attributeDefinitionList the attribute definition list
   * @return the set
   */
  public static List<AttributeDefinition> modelToEntity(List<AttributeDefinitionDraft>
                                                            attributeDefinitionList) {
    List<AttributeDefinition> entities = Lists.newArrayList();
    if (attributeDefinitionList != null) {
      entities = attributeDefinitionList.stream().map(
          attributeDefinitionDraft -> modelToEntity(attributeDefinitionDraft)
      ).collect(Collectors.toList());
    }
    return entities;
  }

  /**
   * convert Model to AttributeDefinitionView.
   *
   * @param draft the draft
   * @return the AttributeDefinitionView
   */
  public static AttributeDefinition modelToEntity(AttributeDefinitionDraft draft) {
    AttributeDefinition entity = new AttributeDefinition();
    entity.setName(draft.getName());
    entity.setInputHint(draft.getInputHint());
    entity.setRequired(draft.getIsRequired());
    entity.setSearchable(draft.getIsSearchable());
    entity.setType(draft.getType());
    entity.setAttributeConstraint(draft.getAttributeConstraint());
    entity.setLabel(LocalizedStringMapper.modelToEntityDefaultNew(draft.getLabel()));
    entity.setInputTip(LocalizedStringMapper.modelToEntityDefaultNew(draft.getInputTip()));
    return entity;
  }

  /**
   * convert Model to AttributeDefinitionView.
   *
   * @param attributeType the attribute type
   * @return the attribute definition entity
   */
  public static AttributeDefinition modelToEntity(AttributeType attributeType) {
    AttributeDefinition entity = new AttributeDefinition();
    return entity;
  }

  /**
   * Entity to model list.
   *
   * @param entities the entity
   * @return the list
   */
  public static List<AttributeDefinitionView> entityToModel(List<AttributeDefinition> entities) {
    List<AttributeDefinitionView> models = entities.stream().map(
        entity -> entityToModel(entity)
    ).collect(Collectors.toList());
    return models;
  }

  /**
   * convert Entity to AttributeDefinitionView.
   *
   * @param entity the entity
   * @return the attribute definition
   */
  public static AttributeDefinitionView entityToModel(AttributeDefinition entity) {
    AttributeDefinitionView model = new AttributeDefinitionView();
    model.setName(entity.getName());
    model.setInputHint(entity.getInputHint());
    model.setInputTip(LocalizedStringMapper.entityToModelDefaultNull(entity.getInputTip()));
    model.setLabel(LocalizedStringMapper.entityToModelDefaultNull(entity.getLabel()));
    model.setIsRequired(entity.getRequired());
    model.setIsSearchable(entity.getSearchable());
    model.setType(entity.getType());
    model.setAttributeConstraint(entity.getAttributeConstraint());
    return model;
  }
}
