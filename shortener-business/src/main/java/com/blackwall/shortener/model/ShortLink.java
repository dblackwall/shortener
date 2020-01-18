package com.blackwall.shortener.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@Entity(name = "SHORT_LINK")
//@SequenceGenerator(name = "SEQ_ID", sequenceName = "SIMPLE_ENTITY_ID_SEQ")
@Access(AccessType.FIELD)
public class ShortLink extends AbstractEntity
{
  /**
  *
  */
  @Transient
  private String shortURL;

  /**
  *
  */
  @Transient
  private String longURL;

  /**
   * 
   */
  public ShortLink()
  {
    //
  }

  /**
   *
   * @param longURL
   * @param shortURL
   */
  public ShortLink(String longURL, String shortURL)
  {
    this.longURL = longURL;
    this.shortURL = shortURL;
  }

  /**
   *
   * @return
   */
  @Access(AccessType.PROPERTY)
  @Column(name = "short_url", length = 20, nullable = false, unique = true)
  @JsonProperty
  public String getShortURL()
  {
    return shortURL;
  }

  /**
   *
   * @param shortURL
   */
  public void setShortURL(String shortURL)
  {
    this.shortURL = shortURL;
  }

  /**
   *
   * @return
   */
  @Access(AccessType.PROPERTY)
  @Column(name = "long_url", length = 20, nullable = false)
  @JsonProperty
  public String getLongURL()
  {
    return longURL;
  }

  /**
   *
   * @param longURL
   */
  public void setLongURL(String longURL)
  {
    this.longURL = longURL;
  }
  
  @Override
  public String toString()
  {
    return this.getLongURL() + " / " + this.getShortURL();
  }
}
