package io.reactivesw.producttype.application.model.attributes;

/**
 * Constraint between different attributes.
 */
public enum AttributeConstraint {

  /**
   * None attribute constraint.
   */
  None,

  /**
   * Unique attribute constraint.
   */
  Unique,

  /**
   * Combination unique attribute constraint.
   */
  CombinationUnique,

  /**
   * Same for all attribute constraint.
   */
  SameForAll;
}
