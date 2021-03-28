package com.xiaoxiaoning.demo.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxiaoning.demo.domain.Ebook;
import com.xiaoxiaoning.demo.domain.EbookExample;
import com.xiaoxiaoning.demo.mapper.EbookMapper;
import com.xiaoxiaoning.demo.request.EbookReq;
import com.xiaoxiaoning.demo.response.EbookResp;
import com.xiaoxiaoning.demo.response.PageResp;
import com.xiaoxiaoning.demo.utils.CopyUtils;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoxiaoning on 2021/3/21 9:08 上午
 */
@Service
public class EbookService {
  @Resource//也可以用@AutoWired
  private EbookMapper ebookMapper;




  public PageResp<EbookResp> list(EbookReq req) {

    //只需要在java包相应的service类下引入PageHelper类即可
    PageHelper.startPage(req.getPage(), req.getSize());
    //这些EbookExample到底是干嘛用的?????以及criteria这个类是干嘛用的
    EbookExample ebookExample = new EbookExample();
    EbookExample.Criteria criteria = ebookExample.createCriteria();
    //这里就可以调用req中的get方法，来获取到你想要的参数，来进行sql查询
    //使用动态sql
    if(!(ObjectUtils.isEmpty(req.getName()))){
      criteria.andNameLike("%" + req.getName() + "%");
    }

    //创建一个ebookList
    List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
//    List<EbookResp> respList =  new ArrayList<>();
//    for (Ebook ebook : ebookList) {
//
//
//      //对象复制
//      EbookResp ebookResp = CopyUtils.copy(ebook, EbookResp.class);
//      respList.add(ebookResp);
//    }

    //列表复制
    List<EbookResp> respList = CopyUtils.copyList(ebookList, EbookResp.class);

    PageResp<EbookResp> pageResp = new PageResp<>();
//    pageResp.setTotal(PageInfo.getTotal());
    pageResp.setRespList(respList);

    return pageResp;

  }







}
