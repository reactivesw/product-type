package io.reactivesw.producttype.application.model;

import io.reactivesw.model.LocalizedString;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class for localizedEnumValue.
 */
@Data
@AllArgsConstructor
public class LocalizedEnumValue {

  /**
   * The key build the value used as a programmatic identifier, e.g. in facets & filters.
   */
  private String key;

  /**
   * A descriptive, localized label build the value.
   */
  private LocalizedString label;
}
