package com.xiaoxiaoning.demo.response;

import java.util.List;

/**
 * Created by xiaoxiaoning on 2021/3/28 9:25 上午
 */


public class PageResp<T> {
  private long total;
  private List<T> respList;

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public List<T> getRespList() {
    return respList;
  }

  public void setRespList(List<T> respList) {
    this.respList = respList;
  }
}
