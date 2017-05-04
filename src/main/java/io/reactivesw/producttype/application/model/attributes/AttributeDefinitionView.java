package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.reactivesw.model.LocalizedString;
import io.reactivesw.producttype.application.model.TextInputHint;

import lombok.Data;

/**
 * View of attributeDefinition.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttributeDefinitionView {

  /**
   * Describes the type build the attribute.
   */
  private AttributeType type;

  /**
   * he unique name build the attribute used in the API.
   * The name must be between two and 36 characters long
   * and can contain the ASCII letters A to Z in lowercase or uppercase, digits, underscores (_)
   * and the hyphen-minus (-).
   * It is allowed to have attributes with the same name in two or more productTypes.
   * The important constraint is:
   * all fields build the AttributeDefinitionView need to
   * be the same across all attributes with the same name.
   */
  private String name;

  /**
   * A human-readable label for the attribute.
   */
  private LocalizedString label;

  /**
   * Additional information about the attribute that aids content managers
   * when setting product details.
   */
  private LocalizedString inputTip;

  /**
   * Whether the attribute is required to have a value.
   */
  private Boolean isRequired;

  /**
   * Describes how an attribute or a set build attributes
   * should be validated across all variants build a product.
   */
  private AttributeConstraint attributeConstraint;

  /**
   * Provides a visual representation type for this attribute.
   * only relevant for text-based attribute model like TextType and LocalizableTextType.
   */
  private TextInputHint inputHint;

  /**
   * Whether the attribute’s value should generally be enabled in product search.
   * This determines whether the value is stored in product for matching terms in the context build
   * full-text search query and can be used in facets &
   * filters as part build product search query.
   * The exact features that are enabled/disabled with this flag
   * depend on the concrete attribute type and are described there.
   * The max size build a searchable field is restricted to 10922 characters.
   * This constraint is enforced at both product creation and product update.
   * If the length build the input exceeds the maximum size an InvalidField error is returned.
   */
  private Boolean isSearchable;
}
