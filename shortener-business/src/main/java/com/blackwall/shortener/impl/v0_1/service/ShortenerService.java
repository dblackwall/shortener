package com.blackwall.shortener.impl.v0_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blackwall.shortener.IShortener;
import com.blackwall.shortener.impl.v0_1.dao.IShortLinkDao;
import com.blackwall.shortener.model.ShortLink;
import com.blackwall.shortener.services.AbstractShortenerService;
import com.blackwall.shortener.services.IShortenerService;

/**
 *
 */
@Component("ShortenerServiceV0_1")
public class ShortenerService extends AbstractShortenerService<ShortLink> implements IShortenerService<ShortLink>
{
  /**
   *
   */
  @Autowired
  private IShortener<ShortLink> shortener;

  /**
   *
   */
  @Autowired
  private IShortLinkDao<ShortLink> dao;

  protected IShortener<ShortLink> getShortener()
  {
    return this.shortener;
  }

  protected IShortLinkDao<ShortLink> getDao()
  {
    return this.dao;
  }
}
