package io.reactivesw.producttype.application.model;

import lombok.Data;

import java.util.List;

/**
 * Result of query.
 *
 * @param <T> the type parameter
 */
@Data
public class PagedQueryResult<T> {
  /**
   * The Offset.
   */
  private Integer offset;

  /**
   * The Count.
   */
  private Integer count;

  /**
   * The Total.
   */
  private Integer total;

  /**
   * The Results.
   */
  private List<T> results;
}
