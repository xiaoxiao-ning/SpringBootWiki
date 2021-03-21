package com.xiaoxiaoning.demo.controller;

import com.xiaoxiaoning.demo.Service.TestService;
import com.xiaoxiaoning.demo.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/20 7:36 下午
 */
@RestController
public class TestController {

  @Autowired
  private TestService testService;


  @GetMapping("/test/list")
  public List<Test> list(){
    return testService.list();
  }

}
