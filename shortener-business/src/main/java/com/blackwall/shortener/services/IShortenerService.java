package com.blackwall.shortener.services;

import com.blackwall.shortener.model.ShortLink;

/**
 * 
 * @author hraf
 *
 * @param <SHORT_LINK>
 */
public interface IShortenerService<SHORT_LINK extends ShortLink>
{

  /**
   * 
   * @param longURL
   * @return
   * @throws Exception
   */
  public SHORT_LINK shorten(String longURL) throws Exception;
  
  /**
   * 
   * @param shortURL
   * @return
   * @throws Exception
   */
  public SHORT_LINK expand(String shortURL) throws Exception;


}
