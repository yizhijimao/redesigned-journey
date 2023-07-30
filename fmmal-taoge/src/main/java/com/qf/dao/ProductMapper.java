package com.qf.dao;

import com.qf.beans.Product;
import com.qf.beans.ProductVO;
import com.qf.general.GeneralDAO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Deprecated
public interface ProductMapper extends GeneralDAO<Product> {

    //@Select("SELECT * FROM product ORDER BY create_time DESC LIMIT 0,3\n")
    public List<ProductVO> selectRecommendProducts();


    //查询指定一级类别下销量最高的6个商品

    /**
     *
     * @param categoryId
     * @return
     *查询指定一级类别下销量最高的6个商品
     */
    public List<ProductVO> selectTop6ByCategory(int categoryId);
}