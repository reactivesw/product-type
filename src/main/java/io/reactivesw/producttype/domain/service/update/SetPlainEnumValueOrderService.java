package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.exception.NotExistException;
import io.reactivesw.exception.ParametersException;
import io.reactivesw.producttype.application.model.action.SetPlainEnumValueOrder;
import io.reactivesw.producttype.application.model.attributes.EnumAttributeType;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import io.reactivesw.producttype.infrastructure.update.Updater;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/1/2.
 */
@Service(value = ProductTypeActionUtils.SET_ENUM_VALUE_ORDER)
public class SetPlainEnumValueOrderService extends Updater {
  /**
   * set plain enum value order.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }
    SetPlainEnumValueOrder setPlainEnumValueOrder = (SetPlainEnumValueOrder) action;

    String enumAttributeName = setPlainEnumValueOrder.getAttributeName();

    EnumAttributeType enumType = getEnumAttributeType(entity, enumAttributeName);
    List<String> enumValueKeys = getEnumAttributeKeys(enumType);

    List<String> orderKeys = getOrderKeys(setPlainEnumValueOrder);

    if (!CollectionUtils.isEqualCollection(orderKeys, enumValueKeys)) {
      throw new ParametersException(
          "The values must be equal to the values of the attribute enum values");
    }

    setEnumValueOrder(entity, enumAttributeName, enumType, orderKeys);
  }

  /**
   * Sets enum value order.
   *
   * @param entity            the entity
   * @param enumAttributeName the set plain enum value order
   * @param enumType          the enum type
   * @param orderdKeys        the orderd keys
   */
  private void setEnumValueOrder(ProductType entity, String
      enumAttributeName, EnumAttributeType enumType, List<String> orderdKeys) {
    enumType.setValues(enumType.getValues().parallelStream().sorted(
        (v1, v2) -> Integer.compare(orderdKeys.indexOf(v1.getKey()),
            orderdKeys.indexOf(v2.getKey()))
    ).collect(Collectors.toList()));

    entity.getAttributes().parallelStream().forEach(
        attribute -> {
          if (attribute.getName().equals(enumAttributeName)) {
            attribute.setType(enumType);
          }
        }
    );
  }

  /**
   * Gets orderd keys.
   *
   * @param setPlainEnumValueOrder the set plain enum value order
   * @return the orderd keys
   */
  private List<String> getOrderKeys(SetPlainEnumValueOrder setPlainEnumValueOrder) {
    return setPlainEnumValueOrder.getValues().parallelStream()
        .map(
            value -> {
              return value.getKey();
            }
        ).collect(Collectors.toList());
  }

  /**
   * Gets enum attribute keys.
   *
   * @param enumType the enum type
   * @return the enum attribute keys
   */
  private List<String> getEnumAttributeKeys(EnumAttributeType enumType) {
    return enumType.getValues().parallelStream().map(
        value -> {
          return value.getKey();
        }
    ).collect(Collectors.toList());
  }

  /**
   * Gets enum attribute type.
   *
   * @param entity            the entity
   * @param enumAttributeName the set plain enum value order
   * @return the enum attribute type
   */
  private EnumAttributeType getEnumAttributeType(ProductType entity,
                                                 String enumAttributeName) {
    List<AttributeDefinition> attributes = entity.getAttributes();
    Optional<AttributeDefinition> enumAttribute = attributes.parallelStream().filter(
        attribute -> attribute.getName().equals(enumAttributeName)
            && attribute.getType() instanceof EnumAttributeType
    ).findAny();

    if (!enumAttribute.isPresent()) {
      throw new NotExistException("can not find enum attribute type named : " + enumAttributeName);
    }
    return (EnumAttributeType) enumAttribute.get().getType();
  }
}
