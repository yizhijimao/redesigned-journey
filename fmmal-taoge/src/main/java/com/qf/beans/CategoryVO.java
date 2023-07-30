package com.qf.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
/**
 * 封装了分类与商品详情的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Deprecated

public class CategoryVO {
    private Integer categoryId;
    private String categoryName;
    private Integer categoryLevel;
    private Integer parentId;
    private String categoryIcon;
    private String categorySlogan;
    private String categoryPic;
    private String categoryBgColor;
    //实现首页的类别显示
    private List<CategoryVO> categories;
    //实现首页分类商品推荐
    private List<ProductVO> products;


}
