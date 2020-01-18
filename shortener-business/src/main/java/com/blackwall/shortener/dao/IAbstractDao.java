package com.blackwall.shortener.dao;

import com.blackwall.shortener.model.AbstractEntity;

/**
 *
 * @param <ENTITY>
 */
public interface IAbstractDao<ENTITY extends AbstractEntity>
{
  /**
   *
   * @param entity
   */
  void save(ENTITY entity);

  ENTITY get(String id);
}
