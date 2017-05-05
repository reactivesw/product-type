package io.reactivesw.producttype.infrastructure.validator;

import com.google.common.collect.Sets;

import io.reactivesw.exception.ParametersException;
import io.reactivesw.producttype.application.model.AttributeDefinitionDraft;
import io.reactivesw.producttype.application.model.ProductTypeDraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Validator for attributeDefinition.
 */
public final class AttributeDefinitionNameValidator {

  /**
   * Log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AttributeDefinitionNameValidator.class);

  /**
   * Private constructor.
   */
  private AttributeDefinitionNameValidator() {
  }


  /**
   * Validate if attribute name is unique.
   *
   * @param productTypeDraft the product type draft
   */
  public static void validate(ProductTypeDraft productTypeDraft) {
    List<AttributeDefinitionDraft> attributeDefinitions = productTypeDraft.getAttributes();
    if (attributeDefinitions != null && !attributeDefinitions.isEmpty()) {
      List<String> attributeDefinitionNames = attributeDefinitions.stream().map(
          AttributeDefinitionDraft::getName
      ).collect(Collectors.toList());

      Set<String> attributeSets = Sets.newHashSet(attributeDefinitionNames);
      if (attributeSets.size() < attributeDefinitionNames.size()) {
        LOG.debug("Attribute name should be unique.");
        throw new ParametersException("Attribute name should be unique.");
      }
    }
  }
}
