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
| requirable | Boolean | required |
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
| requirable | Boolean | |
| attributeConstraint | AttributeConstraint | |
| inputHint | TextInputHint | |
| searchable | Boolean | |

### 2.5. UpdateRequest

| field name | field type | comments |
|-|-|-|
| version | Integer | required, NotNull, min is 0 |
| actions | List\<UpdateAction\> | required, NotNull |

### 2.6. UpdateAction

#### 2.6.1. SetKey

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setKey` |
| name | LocalizedString | required, NotNull |

#### 2.6.2. SetName

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setName` |
| name | LocalizedString | required, NotNull |

#### 2.6.3. SetDescription

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setDescription` |
| name | LocalizedString | required, NotNull |

#### 2.6.4. AddAttributeDefinition

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `addAttributeDefinition` |
| name | LocalizedString | required, NotNull |

#### 2.6.5. RemoveAttributeDefinition

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `removeAttributeDefinition` |
| name | LocalizedString | required, NotNull |

#### 2.6.6. SetAttributeLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setLabel` |
| name | LocalizedString | required, NotNull |

#### 2.6.7. SetAttributeInputTip

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setInputTip` |
| name | LocalizedString | required, NotNull |

#### 2.6.8. AddPlainEnumValue

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `addPlainEnumValue` |
| name | LocalizedString | required, NotNull |

#### 2.6.9. AddLocalizedEnumValue

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `addLocalizedEnumValue` |
| name | LocalizedString | required, NotNull |

#### 2.6.10. SetAttributeOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setAttributeOrder` |
| name | LocalizedString | required, NotNull |

#### 2.6.11. SetPlainEnumValueOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setPlainEnumValueOrder` |
| name | LocalizedString | required, NotNull |

#### 2.6.12. SetLocalizedEnumValueOrder

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setLocalizedEnumValueOrder` |
| name | LocalizedString | required, NotNull |

#### 2.6.13. SetPlainEnumValueLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setPlainEnumValueLabel` |
| name | LocalizedString | required, NotNull |

#### 2.6.14. SetLocalizedEnumValueLabel

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setLocalizedEnumValueLabel` |
| name | LocalizedString | required, NotNull |

#### 2.6.15. SetSearchable

| field name | field type | comments |
|-|-|-|
| action | String | required, set as `setSearchable` |
| name | LocalizedString | required, NotNull |

### 2.7. PagedQueryResult

| field name | field type | comments |
|-|-|-|
| offset | Integer | |
| count | Integer | |
| total | Integer | |
| results | List\<T\> | |
| facets | Object | |

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

