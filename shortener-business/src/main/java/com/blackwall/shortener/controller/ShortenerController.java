package com.blackwall.shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blackwall.shortener.model.ShortLink;
import com.blackwall.shortener.services.IShortenerService;

/**
 * 
 * @author hraf
 *
 */
@Controller
public class ShortenerController
{

  /** 
   * 
   */
  @Autowired
  private IShortenerService<?> shortenerService;
  
  /**
   * 
   */
  private final static String BASE = "/shortener/";

  /**
   * 
   * @param longUrl
   * @return
   * @throws Exception
   */
  @RequestMapping(value = BASE + "{longUrl}", 
                 method = RequestMethod.POST,
                 produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ShortLink shorten(@PathVariable("longUrl") String longUrl) throws Exception
  {
    return this.shortenerService.shorten(longUrl);
  }
  
 
  @RequestMapping(value = BASE + "{shortURL}", 
                  method = RequestMethod.GET,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ShortLink> expand(@PathVariable("shortURL") String shortURL) throws Exception
  {
    ShortLink result = this.shortenerService.expand(shortURL);
    return this.createResult(result); 
  }
  
  /**
   * 
   * @param result
   * @return
   */
  private ResponseEntity<ShortLink> createResult(ShortLink result)
  {
    if(result == null)
    {
      return new ResponseEntity<ShortLink>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<ShortLink>(result, HttpStatus.OK);
  }


}