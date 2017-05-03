#  Requirement on Product-Type
This document descript requirement on productType service
## 1. Introduction
ProductType service is used to manage product Type. The functions productType
provides to as below:
1. create productType
2. delete productType
3. update productType
4. get individual productType
5. get all productType

## 2. Requirement

### 2.1. basic requirement about productType
1. name and description of productType are required, others is optional
2. productType could have multiple attributes
3. type, label, required, attributeConstraint, searchable in attributes of
productType are required
4. name in attributes of category should be alphabetic, numeric, underscore(_) and hyphen(-)
characters.Maximize size of slug is 256, and minimum size is 2.
5. attributes of productType should be multiple language
6. there is a constraint for each attribute

### 2.2. Create productType
1. name in attributes of productType should be unique

### 2.3. Delete productType
1. version and id of productType should match
2. if there is a product associate with a productType, this productType could
not be deleted

### 2.4. Update productType
1. all attributes of productType could be updated
2. version and id of productType should match
3. if remove a attribute, associated product should remove corresponding
attribute value
4. if add a attribute, associated product should add this attribute value
5. attribute constraint could not be changed

### 2.5. Get individual productType

### 2.6. Get all productType

### 3. How to provide
ProductType service provides RESTful API, here is [api document](./api.md)
