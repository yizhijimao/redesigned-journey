package com.qf.dao;

import com.qf.beans.Category;
import com.qf.beans.CategoryVO;
import com.qf.general.GeneralDAO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
@Deprecated
public interface CategoryMapper extends GeneralDAO<Category> {

//1.连接查询
    public List<CategoryVO> selectAllCategories();

//2子查询
    public List<CategoryVO> selectAllCategories2(int parentId);
//查询一级类别
    public List<CategoryVO> selectFirstCategories();
}