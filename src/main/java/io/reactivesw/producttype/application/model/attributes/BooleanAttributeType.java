package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Type for product attributes which only allows {@code true} or {@code false} as value.
 */
public final class BooleanAttributeType extends AttributeTypeBase {

    private BooleanAttributeType() {}

    @JsonCreator
    public static BooleanAttributeType of() {
        return new BooleanAttributeType();
    }
}
