package com.blackwall.shortener.generator;

/**
 *
 */
public interface IShortLinkGenerator
{
  /**
   *
   * @param longLink
   * @return
   */
  String generate(String longLink);
}
