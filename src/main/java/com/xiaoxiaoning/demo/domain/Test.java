package com.xiaoxiaoning.demo.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by xiaoxiaoning on 2021/3/20 7:23 下午
 */

@Data
@ToString
public class Test {

  private Integer id;
  private String password;
  private String name;

  public Test(Integer id, String password, String name) {
    this.id = id;
    this.password = password;
    this.name = name;
  }

  public Test() {
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
