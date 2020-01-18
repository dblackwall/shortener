package com.blackwall.shortener.impl.v0_1.dao;

import java.util.List;

import com.blackwall.shortener.dao.IAbstractDao;
import com.blackwall.shortener.model.ShortLink;

/**
 * 
 * @author hraf
 *
 */
public interface IShortLinkDao<SHORT_LINK extends ShortLink> extends IAbstractDao<ShortLink>
{
  
  /**
   * 
   * @param longUrl
   * @return
   */
  List<SHORT_LINK> findByShortURL(String longUrl);
}
