package io.reactivesw.producttype.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.reactivesw.producttype.application.model.attributes.AttributeDefinitionView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/16.
 */
@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeView {

  /**
   * The Id.
   */
  @ApiModelProperty(required = true)
  private String id;

  /**
   * The Version.
   */
  @ApiModelProperty(required = true)
  private Integer version;

  /**
   * The Created at.
   */
  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * The Key.
   */
  @ApiModelProperty
  private String key;

  /**
   * The Name.
   */
  @ApiModelProperty(required = true)
  private String name;

  /**
   * The Description.
   */
  @ApiModelProperty(required = true)
  private String description;

  /**
   * The Attributes.
   */
  private List<AttributeDefinitionView> attributes;
}
