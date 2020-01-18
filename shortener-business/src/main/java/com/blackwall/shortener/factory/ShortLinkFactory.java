package com.blackwall.shortener.factory;

import com.blackwall.shortener.factory.AbstractShortLinkFactory;
import com.blackwall.shortener.model.ShortLink;
import org.springframework.stereotype.Component;

/**
 * 
 * @author hraf
 *
 */
@Component("ShortLinkFactoryV0_1")
public class ShortLinkFactory extends AbstractShortLinkFactory<ShortLink> implements IShortLinkFactory<ShortLink>
{
  
  /**
   * 
   */
  public ShortLink makeShortLink(String longUrl, String shortUrl)
  {
    return new ShortLink(longUrl, shortUrl);
  }
}
