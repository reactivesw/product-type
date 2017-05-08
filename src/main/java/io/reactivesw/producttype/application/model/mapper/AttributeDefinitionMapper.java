package io.reactivesw.producttype.application.model.mapper;

import com.google.common.collect.Lists;

import io.reactivesw.producttype.application.model.AttributeDefinitionDraft;
import io.reactivesw.producttype.application.model.attributes.AttributeDefinitionView;
import io.reactivesw.producttype.domain.model.AttributeDefinition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/8.
 */
public final class AttributeDefinitionMapper {

  /**
   * Private constructor.
   */
  private AttributeDefinitionMapper() {
  }

  /**
   * Model to entity set.
   *
   * @param attributeDefinitionList the attribute definition list
   * @return the set
   */
  public static List<AttributeDefinition> toEntity(List<AttributeDefinitionDraft>
      attributeDefinitionList) {
    List<AttributeDefinition> entities = Lists.newArrayList();
    if (attributeDefinitionList != null) {
      entities = attributeDefinitionList.stream().map(AttributeDefinitionMapper::toEntity)
          .collect(Collectors.toList());
    }
    return entities;
  }

  /**
   * Convert Model to AttributeDefinitionView.
   *
   * @param draft the draft
   * @return the AttributeDefinitionView
   */
  public static AttributeDefinition toEntity(AttributeDefinitionDraft draft) {
    AttributeDefinition entity = new AttributeDefinition();
    entity.setName(draft.getName());
    entity.setInputHint(draft.getInputHint());
    entity.setRequired(draft.getIsRequired());
    entity.setSearchable(draft.getIsSearchable());
    entity.setType(draft.getType());
    entity.setAttributeConstraint(draft.getAttributeConstraint());
    entity.setLabel(LocalizedStringMapper.toEntityDefaultNew(draft.getLabel()));
    entity.setInputTip(LocalizedStringMapper.toEntityDefaultNew(draft.getInputTip()));
    return entity;
  }

  /**
   * Entity to model list.
   *
   * @param entities the entity
   * @return the list
   */
  public static List<AttributeDefinitionView> toModel(List<AttributeDefinition> entities) {
    List<AttributeDefinitionView> models = entities.stream().map(AttributeDefinitionMapper::toModel)
        .collect(Collectors.toList());
    return models;
  }

  /**
   * Convert Entity to AttributeDefinitionView.
   *
   * @param entity the entity
   * @return the attribute definition
   */
  public static AttributeDefinitionView toModel(AttributeDefinition entity) {
    AttributeDefinitionView model = new AttributeDefinitionView();
    model.setName(entity.getName());
    model.setInputHint(entity.getInputHint());
    model.setInputTip(LocalizedStringMapper.toModelDefaultNull(entity.getInputTip()));
    model.setLabel(LocalizedStringMapper.toModelDefaultNull(entity.getLabel()));
    model.setIsRequired(entity.getRequired());
    model.setIsSearchable(entity.getSearchable());
    model.setType(entity.getType());
    model.setAttributeConstraint(entity.getAttributeConstraint());
    return model;
  }
}
