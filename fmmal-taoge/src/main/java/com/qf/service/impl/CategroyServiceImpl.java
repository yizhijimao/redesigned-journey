package com.qf.service.impl;

import com.qf.VO.ResultVO;
import com.qf.beans.CategoryVO;
import com.qf.dao.CategoryMapper;
import com.qf.service.CategroyService;
import com.qf.utils.ResStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Deprecated
public class CategroyServiceImpl implements CategroyService {

    @Autowired
    private CategoryMapper categoryMapper;//首页商品分类的Mapper

    /**
     * 查询分类的列表功能（包含整个分类中的所有分类内容）
     * @return
     */
    @Override
    public ResultVO selectCategroy() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        if (categoryVOS.isEmpty()) {
            return new ResultVO<>(ResStatus.NO,"failed",null);
        }else {
            return new ResultVO(ResStatus.OK,"success",categoryVOS);
        }
    }
    /**
     *查询分类列表功能（只包含一级列表），同时查询当前一级分类销量最高的6个商品
     * @return
     */
    @Override
    public ResultVO selectFirstCategroy() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstCategories();
        if(categoryVOS.isEmpty()){
            return new ResultVO<>(ResStatus.NO,"failed",null);
        }else {
            return new ResultVO(ResStatus.OK,"success",categoryVOS);
        }
    }
}
