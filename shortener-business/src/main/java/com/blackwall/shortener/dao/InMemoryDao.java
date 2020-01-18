package com.blackwall.shortener.dao;

import com.blackwall.shortener.model.AbstractEntity;

import java.util.HashMap;

/**
 *
 * @param <ENTITY>
 */
public class InMemoryDao<ENTITY extends AbstractEntity> implements IAbstractDao<ENTITY>
{
  /**
   *
   */
  private HashMap<Long, ENTITY> database = new HashMap<Long, ENTITY>();

  /**
   *
   * @param entity
   */
  public void save(ENTITY entity)
  {
    if (entity == null)
    {
      return;
    }
    this.database.put(entity.getId(), entity);
  }

  /**
   *
   * @param id
   * @return
   */
  public ENTITY get(String id)
  {
    return this.database.get(id);
  }
}
