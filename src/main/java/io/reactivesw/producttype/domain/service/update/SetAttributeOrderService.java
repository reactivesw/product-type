package io.reactivesw.producttype.domain.service.update;

import io.reactivesw.exception.ParametersException;
import io.reactivesw.model.Updater;
import io.reactivesw.producttype.application.model.action.SetAttributeOrder;
import io.reactivesw.producttype.domain.model.AttributeDefinition;
import io.reactivesw.producttype.domain.model.ProductType;
import io.reactivesw.producttype.infrastructure.update.ProductTypeActionUtils;
import io.reactivesw.producttype.infrastructure.update.UpdateAction;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_ORDER)
public class SetAttributeOrderService implements Updater<ProductType, UpdateAction> {
  /**
   * change attribute order.
   * The attributes must be equal to the product type attributes (except for the order).
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductType entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }

    List<String> attributeName = getEntityAttributeNames(entity);

    List<String> orderdAttributeName = getOrderdAttributeNames((SetAttributeOrder) action);

    if (!CollectionUtils.isEqualCollection(attributeName, orderdAttributeName)) {
      throw new ParametersException("Attributes must be equal to the product type attributes");
    }

    List<AttributeDefinition> orderdAttributes = sortAttributeByOrder(entity,
        orderdAttributeName);

    entity.setAttributes(orderdAttributes);
  }

  /**
   * Sort attribute by order list.
   *
   * @param entity              the entity
   * @param orderdAttributeName the orderd attribute name
   * @return the list
   */
  private List<AttributeDefinition> sortAttributeByOrder(ProductType entity,
                                                         List<String> orderdAttributeName) {
    return entity.getAttributes().stream()
        .sorted((a1, a2) ->
            Integer.compare(orderdAttributeName.indexOf(a1.getName()),
                orderdAttributeName.indexOf(a2.getName())))
        .collect(Collectors.toList());
  }

  /**
   * Gets orderd attribute names.
   *
   * @param action the action
   * @return the orderd attribute names
   */
  private List<String> getOrderdAttributeNames(SetAttributeOrder action) {
    return action.getAttributes().parallelStream()
        .map(attribute -> {
              return attribute.getName();
            }
        ).collect(Collectors.toList());
  }

  /**
   * Gets entity attribute names.
   *
   * @param entity the entity
   * @return the entity attribute names
   */
  private List<String> getEntityAttributeNames(ProductType entity) {
    return entity.getAttributes().parallelStream().map(
        attribute -> {
          return attribute.getName();
        }
    ).collect(Collectors.toList());
  }
}
