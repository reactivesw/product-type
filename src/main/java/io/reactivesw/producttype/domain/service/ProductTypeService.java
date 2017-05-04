package io.reactivesw.producttype.domain.service;

import io.reactivesw.exception.ConflictException;
import io.reactivesw.exception.NotExistException;
import io.reactivesw.producttype.application.model.PagedQueryResult;
import io.reactivesw.producttype.application.model.ProductTypeDraft;
import io.reactivesw.producttype.application.model.ProductTypeView;
import io.reactivesw.producttype.application.model.QueryConditions;
import io.reactivesw.producttype.application.model.mapper.ProductTypeMapper;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.repository.ProductTypeRepository;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import io.reactivesw.producttype.infrastructure.update.UpdaterService;
import io.reactivesw.producttype.infrastructure.validator.AttributeDefinitionNameValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service for productType.
 */
@Service
public class ProductTypeService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductTypeService.class);

  /**
   * The Product type repository.
   */
  @Autowired
  private transient ProductTypeRepository productTypeRepository;

  /**
   * ProductTypeUpdateService.
   */
  @Autowired
  private transient UpdaterService updateService;

  /**
   * Create product type.
   *
   * @param productTypeDraft the product type draft
   * @return the product type
   */
  public ProductTypeView createProductType(ProductTypeDraft productTypeDraft) {
    LOG.debug("Enter. ProductType draft: {}.", productTypeDraft);

    AttributeDefinitionNameValidator.validate(productTypeDraft);

    ProductType entity = ProductTypeMapper.toEntity(productTypeDraft);

    ProductType savedEntity = productTypeRepository.save(entity);

    ProductTypeView result = ProductTypeMapper.toModel(savedEntity);

    LOG.debug("Exit. New productTypeId: {}.", result.getId());
    LOG.trace("New productType: {}.",result);
    return result;
  }

  /**
   * Delete ProductType by id.
   *
   * @param id      the id
   * @param version the version
   */
  public void deleteProductTypeById(String id, Integer version) {
    LOG.debug("Enter. ProductTypeId: {}, version: {}.", id, version);

    ProductType entity = getProductTypeEntityById(id);
    validateVersion(version, entity);

    // TODO: 16/12/8 validateNull if has product

    productTypeRepository.delete(id);
    // TODO: 16/12/8 send a message

    LOG.debug("Exit. Deleted productTypeId: {}, version: {}.", id, version);
    LOG.trace("Deleted productType: {}.",entity);
  }

  /**
   * Delete ProductType by key.
   *
   * @param key     the key
   * @param version the version
   */
  public void deleteProductTypeByKey(String key, Integer version) {
    LOG.debug("Enter. ProductTypeKey: {}, version: {}.", key, version);

    ProductType entity = getProductTypeEntityByKey(key);
    validateVersion(version, entity);

    // TODO: 16/12/8 validateNull if has product

    productTypeRepository.delete(entity);

    // TODO: 16/12/8 send a message

    LOG.debug("Exit. Deleted productTypeId: {}, version: {}.",entity.getId(),version);
    LOG.trace("Deleted productType: {}.",entity);
  }

  /**
   * Update ProductType by id.
   *
   * @param id      the id
   * @param version the version
   * @param actions the actions
   * @return the updated ProductType
   */
  public ProductTypeView updateProductTypeById(String id, Integer version, List<UpdateAction>
      actions) {
    LOG.debug("Enter. ProductTypeId: {}, version: {}, update actions: {}.",
        id, version, actions);

    ProductType entity = getProductTypeEntityById(id);
    ProductTypeView result = updateProductTypeEntity(version, actions, entity);

    LOG.debug("Exit. ProductTypeId: {}.",result.getId());
    LOG.trace("Updated ProductType: {}.",result);
    return result;
  }

  /**
   * Update ProductType by key.
   *
   * @param key     the key
   * @param version the version
   * @param actions the actions
   * @return the updated ProductType
   */
  public ProductTypeView updateProductTypeByKey(String key, Integer version,
                                                List<UpdateAction> actions) {
    LOG.debug("Enter. ProductTypeKey: {}, version: {}, update actions: {}.",
        key, version, actions);

    ProductType entity = getProductTypeEntityByKey(key);
    ProductTypeView result = updateProductTypeEntity(version, actions, entity);

    LOG.debug("Exit. ProductTypeId: {}.",result.getId());
    LOG.trace("Updated productType: {}.",result);
    return result;
  }

  /**
   * Gets product type by id.
   *
   * @param id the id
   * @return the product type by id
   */
  public ProductTypeView getProductTypeById(String id) {
    LOG.debug("Enter. ProductTypeId: {}.", id);

    ProductType entity = getProductTypeEntityById(id);
    ProductTypeView result = ProductTypeMapper.toModel(entity);

    LOG.debug("Exit. ProductTypeId: {}.", result);
    LOG.trace("ProductType: {}.",result);
    return result;
  }

  /**
   * Gets product type by key.
   *
   * @param key the key
   * @return the product type by key
   */
  public ProductTypeView getProductTypeByKey(String key) {
    LOG.debug("Enter. ProductTypeKey: {}.", key);

    ProductType entity = getProductTypeEntityByKey(key);
    ProductTypeView result = ProductTypeMapper.toModel(entity);

    LOG.debug("Exit. ProductTypeId: {}.", result.getId());
    LOG.trace("ProductType: {}.",result);
    return result;
  }

  /**
   * Query ProductType.
   *
   * @param queryConditions the query conditions
   * @return the paged query result
   */
  // TODO: 16/12/13 queryconditions
  public PagedQueryResult<ProductTypeView> queryProductTypes(QueryConditions queryConditions) {
    LOG.debug("Enter. Query conditions: {}.",queryConditions);
    List<ProductType> entities = productTypeRepository.findAll();
    List<ProductTypeView> productTypes = ProductTypeMapper.toModel(entities);

    PagedQueryResult<ProductTypeView> result = new PagedQueryResult<>();
    result.setResults(productTypes);
    result.setTotal(productTypes.size());

    LOG.debug("Exit. Queried productType count: {}.",productTypes.size());
    LOG.trace("ProductTypes: {}.",productTypes);

    return result;
  }

  /**
   * ValidateNull version.
   *
   * @param version the version
   * @param entity  the entity
   */
  private void validateVersion(Integer version, ProductType entity) {
    if (!Objects.equals(version, entity.getVersion())) {
      LOG.debug("Version not match, input version: {}, entity version: {}.",
          version, entity.getVersion());
      throw new ConflictException("Version not match.");
    }
  }

  /**
   * Gets product type entity by key.
   *
   * @param key the key
   * @return the product type entity
   */
  private ProductType getProductTypeEntityByKey(String key) {
    ProductType entity = productTypeRepository.findDistinctProductTypeByKey(key);
    if (entity == null) {
      LOG.debug("Can not find product type by key: {}.", key);
      throw new NotExistException("ProductType not exist.");
    }
    return entity;
  }

  /**
   * Gets product type entity by id.
   *
   * @param id the id
   * @return the product type entity by id
   */
  private ProductType getProductTypeEntityById(String id) {
    ProductType entity = productTypeRepository.findOne(id);
    if (entity == null) {
      LOG.debug("Can not find product type by id: {}.", id);
      throw new NotExistException("ProductType not exist.");
    }
    return entity;
  }

  /**
   * Update ProductTypeEntity.
   *
   * @param version the version
   * @param actions the update actions
   * @param entity  the entity
   * @return updated ProductType
   */
  private ProductTypeView updateProductTypeEntity(Integer version, List<UpdateAction> actions,
                                                  ProductType entity) {
    validateVersion(version, entity);

    actions.parallelStream().forEach(action -> {
      updateService.handle(entity, action);
    });

    ProductType updatedEntity = productTypeRepository.save(entity);
    return ProductTypeMapper.toModel(updatedEntity);
  }
}
