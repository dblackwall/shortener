package com.blackwall.shortener.factory;

import com.blackwall.shortener.model.ShortLink;

public abstract class AbstractShortLinkFactory<SHORT_LINK extends ShortLink>
{
  /**
   *
   * @param longUrl
   * @param shortUrl
   * @return
   */
  public abstract SHORT_LINK makeShortLink(String longUrl, String shortUrl);
}
