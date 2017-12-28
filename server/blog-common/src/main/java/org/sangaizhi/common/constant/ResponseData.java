package org.sangaizhi.common.constant;

import org.sangaizhi.common.vo.Paginate;

import java.io.Serializable;
import java.util.List;

/**
 * 响应数据
 * @author sangaizhi
 * @date 2017/9/20
 */
public class ResponseData implements Serializable {

    private List list;
    private Paginate page;

    public ResponseData(){}
    public ResponseData(List list, Paginate paginate){
        this.list = list;
        this.page = paginate;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Paginate getPage() {
        return page;
    }

    public void setPage(Paginate page) {
        this.page = page;
    }
}