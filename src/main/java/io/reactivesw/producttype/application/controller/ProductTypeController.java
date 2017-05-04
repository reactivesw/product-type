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
    LOG.debug("enter createProductType, draft is:{}", productTypeDraft.toString());

    ProductTypeView result = productTypeService.createProductType(productTypeDraft);

    LOG.debug("end createProductType, new product type is:{}", result.toString());

    return result;
  }

  /**
   * Delete ProductType by id.
   *
   * @param id      the id
   * @param version the version
   */
  @DeleteMapping(Router.PRODUCT_TYPE_WITH_ID)
  public void deleteProductTypeById(@PathVariable(value = Router.PRODUCT_TYPE_ID) String id,
                                    @RequestParam @NotNull Integer version) {
    LOG.debug("enter deleteProductTypeById, id is : {}, version is : {}", id, version);

    productTypeService.deleteProductTypeById(id, version);

    LOG.debug("end deleteProductTypeById, id is : {}, version is : {}", id, version);
  }

  /**
   * Delete ProductType by key.
   *
   * @param key     the id
   * @param version the version
   */
  @DeleteMapping(Router.PRODUCT_TYPE_WITH_KEY)
  public void deleteProductTypeByKey(@PathVariable(value = Router.PRODUCT_TYPE_KEY) String key,
                                     @RequestParam @NotNull Integer version) {
    LOG.debug("enter deleteProductTypeById, key is : {}, version is : {}", key, version);

    productTypeService.deleteProductTypeByKey(key, version);

    LOG.debug("end deleteProductTypeById, key is : {}, version is : {}", key, version);
  }


  /**
   * Update ProductType by id.
   *
   * @param id            the id
   * @param updateRequest the update request
   * @return the ProductType
   */
  @PutMapping(Router.PRODUCT_TYPE_WITH_ID)
  public ProductTypeView updateProductTypeById(@PathVariable(value = Router.PRODUCT_TYPE_ID)
                                                   String id,
                                               @RequestBody @Valid UpdateRequest updateRequest) {
    LOG.debug("enter updateProductTypeById,id is {}, update request is {}",
        id, updateRequest.toString());

    ProductTypeView result = productTypeService.updateProductTypeById(id, updateRequest
            .getVersion(),
        updateRequest.getActions());

    LOG.debug("end updateCategory, updated Category is {}", result.toString());

    return result;
  }

  /**
   * Update ProductType by key.
   *
   * @param key           the key
   * @param updateRequest the update request
   * @return the ProductType
   */
  @PutMapping(Router.PRODUCT_TYPE_WITH_KEY)
  public ProductTypeView updateProductTypeByKey(@PathVariable(value = Router.PRODUCT_TYPE_ID)
                                                    String key,
                                                @RequestBody @Valid UpdateRequest updateRequest) {
    LOG.debug("enter updateProductTypeById,key is {}, update request is {}",
        key, updateRequest.toString());

    ProductTypeView result = productTypeService.updateProductTypeByKey(key, updateRequest
            .getVersion(),
        updateRequest.getActions());

    LOG.debug("end updateCategory, updated Category is {}", result.toString());

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
    LOG.debug("enter getProductTypeById, id is:{}", id);
    ProductTypeView result = productTypeService.getProductTypeById(id);
    LOG.debug("end getProductTypeById, get ProductType : {}", result.toString());
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
    LOG.debug("enter getProductTypeByKey, key is : {}", key);

    ProductTypeView result = productTypeService.getProductTypeByKey(key);

    LOG.debug("end getProductTypeById, get ProductType : {}", result.toString());

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
    LOG.debug("enter queryProductTypes, QueryConditions is : {}", queryConditions.toString());

    PagedQueryResult<ProductTypeView> result = productTypeService.queryProductTypes(
                                                                              queryConditions);

    LOG.debug("end queryProductTypes, productType number is : {}", result.getResults().size());

    return result;
  }
}
