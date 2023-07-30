package com.qf.service.impl;


import com.qf.VO.ResultVO;
import com.qf.beans.ProductVO;
import com.qf.dao.ProductMapper;
import com.qf.service.ProductService;
import com.qf.utils.ResStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Deprecated
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

//推荐商品的业务逻辑层面代码
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();

        return new ResultVO<>(ResStatus.OK,"success",productVOS);
    }
}
