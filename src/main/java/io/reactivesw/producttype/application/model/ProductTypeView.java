package io.reactivesw.producttype.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.reactivesw.producttype.application.model.attributes.AttributeDefinitionView;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * View for ProductType.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeView {

  /**
   * The Id.
   */
  private String id;

  /**
   * The Version.
   */
  private Integer version;

  /**
   * The Created at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * The Key.
   */
  private String key;

  /**
   * The Name.
   */
  private String name;

  /**
   * The Description.
   */
  private String description;

  /**
   * The Attributes.
   */
  private List<AttributeDefinitionView> attributes;
}
