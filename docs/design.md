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
For ProducTType, there are such requirements:
* multi-language
label, inputTip in attributes of productType should be multiple language

Following content describes how to achieve above requirement.
## 2.1. Multi-Language Design
In our system, multi-language is basic feature, here is
design
[document](https://github.com/reactivesw/ecommerce-cloud/blob/master/docs/multilanguange-design.md)

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

