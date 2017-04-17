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

### delete product type by key

### update product type by id

### update product type by key

### get product type by id

### get product type by key

### query product type
