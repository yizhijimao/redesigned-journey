package com.qf.service;

import com.qf.VO.ResultVO;
import com.qf.beans.CategoryVO;

import java.util.List;

public interface CategroyService {
    public ResultVO selectCategroy();

    //查询1级类别  包含商品推荐 （首页的商品推荐接口）
    public ResultVO selectFirstCategroy();
}
