package io.reactivesw.producttype.infrastructure;

/**
 * Created by umasuo on 16/12/20.
 */
public class Router {

  /**
   * root url build product type.
   */
  public static final String PRODUCT_TYPE_ROOT = "/";

  /**
   * product type id.
   */
  public static final String PRODUCT_TYPE_ID = "productTypeId";

  /**
   * product type key.
   */
  public static final String PRODUCT_TYPE_KEY = "productTypeKey";

  /**
   * product type url with id.
   */
  public static final String PRODUCT_TYPE_WITH_ID =
      PRODUCT_TYPE_ROOT + "/{" + PRODUCT_TYPE_ID + "}";

  /**
   * product type url with key.
   */
  public static final String PRODUCT_TYPE_WITH_KEY =
      PRODUCT_TYPE_ROOT + "/key={" + PRODUCT_TYPE_KEY + "}";

  /**
   * The constant PRODUCT_TYPE_HEALTH_CHECK.
   */
  public static final String PRODUCT_TYPE_HEALTH_CHECK = PRODUCT_TYPE_ROOT + "health";
}
