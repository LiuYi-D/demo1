package com.liuyi.demo1.service.impl;

import com.liuyi.demo1.pojo.BeerSeriesTag;
import com.liuyi.demo1.service.BeerSeriesTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BeerSeriesTagServiceImplTest {
    @Autowired
    private BeerSeriesTagService beerSeriesTagService;

    @Test
    void testFindAll(){
        List<BeerSeriesTag> all = beerSeriesTagService.findAll();
        for (BeerSeriesTag b:
             all) {
            System.out.println(b);
        }
    }
    @Test
    void testFindSingleTag(){
        BeerSeriesTag beerSeriesTag = new BeerSeriesTag();
        beerSeriesTag.setBrand("雪花");
        beerSeriesTag.setName("**********SNOW雪花纯生啤酒8度500ml*12罐匠心营造易拉罐装整箱黄啤酒 500mL*12瓶");
        beerSeriesTag.setFirstKeyword("8度");
        beerSeriesTag.setMappedValue("花生巧克力牛奶世涛");
        beerSeriesTag.setSecondKeyword(null);
        beerSeriesTag.setThirdKeyword(null);
        beerSeriesTag.setLastBrand("雪花");
        System.out.println(beerSeriesTag);
        String tag = beerSeriesTagService.findSingleBeerSeriesTag(beerSeriesTag);
        System.out.println(tag);
    }

    @Test
    void testSetSeriesNull(){
        beerSeriesTagService.setSeriesNull();
    }
    @Test
    void testUpdateAll(){
        Integer sum = beerSeriesTagService.updateAll();
        System.out.println("执行成功了"+sum+"条");
    }

}
