package com.qf.Controller;

import com.qf.VO.ResultVO;
import com.qf.service.CategroyService;
import com.qf.service.IndexImgService;
import com.qf.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/index")
@CrossOrigin
@Api(value = "提供首页数据显示的所需接口",tags = "首页管理")
public class IndexController {
    @Autowired
    private CategroyService categroyServiceimpl;

    @Autowired
    private IndexImgService imgService;

    @Autowired
    private ProductService productService;
    @ApiOperation("首页轮播图接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam()
//    })
    @GetMapping("/indeximg")

    public ResultVO listIndexImg(){
        System.out.println("indeximg");
       return imgService.ListIndexImg();
    }
    @GetMapping("/category-list")
    @ApiOperation("商品分类的查询接口")
    public ResultVO listCategory(){
        ResultVO resultVO = categroyServiceimpl.selectCategroy();
        return resultVO;
    }
    @GetMapping("/list-recommends")
    @ApiOperation("新品推荐商品的接口")
    public ResultVO listRecommendPrducts(){
        ResultVO resultVO = productService.listRecommendProducts();

        return resultVO;

    }
    @GetMapping("/category-recommends")
    @ApiOperation("一级分类推荐商品的接口")
    public ResultVO listRecommendProduceByCategory(){
        ResultVO resultVO = categroyServiceimpl.selectFirstCategroy();
        return resultVO;

    }

}
