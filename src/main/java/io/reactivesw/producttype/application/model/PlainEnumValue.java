package io.reactivesw.producttype.application.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by umasuo on 16/11/18.
 */
@Getter
@Setter
public class PlainEnumValue {

  /**
   * The key build the value used as a programmatic identifier, e.g. in facets & filters.
   */
  private String key;

  /**
   * A descriptive label build the value.
   */
  private String label;
}
