# Product-Type Rest API

## 1. Introduction

TODO

## 2. View Model

### 2.1. ProductTypeDraft

| field name | field type | comments |
|-----|------|-----|
| name | String | required |
| description | String | required |
| attributes | List\<AttributeDefinitionDraft\> | |

### 2.2. AttributeDefinitionDraft

| field name | field type | comments |
|-----|------|-----|
| type | AttributeType | required |
| name | String | required, The name must be between two and 36 characters long and can contain the ASCII letters A to Z in lowercase or uppercase, digits, underscores (_) and the hyphen-minus (-) |
| label | LocalizedString | required |
| required | Boolean | required |
| attributeConstraint | AttributeConstraint | required |
| inputHint | TextInputHint | |
| searchable | Boolean | required |
| inputTip | LocalizedString | |

### 2.3. ProductTypeView

| field name | field type | comments |
|-----|------|-----|
| id | String | |
| version | Integer | |
| createdAt | ZonedDateTime | |
| lastModifiedAt | ZonedDateTime | |
| name | String | |
| description | String | |
| attributes | List\<AttributeDefinitionView\> | |

### 2.4. AttributeDefinitionView
| field name | field type | comments |
|-----|------|-----|
| type | AttributeType | |
| name | String | |
| label | LocalizedString | |
| inputTip | LocalizedString | |
| required | Boolean | |
| attributeConstraint | AttributeConstraint | |
| inputHint | TextInputHint | |
| searchable | Boolean | |

### 2.5. UpdateRequest

| field name | field type | comments |
|-|-|-|
| version | Integer | required, NotNull, min is 0 |
| actions | List\<UpdateAction\> | required, NotNull |

### 2.6. UpdateAction

#### 2.6.1. SetName

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setName` |
| name | String | required, NotNull, maximum size is 1 |

#### 2.6.2. SetDescription

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setDescription` |
| description | String | required, NotNull |

#### 2.6.3. AddAttributeDefinition

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `addAttributeDefinition` |
| attribute | AttributeDefinitionDraft | |

#### 2.6.4. RemoveAttributeDefinition

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `removeAttributeDefinition` |
| name | String | required, NotNull, maximum size is 1 |

#### 2.6.5. SetAttributeLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setLabel` |
| attributeName | String | required, NotNull, maximum size is 1 |
| label | LocalizedString | required, NotNull |

#### 2.6.6. SetAttributeInputTip

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setInputTip` |
| attributeName | String | required, NotNull, maximum size is 1 |
| inputTip | LocalizedString | required, NotNull |

#### 2.6.7. AddPlainEnumValue

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `addPlainEnumValue` |
| attributeName | String | required, NotNull, maximum size is 1 |
| value | PlainEnumValue | required, NotNull |

#### 2.6.8. AddLocalizedEnumValue

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `addLocalizedEnumValue` |
| attributeName | String | required, NotNull, maximum size is 1 |
| value | LocalizedEnumValue | required, NotNull |

#### 2.6.9. SetAttributeOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setAttributeOrder` |
| attributes | List\<AttributeDefinitionView\> | required, NotNull, maximum size is 1 |

#### 2.6.10. SetPlainEnumValueOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setPlainEnumValueOrder` |
| attributeName | String | required, NotNull, maximum size is 1 |
| values | List\<PlainEnumValue\> | required, NotNull, maximum size is 1 |

#### 2.6.11. SetLocalizedEnumValueOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setLocalizedEnumValueOrder` |
| attributeName | String | required, NotNull, maximum size is 1 |
| values | List\<LocalizedEnumValue\> | required, NotNull, maximum size is 1 |

#### 2.6.12. SetPlainEnumValueLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setPlainEnumValueLabel` |
| attributeName | String | required, NotNull, maximum size is 1 |
| newValue | PlainEnumValue | required, NotNull |

#### 2.6.13. SetLocalizedEnumValueLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setLocalizedEnumValueLabel` |
| attributeName | String | required, NotNull, maximum size is 1 |
| newValue | LocalizedEnumValue | required, NotNull |

#### 2.6.14. SetSearchable

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setSearchable` |
| attributeName | String | required, NotNull, maximum size is 1 |
| searchable | Boolean | required, NotNull |

### 2.7. PagedQueryResult

| field name | field type | comments |
|-|-|-|
| offset | Integer | |
| count | Integer | |
| total | Integer | |
| results | List\<T\> | |
| facets | Object | |

### 2.8. PlainEnumValue

| field name | field type | comments |
|-|-|-|
| key | String | |
| label | String | |

### 2.9. LocalizedEnumValue

| field name | field type | comments |
|-|-|-|
| key | String | |
| label | LocalizedString | |

### 2.10. AttributeConstraint
AttributeConstraint is an enum class, It has following values:
1. None
2. Unique
3. CombinationUnique,
4. SameForAll

### 2.11. TextInputHint
TextInputHint is an enum class, It has following values:
1. SingleLine
2. MultiLine

## 3. API

### 3.1. create product type

* URL : {service url}/
* method : POST
* request body :

| name | type | comments |
|-|-|-|
| productTypeDraft | ProductTypeDraft | required |

* response : ProductTypeView

### 3.2. delete product type by id

* URL : {service url}/{productTypeId}
* method : DELETE
* request body :

| name | type | comments |
|-|-|-|
| version | Integer | required |

* response : void

### 3.3. update product type by id

* URL : {service url}/{productTypeId}
* method : PUT
* request body :

| name | type | comments |
|-|-|-|
| updateRequest | UpdateRequest | required |

* response : ProductTypeView

### 3.4. get product type by id

* URL : {service url}/{productTypeId}
* method : GET
* response : ProductTypeView

### 3.5. query product type

* URL : {service url}/
* method : GET
* request body :

| name | type | comments |
|-|-|-|
| query | QueryConditions | not required |

* response : PagedQueryResult<ProductTypeView>

