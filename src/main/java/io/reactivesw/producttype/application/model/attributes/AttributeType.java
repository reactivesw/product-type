package io.reactivesw.producttype.application.model.attributes;

/**
 * Created by Davis on 16/11/16.
 */

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = BooleanAbstractAttributeType.class, name = "boolean"),
    @JsonSubTypes.Type(value = StringAbstractAttributeType.class, name = "text"),
    @JsonSubTypes.Type(value = LocalizedStringAbstractAttributeType.class, name = "ltext"),
    @JsonSubTypes.Type(value = EnumAbstractAttributeType.class, name = "enum"),
    @JsonSubTypes.Type(value = LocalizedEnumAbstractAttributeType.class, name = "lenum"),
    @JsonSubTypes.Type(value = NumberAbstractAttributeType.class, name = "number"),
    @JsonSubTypes.Type(value = MoneyAbstractAttributeType.class, name = "money"),
    @JsonSubTypes.Type(value = DateAbstractAttributeType.class, name = "date"),
    @JsonSubTypes.Type(value = TimeAbstractAttributeType.class, name = "time"),
    @JsonSubTypes.Type(value = DateTimeAbstractAttributeType.class, name = "datetime"),
    @JsonSubTypes.Type(value = ReferenceAbstractAttributeType.class, name = "reference"),
    @JsonSubTypes.Type(value = SetAbstractAttributeType.class, name = "set"),
    @JsonSubTypes.Type(value = NestedAbstractAttributeType.class, name = "nested")})
public interface AttributeType {

}
