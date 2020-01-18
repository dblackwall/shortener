package com.blackwall.shortener.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.blackwall.shortener.impl.v0_1.dao.IShortLinkDao;
import com.blackwall.shortener.model.ShortLink;
import com.blackwall.shortener.services.IShortenerService;

@ContextConfiguration("classpath:config/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleShortenerTest
{
  @Autowired
  private IShortenerService<?> shortener;

  @Autowired
  private IShortLinkDao shortLinkDao;

  @Test
  public void test() throws Exception
  {
    ShortLink short1 = this.shortener.shorten("https://twitter.com/home");
    System.out.println(short1.getShortURL());
  }
  
  @Test
  @Transactional
  public void testDao() throws Exception
  {
    List<ShortLink> result = this.shortLinkDao.findByShortURL("test");
    System.out.println(result);
  }
}
