package com.blackwall.shortener;

import com.blackwall.shortener.factory.IShortLinkFactory;
import com.blackwall.shortener.generator.IShortLinkGenerator;
import com.blackwall.shortener.model.ShortLink;

/**
 *
 * @param <SHORT_LINK>
 */
public abstract class AbstractShortener<SHORT_LINK extends ShortLink> implements IShortener<SHORT_LINK>
{


  /**
   *
   * @param longURL
   * @return
   */
  public SHORT_LINK shorten(String longURL) throws Exception
  {
    if(longURL == null)
    {
      // TODO proper exception
      throw new Exception();
    }
    String shortURL = this.getShortLinkGenerator().generate(longURL);
    return this.getFactory().makeShortLink(longURL, shortURL);
  }

  /**
   *
   * @return
   */
  protected abstract IShortLinkGenerator getShortLinkGenerator();

  /**
   *
   * @return
   */
  protected abstract IShortLinkFactory<SHORT_LINK> getFactory();
}
