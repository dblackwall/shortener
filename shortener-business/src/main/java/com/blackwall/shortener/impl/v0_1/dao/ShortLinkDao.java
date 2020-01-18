package com.blackwall.shortener.impl.v0_1.dao;

import com.blackwall.shortener.dao.AbstractDao;
import com.blackwall.shortener.model.ShortLink;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

/**
 * 
 * @author hraf
 *
 */
@Component("ShortLinkDaoV0_1")
public class ShortLinkDao extends AbstractDao<ShortLink> implements IShortLinkDao<ShortLink>
{
  
  /**
   * 
   */
  @Override
  public List<ShortLink> findByShortURL(String longUrl)
  {
    CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<ShortLink> criteria = builder.createQuery(ShortLink.class);
    Root<ShortLink> root = criteria.from(ShortLink.class);
    criteria.where(builder.equal(root.get("longURL"), longUrl));
    return super.findByCriteria(criteria);
  }
}
