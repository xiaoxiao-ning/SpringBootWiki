package com.xiaoxiaoning.demo.Service;

import com.xiaoxiaoning.demo.domain.EbookSnapshot;
import com.xiaoxiaoning.demo.mapper.EbookSnapshotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/20 8:27 下午
 */

@Service
public class EbookSnapshotService  {


  @Autowired//也可以用@AutoWired
  public EbookSnapshotMapper ebookSnapshotMapper;



  public List<EbookSnapshot> list() {
    return ebookSnapshotMapper.selectByExample(null);
  }

}
