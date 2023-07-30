package com.qf.dao;

import com.qf.beans.ProductImg;
import com.qf.general.GeneralDAO;

import java.util.List;

public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    public List<ProductImg> selectProductImgByproductId(int productId);
}