package com.qf.service.impl;

import com.qf.VO.ResultVO;
import com.qf.beans.IndexImg;
import com.qf.dao.IndexImgMapper;
import com.qf.service.IndexImgService;
import com.qf.utils.ResStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper imgMapper;


    public ResultVO ListIndexImg() {
        List<IndexImg> indexImgs = imgMapper.listIndexImgs();
        if(indexImgs.size() == 0){
            return new  ResultVO(ResStatus.NO,"fail",null);
        }else{
            return new ResultVO(ResStatus.OK,"success",indexImgs);
        }


    }
}
