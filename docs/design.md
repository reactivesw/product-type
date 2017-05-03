# ProductType design for Admin
This document descripts how to achieve [productType requirement](./requirement.md)
## 1. Basic Features 
ProductType service provides following functions:
+ create productType
+ delete productType
+ update productType
+ get individual productType
+ gett all productType

## 2. Model Design
For ProductType, there are such requirements:
* multi-language
label, inputTip in attributes of productType should be multiple language

* attributes definition
each productType could have multiple attributes

Following content describes how to achieve above requirement.
## 2.1. Multi-Language Design
In our system, multi-language is basic feature, here is
design
[document](https://github.com/reactivesw/ecommerce-cloud/blob/master/docs/multilanguange-design.md)

## 2.2. Attribute definition Design
In productType, we use attribute to descript the property and feature of a
productType and each productType could have several attributes. Taking `clothes`
for example, `clothes` could have such kinds of attributes: *size*, *color*,
*price*, etc. The type of attribute is defined in `AttributeType` enum class
which includes *text*, *number*, *enum* and etc. What should pay attention to is
that the relation between different attribute is constrainted by
`attributeConstraint` filed which is defined in `AttributeDefinitionDraft`
class. Moreover, the value of `attributeConstraint` filed is defined in
`AttributeConstraint` enum class including:
1. None -- no constrains between attributes
2. Unique -- all attributes should be unique 
3. CombinationUnique -- when two or more attributes combines, the combined
   attribute shoule be unique
4. SameforAll -- all values in a attribute should be same 

Taking `clothes` for example:
```json
     {
        "name": "clothes",
        "description": "test description",
        "attributes": [{
                "type": {
                    "name": "number"
                },
                "name": "size",
                "label": {
                    "en": "size",
                    "zh_cn": "尺寸"
                },
                "isRequired": true,
                "attributeConstraint": "CombinationUnique",
                "isSearchable": true,
                "inputHint": "SingleLine"
            },
            {
                "type": {
                    "name": "text"
                },
                "name": "color",
                "label": {
                    "en": "color",
                    "zh_cn": "颜色"
                },
                "isRequired": true,
                "attributeConstraint": "CombinationUnique",
                "isSearchable": true,
                "inputHint": "SingleLine"
            },
            {
                "type": {
                    "name": "enum",
                    "values": [{
                        "key": "enum-key",
                        "label": "enum-value"
                    }]
                },
                "name": "season-style",
                "label": {
                    "en": "season-style",
                    "zh_cn": "季度款式"
                },
                "isRequired": true,
                "attributeConstraint": "CombinationUnique",
                "isSearchable": true,
                "inputHint": "SingleLine"
            }
        ]
    }
```

## 3. Workflow

### 3.1. Create ProductType
1. get productTypeDraft object.
2. check whether attribute name in new productType is unique.
3. convert productTypeDraft object to productType object.
4. call function to create productType.
5. convert productType object to ProductTypeView object, and return result.

### 3.2. Delete ProductType
1. get productType id and version
2. get productType object by id.
3. check whether productType id correspond with correct version or not.
4. delete productType by id.

### 3.3. Update ProductType
1. get productType id and update action list.
2. get productType object by id.
3. check whether productType id correspond with correct version or not.
4. update productType by action defined in update action list.
5. convert productType object to productTypeView object, and return result.

### 3.4. Get Individual ProductType
1. get productType id.
2. get productType object by id.
3. convert productType object to productTypeView object, and return result.

### 3.5. Get All ProductType
1. receive get request without extra parameters.
2. get all productType from database.
3. convert productType object to productTypeView object.
4. put all productTypeView object into a `PageQueryObject` and count the size of
productTypeView object.
5. return `PageQueryObject`

