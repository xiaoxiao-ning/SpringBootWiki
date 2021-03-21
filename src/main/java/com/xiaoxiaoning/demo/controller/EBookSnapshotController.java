package com.xiaoxiaoning.demo.controller;

import com.xiaoxiaoning.demo.Service.EbookSnapshotService;
import com.xiaoxiaoning.demo.domain.EbookSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/20 7:36 下午
 */
@RestController
public class EBookSnapshotController {

  @Autowired
  private EbookSnapshotService ebookSnapshotService;


  @GetMapping("/ebookSnapshot/list")
  public List<EbookSnapshot> list(){
    return ebookSnapshotService.list();
  }

}
