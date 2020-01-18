package com.blackwall.shortener.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blackwall.shortener.IShortener;
import com.blackwall.shortener.impl.v0_1.dao.IShortLinkDao;
import com.blackwall.shortener.model.ShortLink;

/**
 * @param <SHORT_LINK>
 */
@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractShortenerService<SHORT_LINK extends ShortLink> implements IShortenerService<ShortLink>
{
  
  /**
   * 
   */
  private static Logger LOGGER = Logger.getLogger(AbstractShortenerService.class);
  /**
   * @param longURL
   * @return
   */
  public SHORT_LINK shorten(String longURL) throws Exception
  {
    SHORT_LINK result = this.getShortener().shorten(longURL);
    long before  = System.currentTimeMillis();
    this.getDao().save(result);
    Thread.sleep(5000);
    long duration  = System.currentTimeMillis() - before;
    LOGGER.debug("DAO CALL : " + duration + " ms " ); 
    LOGGER.info("DAO CALL : " + duration + " ms " ); 
    return result;
  }
  
  /**
   * 
   */
  public SHORT_LINK expand(String shortURL) throws Exception
  {
    long before  = System.currentTimeMillis();
    List<SHORT_LINK> result = this.getDao().findByShortURL(shortURL);
    Thread.sleep(5000);
    long duration  = System.currentTimeMillis() - before;
    LOGGER.debug("DAO CALL : " + duration + " ms " ); 
    LOGGER.info("DAO CALL : " + duration + " ms " ); 
    if(result.isEmpty())
    {
      return null;
    }
    //TODO return null;
    return result.get(0);
  }


  /**
   * @return
   */
  protected abstract IShortener<SHORT_LINK> getShortener();

  /**
   * @return
   */
  protected abstract IShortLinkDao<SHORT_LINK> getDao();
}
