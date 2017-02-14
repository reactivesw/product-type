package io.reactivesw.producttype.infrastructure.update;


import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/11/21.
 */
@Data
public class UpdateRequest {
  /**
   * The expected version of the category on which the changes should be applied.
   * If the expected version does not match the actual version, a 409 Conflict will be returned.
   */
  @NotNull
  @Min(0)
  Integer version;

  /**
   * Array of UpdateAction.
   * The list of update action to be performed on the category.
   * Required.
   */
  @NotNull
  @Valid
  List<UpdateAction> actions;

  /**
   * convert to UpdateActions.
   *
   * @return list of UpdateAction
   */
  public List<UpdateAction> getActions() {
    return actions.parallelStream().map(a -> (UpdateAction) a).collect(Collectors.toList());
  }
}
