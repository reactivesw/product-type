package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class LocalizedStringAttributeType extends AttributeTypeBase {
    private LocalizedStringAttributeType() {}

    @JsonIgnore
    public static LocalizedStringAttributeType of() {
        return new LocalizedStringAttributeType();
    }
}
