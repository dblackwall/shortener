package com.blackwall.shortener.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 * 
 * @author hraf
 *
 */
public class JNDIInitializer
{

  Map<String, Object> bindings = new HashMap<String, Object>();

  /**
   * 
   * @throws NamingException
   */
  @PostConstruct
  public void setUp() throws NamingException
  {
    SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
    for (Entry<String, Object> entry : this.bindings.entrySet())
    {
      builder.bind(entry.getKey(), entry.getValue());
    }
  }

  /**
   * 
   * @return
   */
  public Map<String, Object> getBindings()
  {
    return bindings;
  }

  /**
   * 
   * @param bindings
   */
  public void setBindings(Map<String, Object> bindings)
  {
    this.bindings = bindings;
  }

}
