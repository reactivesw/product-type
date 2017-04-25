# Product-Type Rest API

## Introduction

TODO

## View Model

### ProductTypeDraft

| field name | field type | comments |
|-----|------|-----|
| name | String | required |
| key | String | should less than 256 characters |
| description | String | required |
| attributes | List\<AttributeDefinitionDraft\> | |

### AttributeDefinitionDraft

| field name | field type | comments |
|-----|------|-----|
| type | AttributeType | required |
| name | String | required, The name must be between two and 36 characters long and can contain the ASCII letters A to Z in lowercase or uppercase, digits, underscores (_) and the hyphen-minus (-) |
| label | LocalizedString | required |
| isRequired | Boolean | required |
| attributeConstraint | AttributeConstraint | required |
| inputHint | TextInputHint | |
| isSearchable | Boolean | required |
| inputTip | LocalizedString | |

### ProductTypeView

| field name | field type | comments |
|-----|------|-----|
| id | String | |
| version | Integer | |
| createAt | ZonedDateTime | |
| lastModifiedAt | ZonedDateTime | |
| key | String | |
| name | String | |
| description | String | |
| attributes | List\<AttributeDefinitionView\> | |

### AttributeDefinitionView
| field name | field type | comments |
|-----|------|-----|
| type | AttributeType | |
| name | String | |
| label | LocalizedString | |
| inputTip | LocalizedString | |
| Boolean | isRequired | |
| AttributeConstraint | attributeConstraint | |
| TextInputHint | inputHint | |
| Boolean | isSearchable | |

### UpdateRequest

| field name | field type | comments |
|-|-|-|
| version | Integer | required, NotNull, min is 0 |
| actions | List\<UpdateAction\> | required, NotNull |

### UpdateAction

#### SetKey

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_key` |
| name | LocalizedString | required, NotNull |

#### SetName

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_name` |
| name | LocalizedString | required, NotNull |

#### SetDescription

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_description` |
| name | LocalizedString | required, NotNull |

#### AddAttributeDefinition

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `add_attribute_definition` |
| name | LocalizedString | required, NotNull |

#### RemoveAttributeDefinition

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `remove_attribute_definition` |
| name | LocalizedString | required, NotNull |

#### SetAttributeLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_attribute_label` |
| name | LocalizedString | required, NotNull |

#### SetAttributeInputTip

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_attribute_definition_inputtip` |
| name | LocalizedString | required, NotNull |

#### AddPlainEnumValue

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `add_plain_enum_value` |
| name | LocalizedString | required, NotNull |

#### AddLocalizedEnumValue

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `add_localized_enum_value` |
| name | LocalizedString | required, NotNull |

#### SetAttributeOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_attribute_order` |
| name | LocalizedString | required, NotNull |

#### SetPlainEnumValueOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_enum_value_order` |
| name | LocalizedString | required, NotNull |

#### SetLocalizedEnumValueOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_localized_enum_value_order` |
| name | LocalizedString | required, NotNull |

#### SetPlainEnumValueLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_enum_value_label` |
| name | LocalizedString | required, NotNull |

#### SetLocalizedEnumValueLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_localized_enum_value_label` |
| name | LocalizedString | required, NotNull |

#### SetIsSearchable

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `set_attribute_searchable` |
| name | LocalizedString | required, NotNull |

### PagedQueryResult

| field name | field type | comments |
|-|-|-|
| offset | Integer | |
| count | Integer | |
| total | Integer | |
| results | List\<T\> | |
| facets | Object | |

## API

### create product type

* URL : {service url}/
* method : POST
* request body :

| name | type | comments |
|-|-|-|
| productTypeDraft | ProductTypeDraft | required |

* response : ProductTypeView

### delete product type by id

* URL : {service url}/{productTypeId}
* method : DELETE
* request body :

| name | type | comments |
|-|-|-|
| version | Integer | required |

* response : void

### delete product type by key

* URL : {service url}/{productTypeKey}
* method : DELETE
* request body :

| name | type | comments |
|-|-|-|
| version | Integer | required |

* response : void


### update product type by id

* URL : {service url}/{productTypeId}
* method : PUT
* request body :

| name | type | comments |
|-|-|-|
| updateRequest | updateRequest | required |

* response : ProductTypeView


### update product type by key

* URL : {service url}/{productTypeKey}
* method : PUT
* request body :

| name | type | comments |
|-|-|-|
| updateRequest | updateRequest | required |

* response : ProductTypeView

### get product type by id

* URL : {service url}/{productTypeId}
* method : GET
* response : ProductTypeView

### get product type by key

* URL : {service url}/{productTypeKey}
* method : GET
* response : ProductTypeView

### query product type

* URL : {service url}/
* method : GET
* request body :

| name | type | comments |
|-|-|-|
| query | QueryConditions | not required |

* response : PagedQueryResult<ProductTypeView>

