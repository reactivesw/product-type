package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Attribute class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {
  /**
   * Attribute name.
   */
  private String name;

  /**
   * Attribute value.
   */
  private JsonNode value;
}
