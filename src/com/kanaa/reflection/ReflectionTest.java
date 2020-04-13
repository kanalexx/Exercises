package com.kanaa.reflection;

import java.util.Date;

/**
 * @author Alexander Kanunnikov
 */

public class ReflectionTest {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Date d = new Date();
    Class dCl = d.getClass();
    System.out.println(dCl.getName());

    try {
      String className = "java.util.Date";
      Class cl = Class.forName(className);
      System.out.println(cl);
      System.out.println(Date[].class);
      System.out.println(int.class);
      System.out.println(int[].class.getName());

      Object m = Class.forName(className).newInstance();
      System.out.println(m);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}