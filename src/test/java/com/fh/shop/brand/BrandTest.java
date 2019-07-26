package com.fh.shop.brand;

import com.fh.shop.mapper.brand.BrandMapper;
import com.fh.shop.po.brand.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common.xml"})
public class BrandTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void addTest(){
        Brand brand = new Brand();
        brand.setBrandName("llll");
        brandMapper.insert(brand);
    }

    @Test
    public void queryTest(){
        List<Brand> listBrandId = brandMapper.selectList(null);
        System.out.println(listBrandId);
    }
}
