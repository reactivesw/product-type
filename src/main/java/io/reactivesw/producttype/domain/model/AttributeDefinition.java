package io.reactivesw.producttype.domain.model;

import io.reactivesw.database.dialect.JSONBUserType;
import io.reactivesw.producttype.application.model.TextInputHint;
import io.reactivesw.producttype.application.model.attributes.AttributeConstraint;
import io.reactivesw.producttype.application.model.attributes.AttributeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "catalog_product_type_attribute_definition")
@TypeDef(name = "attributeType", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS,
        value = "io.reactivesw.catalog.product.application.model.attributes.AttributeType")}
)
public class AttributeDefinition {


  /**
   * Id
   */
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  protected String id;

  /**
   * The Created at.
   */
  @CreatedDate
  @Column(name = "created_at")
  protected ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @LastModifiedDate
  @Column(name = "last_modified_at")
  protected ZonedDateTime lastModifiedAt;


  /**
   * The Type.
   */
  @Type(type = "attributeType")
  private AttributeType type;

  /**
   * The Name.
   */
  @Column
  private String name;

  /**
   * The Label.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringValue> label;

  /**
   * The Input tip.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringValue> inputTip;

  /**
   * The Is required.
   */
  @Column
  private Boolean required;

  /**
   * The Attribute constraint.
   */
  @Column
  private AttributeConstraint attributeConstraint;

  /**
   * The Input hint.
   */
  @Column
  private TextInputHint inputHint;

  /**
   * The Is searchable.
   */
  @Column
  private Boolean searchable;
}
