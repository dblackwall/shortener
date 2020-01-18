package com.blackwall.shortener.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity
{

  /**
   *
   */
  @Transient
  private Long id = null;

  /**
   *
   * @return
   */
  @JsonIgnore
  @Access(AccessType.PROPERTY)
  @Id()
  @Column(name = "ID", length = 20, nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId()
  {
    return this.id;
  }

  /**
   *
   * @param id
   */
  public void setId(Long id)
  {
    this.id = id;
  }
}
