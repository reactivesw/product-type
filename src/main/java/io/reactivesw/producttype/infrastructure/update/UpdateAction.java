package io.reactivesw.producttype.infrastructure.update;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.reactivesw.producttype.application.model.action.AddAttributeDefinition;
import io.reactivesw.producttype.application.model.action.AddLocalizedEnumValue;
import io.reactivesw.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.producttype.application.model.action.RemoveAttributeDefinition;
import io.reactivesw.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.producttype.application.model.action.SetAttributeLabel;
import io.reactivesw.producttype.application.model.action.SetAttributeOrder;
import io.reactivesw.producttype.application.model.action.SetDescription;
import io.reactivesw.producttype.application.model.action.SetSearchable;
import io.reactivesw.producttype.application.model.action.SetKey;
import io.reactivesw.producttype.application.model.action.SetLocalizedEnumValueLabel;
import io.reactivesw.producttype.application.model.action.SetLocalizedEnumValueOrder;
import io.reactivesw.producttype.application.model.action.SetName;
import io.reactivesw.producttype.application.model.action.SetPlainEnumValueLabel;
import io.reactivesw.producttype.application.model.action.SetPlainEnumValueOrder;

/**
 * Configurations for common update actions that will be used in more thant one service
 * and this action also extends other action configure in each service.
 * Created by umasuo on 16/11/21.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetKey.class, name = "setKey"),
    @JsonSubTypes.Type(value = SetName.class, name = "setName"),
    @JsonSubTypes.Type(value = SetDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = AddAttributeDefinition.class, name = "addAttributeDefinition"),
    @JsonSubTypes.Type(value = RemoveAttributeDefinition.class, name = "removeAttributeDefinition"),
    @JsonSubTypes.Type(value = SetAttributeLabel.class, name = "setLabel"),
    @JsonSubTypes.Type(value = SetAttributeInputTip.class, name = "setInputTip"),
    @JsonSubTypes.Type(value = AddPlainEnumValue.class, name = "addPlainEnumValue"),
    @JsonSubTypes.Type(value = AddLocalizedEnumValue.class, name = "addLocalizedEnumValue"),
    @JsonSubTypes.Type(value = SetAttributeOrder.class, name = "setAttributeOrder"),
    @JsonSubTypes.Type(value = SetPlainEnumValueOrder.class, name = "setPlainEnumValueOrder"),
    @JsonSubTypes.Type(value = SetLocalizedEnumValueOrder.class,
        name = "setLocalizedEnumValueOrder"),
    @JsonSubTypes.Type(value = SetPlainEnumValueLabel.class, name = "setPlainEnumValueLabel"),
    @JsonSubTypes.Type(value = SetLocalizedEnumValueLabel.class,
        name = "setLocalizedEnumValueLabel"),
    @JsonSubTypes.Type(value = SetSearchable.class, name = "setSearchable")})
public interface UpdateAction {
  /**
   * get action name.
   *
   * @return String
   */
  String getActionName();
}
