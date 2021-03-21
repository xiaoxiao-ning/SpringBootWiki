package com.xiaoxiaoning.demo.Service;

import com.xiaoxiaoning.demo.domain.Ebook;
import com.xiaoxiaoning.demo.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/21 9:08 上午
 */
@Service
public class EbookService {
  @Resource//也可以用@AutoWired
  private EbookMapper ebookMapper;



  public List<Ebook> list() {
    return ebookMapper.selectByExample(null);
  }




}
