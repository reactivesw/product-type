package io.reactivesw.producttype.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeDraft {
  /**
   * The Name.
   */
  @NotNull(message = "product type name can not be null")
  private String name;

  /**
   * The Key.
   */
  @Size(max = 256, message = "product type key should less than 256 characters")
  private String key;

  /**
   * The Description.
   */
  @NotNull(message = "description can not be null")
  private String description;

  /**
   * The Attributes.
   */
  private List<AttributeDefinitionDraft> attributes;
}
