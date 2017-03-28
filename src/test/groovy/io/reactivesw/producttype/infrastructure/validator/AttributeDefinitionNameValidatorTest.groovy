package io.reactivesw.producttype.infrastructure.validator

import com.google.common.collect.Lists
import io.reactivesw.exception.ParametersException
import io.reactivesw.producttype.application.model.AttributeDefinitionDraft
import io.reactivesw.producttype.application.model.ProductTypeDraft
import spock.lang.Specification

/**
 * Created by Davis on 17/3/28.
 */
class AttributeDefinitionNameValidatorTest extends Specification {
    AttributeDefinitionNameValidator validator = new AttributeDefinitionNameValidator()

    def "test 1 : attribute name is unique and expect true"() {
        given:
        def name1 = "name1"
        def name2 = "name2"
        AttributeDefinitionDraft attribute1 = new AttributeDefinitionDraft(name: name1)
        AttributeDefinitionDraft attribute2 = new AttributeDefinitionDraft(name: name2)
        List<AttributeDefinitionDraft> attributes = Lists.newArrayList(attribute1, attribute2)

        ProductTypeDraft draft = new ProductTypeDraft(attributes: attributes)

        when:
        AttributeDefinitionNameValidator.validate(draft)

        then:
        true
    }

    def "test 2 : attribute name is not unique and throw ParametersException"() {
        given:
        def name1 = "name1"
        AttributeDefinitionDraft attribute1 = new AttributeDefinitionDraft(name: name1)
        AttributeDefinitionDraft attribute2 = new AttributeDefinitionDraft(name: name1)
        List<AttributeDefinitionDraft> attributes = Lists.newArrayList(attribute1, attribute2)

        ProductTypeDraft draft = new ProductTypeDraft(attributes: attributes)

        when:
        AttributeDefinitionNameValidator.validate(draft)

        then:
        thrown(ParametersException)
    }
}
