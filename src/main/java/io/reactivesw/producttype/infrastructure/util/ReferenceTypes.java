package io.reactivesw.producttype.infrastructure.util;

/**
 * Created by Davis on 16/11/16.
 */
public enum ReferenceTypes {

  CUSTOMERGROUP("customer-group"),

  CHANNEL("channel"),

  PRODUCTTYPE("product-type"),

  CATEGORY("category"),

  CART("cart"),

  ZONE("zone"),

  CARTDISCOUNT("cart-discount"),

  SHIPPING_METHOD("shipping-method"),

  STATE("state"),

  CUSTOMER("customer"),

  ORDER("order"),

  PAYMENT("payment"),

  TAXCATEGORY("tax-category");

  /**
   * enum value.
   */
  private String value;

  /**
   * private constructor.
   * @param value enum value
   */
  private ReferenceTypes(String value) {
    this.value = value;
  }

  /**
   * get type id.
   *
   * @return String
   */
  public String getType() {
    return this.value;
  }
}
