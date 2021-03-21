package com.xiaoxiaoning.demo.controller;

import com.xiaoxiaoning.demo.Service.EbookService;
import com.xiaoxiaoning.demo.domain.Ebook;
import com.xiaoxiaoning.demo.response.CommonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/21 9:12 上午
 */

@RestController
@RequestMapping("/ebook")
public class EbookController {


  @Autowired
  private EbookService ebookService;


  @GetMapping("/list")
  public CommonResp list(){
    List<Ebook> list =  ebookService.list();
    CommonResp<List<Ebook>> resp = new CommonResp<>();
    resp.setContent(list);
    return resp;
  }
}
