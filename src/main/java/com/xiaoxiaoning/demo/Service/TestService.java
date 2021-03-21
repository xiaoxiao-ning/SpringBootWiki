package com.xiaoxiaoning.demo.Service;

import com.xiaoxiaoning.demo.domain.Test;
import com.xiaoxiaoning.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/20 7:19 下午
 */

@Service
public class TestService implements TestMapper {

  @Autowired//也可以用@AutoWired
  public TestMapper testMapper;


  @Override
  public List<Test> list() {
    return testMapper.list();
  }


}
