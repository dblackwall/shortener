package com.blackwall.shortener.impl.v0_1.generator;

import com.blackwall.shortener.generator.IShortLinkGenerator;
import org.springframework.stereotype.Component;

@Component("ShortLinkGeneratorV0_1")
public class ShortLinkRandomGenerator implements IShortLinkGenerator
{
  public String generate(String longLink)
  {
    return new RandomString().nextString();
  }
}
