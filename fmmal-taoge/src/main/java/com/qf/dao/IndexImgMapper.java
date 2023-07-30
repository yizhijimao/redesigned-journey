package com.qf.dao;

import com.qf.beans.IndexImg;
import com.qf.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Deprecated
@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {
    //1 查询轮播图信息: 查询status=1 且 按照seq来进行排序

    public List<IndexImg> listIndexImgs();



}