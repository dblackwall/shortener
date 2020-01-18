package com.blackwall.shortener.impl.v0_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blackwall.shortener.AbstractShortener;
import com.blackwall.shortener.factory.IShortLinkFactory;
import com.blackwall.shortener.generator.IShortLinkGenerator;
import com.blackwall.shortener.model.ShortLink;

/**
 *
 */
@Component("ShortenerV0_1")
public class Shortener extends AbstractShortener<ShortLink>
{
  /**
   *
   */
  @Autowired
  private IShortLinkGenerator generator;

  /**
   *
   */
  @Autowired
  private IShortLinkFactory<ShortLink> factory;

  /**
   *
   * @return
   */
  protected IShortLinkGenerator getShortLinkGenerator()
  {
    return this.generator;
  }

  /**
   *
   * @return
   */
  protected IShortLinkFactory<ShortLink> getFactory()
  {
    return this.factory;
  }
}
