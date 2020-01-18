package com.blackwall.benchmark.util;

public class Pair<FIRST, SECOND>
{
    /**
     * 
     */
    private FIRST first;
    
    /**
     * 
     */
    private SECOND second;
    
    /**
     * 
     * @param first
     * @param second
     */
    public Pair(FIRST first, SECOND second)
    {
      this.first = first;
      this.second = second;
    }
    
    /**
     * 
     * @return
     */
    public FIRST getFirst()
    {
      return this.first;
    }
    
    /**
     * 
     * @return
     */
    public SECOND getSecond()
    {
      return this.second;
    }
    
}
