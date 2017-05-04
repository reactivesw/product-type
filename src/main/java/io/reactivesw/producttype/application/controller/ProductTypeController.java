package io.reactivesw.producttype.application.controller;

import io.reactivesw.producttype.application.model.PagedQueryResult;
import io.reactivesw.producttype.application.model.ProductTypeDraft;
import io.reactivesw.producttype.application.model.ProductTypeView;
import io.reactivesw.producttype.application.model.QueryConditions;
import io.reactivesw.producttype.domain.service.ProductTypeService;
import io.reactivesw.producttype.infrastructure.Router;
import io.reactivesw.producttype.infrastructure.update.UpdateRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * Controller for productType to CRUD.
 */
@RestController
public class ProductTypeController {

  /**
   * Log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductTypeController.class);

  /**
   * Log exit with product type id.
   */
  private static final String LOG_EXIT_PRODUCTTYPEID = "Exit. ProductTypeId: {}.";

  /**
   * The Product type service.
   */
  @Autowired
  private transient ProductTypeService productTypeService;

  /**
   * Create product type product type.
   *
   * @param productTypeDraft the product type draft
   * @return the product type
   */
  @PostMapping(Router.PRODUCT_TYPE_ROOT)
  public ProductTypeView createProductType(@RequestBody
  @Valid ProductTypeDraft productTypeDraft) {
    LOG.info("Enter. Create productType: {}.", productTypeDraft);

    ProductTypeView result = productTypeService.createProductType(productTypeDraft);

    LOG.info(LOG_EXIT_PRODUCTTYPEID, result.getId());
    LOG.trace("ProductType: {}.", result);

    return result;
  }

  /**
   * Delete ProductType by id.
   *
   * @param id the id
   * @param version the version
   */
  @DeleteMapping(Router.PRODUCT_TYPE_WITH_ID)
  public void deleteProductTypeById(@PathVariable(value = Router.PRODUCT_TYPE_ID) String id,
      @RequestParam @NotNull Integer version) {
    LOG.info("Enter. ProductTypeId: {}, version: {}.", id, version);

    productTypeService.deleteProductTypeById(id, version);

    LOG.info("Exit. ProductTypeId: {}, version: {}.", id, version);
  }

  /**
   * Delete ProductType by key.
   *
   * @param key the id
   * @param version the version
   */
  @DeleteMapping(Router.PRODUCT_TYPE_WITH_KEY)
  public void deleteProductTypeByKey(@PathVariable(value = Router.PRODUCT_TYPE_KEY) String key,
      @RequestParam @NotNull Integer version) {
    LOG.info("Enter. ProductTypeKey: {}, version: {}.", key, version);

    productTypeService.deleteProductTypeByKey(key, version);

    LOG.info("Exit. ProductTypeKey: {}, version: {}.", key, version);
  }


  /**
   * Update ProductType by id.
   *
   * @param id the id
   * @param updateRequest the update request
   * @return the ProductType
   */
  @PutMapping(Router.PRODUCT_TYPE_WITH_ID)
  public ProductTypeView updateProductTypeById(@PathVariable(value = Router.PRODUCT_TYPE_ID)
      String id,
      @RequestBody @Valid UpdateRequest updateRequest) {
    LOG.info("Enter. ProductTypeId: {}, update request: {}.", id, updateRequest);

    ProductTypeView result = productTypeService.updateProductTypeById(id, updateRequest
            .getVersion(),
        updateRequest.getActions());

    LOG.info(LOG_EXIT_PRODUCTTYPEID, result.getId());
    LOG.trace("Updated ProductType: {}.", result);

    return result;
  }

  /**
   * Update ProductType by key.
   *
   * @param key the key
   * @param updateRequest the update request
   * @return the ProductType
   */
  @PutMapping(Router.PRODUCT_TYPE_WITH_KEY)
  public ProductTypeView updateProductTypeByKey(@PathVariable(value = Router.PRODUCT_TYPE_ID)
      String key,
      @RequestBody @Valid UpdateRequest updateRequest) {
    LOG.info("Enter. ProductTypeKey: {}, update request: {}.", key, updateRequest);
    ProductTypeView result = productTypeService.updateProductTypeByKey(key, updateRequest
            .getVersion(),
        updateRequest.getActions());

    LOG.info(LOG_EXIT_PRODUCTTYPEID, result.getId());
    LOG.trace("Updated ProductType: {}.", result);
    return result;
  }

  /**
   * Gets ProductType by id.
   *
   * @param id the id
   * @return the product type
   */
  @GetMapping(Router.PRODUCT_TYPE_WITH_ID)
  public ProductTypeView getProductTypeById(@PathVariable(value = Router.PRODUCT_TYPE_ID) String
      id) {
    LOG.info("Enter. ProductTypeId: {}.", id);
    ProductTypeView result = productTypeService.getProductTypeById(id);
    LOG.info(LOG_EXIT_PRODUCTTYPEID, result.getId());
    LOG.trace("ProductType: {}.", result);
    return result;
  }

  /**
   * Gets ProductType by key.
   *
   * @param key the key
   * @return the product type
   */
  @GetMapping(Router.PRODUCT_TYPE_WITH_KEY)
  public ProductTypeView getProductTypeByKey(@PathVariable(value = Router.PRODUCT_TYPE_KEY)
      String key) {
    LOG.info("Enter. ProductTypeKey: {}.", key);
    ProductTypeView result = productTypeService.getProductTypeByKey(key);

    LOG.info(LOG_EXIT_PRODUCTTYPEID, result.getId());
    LOG.trace("ProductType: {}.", result);

    return result;
  }

  /**
   * Query ProductType.
   *
   * @param queryConditions the query conditions
   * @return the paged query result
   */
  @GetMapping(Router.PRODUCT_TYPE_ROOT)
  public PagedQueryResult<ProductTypeView> queryProductTypes(QueryConditions queryConditions) {
    LOG.info("Enter. Query parameters: {}.", queryConditions);
    PagedQueryResult<ProductTypeView> result = productTypeService.queryProductTypes(
        queryConditions);

    LOG.info("Exit. Result count: {}.", result.getResults().size());
    LOG.trace("Query result: {}.", result);

    return result;
  }
}
