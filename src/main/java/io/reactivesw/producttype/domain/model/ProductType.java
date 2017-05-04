package io.reactivesw.producttype.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Product type.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "product_type")
@EntityListeners(AuditingEntityListener.class)
public class ProductType {

  /**
   * Id.
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
   * Version.
   */
  @Version
  @Column
  private Integer version;

  /**
   * Key word.
   */
  @Column(name = "product_type_key")
  private String key;

  /**
   * Name.
   */
  @Column
  private String name;

  /**
   * Description.
   */
  @Column
  private String description;

  /**
   * Attributes.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<AttributeDefinition> attributes;
}
