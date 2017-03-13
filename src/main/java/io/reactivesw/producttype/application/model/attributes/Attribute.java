package io.reactivesw.producttype.application.model.attributes;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by umasuo on 16/11/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {

  private String name;

  private JsonNode value;
}
