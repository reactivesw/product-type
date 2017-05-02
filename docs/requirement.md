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
2. type, label, required, attributeConstraint, searchable in attributes of
productType are required
3. name in attributes of category should be alphabetic, numeric, underscore(_) and hyphen(-)
characters.Maximize size of slug is 256, and minimum size is 2.

### 2.2. Create productType
1. name in attributes of productType should be unique

### 2.3. Delete productType
1. version and id of productType should match

### 2.4. Update productType
1. all attributes of productType could be updated
2. version and id of productType should match

### 2.5. Get individual productType

### 2.6. Get all productType

### 3. How to provide
ProductType service provides RESTful API, here is [api document](./api.md)
