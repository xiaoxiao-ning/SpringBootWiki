package com.xiaoxiaoning.demo.request;

/**
 * Created by xiaoxiaoning on 2021/3/28 9:25 上午
 */


public class PageReq {
    private int page;
    private int size;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "PageReq{" +
            "page=" + page +
            ", size=" + size +
            '}';
  }
}
