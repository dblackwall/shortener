package com.blackwall.shortener.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.blackwall.shortener.model.AbstractEntity;

/**
 *
 * @param <ENTITY>
 */
@Transactional(propagation = Propagation.MANDATORY)
public class AbstractDao<ENTITY extends AbstractEntity> implements IAbstractDao<ENTITY>
{
  /**
   *
   */
  @PersistenceContext(unitName = "ShortenerEM")
  private EntityManager entityManager;

  /**
   *
   * @param entity
   */
  public void save(ENTITY entity)
  {
    this.entityManager.persist(entity);
  }

  public ENTITY get(String id)
  {
    return null;
  }
  
  /**
   * 
   * @param criteria
   * @return
   */
  public List<ENTITY> findByCriteria(CriteriaQuery<ENTITY> criteria)
  {
    return this.entityManager.createQuery(criteria).getResultList();
  }
  
  /**
   * 
   * @return
   */
  protected EntityManager getEntityManager()
  {
    return this.entityManager;
  }
}
