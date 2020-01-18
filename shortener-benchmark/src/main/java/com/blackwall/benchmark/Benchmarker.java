package com.blackwall.benchmark;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Benchmarker
{

  /**
   * 
   * @param threadsNbr
   * @param requestsPerThread
   * @throws InterruptedException 
   */
  public void executeScenario(int threadsNbr, int requestsPerThread) throws InterruptedException
  {
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < threadsNbr; i++)
    {
      threads.add(new Thread(new Executor(requestsPerThread)));
    }
    
    threads.forEach(thread -> thread.start());
    for(Thread t : threads)
    {
      t.join();
    }
  }

  /**
   * 
   * 
   * @author hraf
   *
   */
  class Executor implements Runnable
  {
    private RestTemplate restTemplate = new RestTemplate();

    private int executionsNbr = 0;

    public Executor(int executionsNbr)
    {
      this.executionsNbr = executionsNbr;
    }

    @Override
    public void run()
    {
      for (int i = 0; i < this.executionsNbr; i++)
      {
        long before = System.currentTimeMillis();
        this.restTemplate.getForObject("http://localhost:8080/shortener-war-1.0-SNAPSHOT/shortener/bufallo", String.class);
        long after = System.currentTimeMillis();
        System.out.println("## " + (after - before) + " ms ##");
      }
    }

  }

}
