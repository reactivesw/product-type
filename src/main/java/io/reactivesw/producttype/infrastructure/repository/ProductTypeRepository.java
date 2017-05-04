package io.reactivesw.producttype.infrastructure.repository;

import io.reactivesw.producttype.domain.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for productType
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
  /**
   * Find distinct product type by key product type entity.
   *
   * @param key the key
   * @return the product type entity
   */
  ProductType findDistinctProductTypeByKey(String key);
}
