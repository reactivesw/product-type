package io.reactivesw.producttype.application.model.action;

import io.reactivesw.producttype.application.model.LocalizedEnumValue;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetLocalizedEnumValueOrder implements UpdateAction {

  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Values.
   */
  @NotNull
  @Size(min = 1)
  private List<LocalizedEnumValue> values;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_LOCALIZED_ENUM_VALUE_ORDER;
  }
}
