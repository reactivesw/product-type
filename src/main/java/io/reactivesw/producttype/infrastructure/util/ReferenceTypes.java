package io.reactivesw.producttype.infrastructure.util;

/**
 * Enum for referenceTypes.
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
   * Enum value.
   */
  private String value;

  /**
   * Private constructor.
   * @param value enum value
   */
  private ReferenceTypes(String value) {
    this.value = value;
  }

  /**
   * Get type id.
   *
   * @return String
   */
  public String getType() {
    return this.value;
  }
}
