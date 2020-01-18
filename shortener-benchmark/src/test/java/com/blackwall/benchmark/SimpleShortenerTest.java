package com.blackwall.benchmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:config/benchmark/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleShortenerTest
{
  
  @Autowired
  private Benchmarker benchmarker ;

  @Test
  public void test() throws Exception
  {
    this.benchmarker.executeScenario(400, 1);
  }
  
//  @Test
  public void test_Connection() throws Exception
  {
    String url = "jdbc:postgresql://localhost/shortenerDB";
    Properties props = new Properties();
    props.setProperty("user","postgres");
    props.setProperty("password","admin");
//    props.setProperty("ssl","true");
    List<Connection> connections = new ArrayList<>();
    for(int i = 1 ; i < 111 ; i++)
    {
      Connection conn = DriverManager.getConnection(url, props);
      connections.add(conn);
      Statement stmt = conn.createStatement(); 
      String sql = "select * from shortener.short_link";
      ResultSet rs = stmt.executeQuery(sql);
      System.out.println("Connection number " + i +" created ! ");
    }
    System.out.println();
//    while(rs.next())
//    {
//      System.out.println(rs.getString(1));
//      System.out.println(rs.getString(2));
//      System.out.println(rs.getString(3));
//    }
  }

  
  
}
