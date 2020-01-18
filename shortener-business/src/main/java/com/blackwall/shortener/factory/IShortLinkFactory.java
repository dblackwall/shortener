package com.blackwall.shortener.factory;

import com.blackwall.shortener.model.ShortLink;

/**
 * 
 * @author hraf
 *
 * @param <SHORT_LINK>
 */
public interface IShortLinkFactory<SHORT_LINK extends ShortLink>
{
  /**
   *
   * @param longUrl
   * @param shortUrl
   * @return
   */
  SHORT_LINK makeShortLink(String longUrl, String shortUrl);

}
