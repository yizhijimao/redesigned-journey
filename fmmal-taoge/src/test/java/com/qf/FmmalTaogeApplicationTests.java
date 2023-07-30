package com.qf;

import com.qf.beans.Category;
import com.qf.beans.CategoryVO;
import com.qf.beans.ProductVO;
import com.qf.beans.Users;
import com.qf.dao.CategoryMapper;
import com.qf.dao.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FmmalTaogeApplication.class)
class FmmalTaogeApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Test
    void testselectFirstLevelCategory(){
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstCategories();
        for (CategoryVO c: categoryVOS ) {
            System.out.println(c);
        }
    }

    @Test
    void testProductAndProductImg(){
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO c : productVOS) {
            System.out.println(c);
        }


    }
    @Test
    void text() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel", 1);

        List<Category> categories = categoryMapper.selectByExample(example);
        for (Category a : categories
        ) {
            System.out.println(a);
        }

    }

    @Test
    void contextLoads() {
//                List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
//        for (CategoryVO c1:categoryVOS ) {
//            System.out.println(c1);
//            for (CategoryVO c2:c1.getCategories()) {
//                System.out.println("\t"+c2);
//                for (CategoryVO c3: c2.getCategories() ) {
//                    System.out.println("\t\t"+c3);
//                }
//            }
//        }
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
        for (CategoryVO c1 : categoryVOS) {
            System.out.println(c1);
            for (CategoryVO c2 : c1.getCategories()) {
                System.out.println("\t" + c2);
                for (CategoryVO c3 : c2.getCategories()) {
                    System.out.println("\t\t" + c3);
                    }
                }
            }
        }


}



