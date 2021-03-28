package com.xiaoxiaoning.demo.controller;

import com.xiaoxiaoning.demo.Service.EbookService;
import com.xiaoxiaoning.demo.request.EbookReq;
import com.xiaoxiaoning.demo.response.CommonResp;
import com.xiaoxiaoning.demo.response.EbookResp;
import com.xiaoxiaoning.demo.response.PageResp;
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
  //将传递进来的参数映射为一个EbookReq，SpringBoot会自动解析封装在EbookReq中的属性
  public CommonResp list(EbookReq req){
    //将req传入到Service层的list方法中
    PageResp<EbookResp> list =  ebookService.list(req);
    CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
    resp.setContent(list);
    return resp;
  }
}
