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
        beerSeriesTag.setBrand("迷失海岸");
        beerSeriesTag.setName("迷失海岸美国进口精酿啤酒巧克力牛奶花生酱迷雾快艇幽灵浑浊IPA美国原装进口 17种口味可选 355ml 单瓶");
        beerSeriesTag.setLastBrand("迷失海岸");
        beerSeriesTag.setFirstKeyword("花生巧克力牛奶世涛");
        beerSeriesTag.setSecondKeyword("花生");
        beerSeriesTag.setThirdKeyword("巧克力");
        beerSeriesTag.setFourthKeyword("牛奶");
        beerSeriesTag.setMappedValue("花生巧克力牛奶世涛");
        System.out.println(beerSeriesTag);

        //String tag = beerSeriesTagService.findSingleBeerSeriesTag(beerSeriesTag);
        String tag = beerSeriesTagService.findTag(beerSeriesTag);

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

    @Test
    void testFindTag(){

        BeerSeriesTag beerSeriesTag = new BeerSeriesTag();
        beerSeriesTag.setBrand("雪花");
        beerSeriesTag.setName("雪花啤酒8°清爽啤酒330ml*24听 罐装整箱麦芽酿制 武汉满百包邮");
        beerSeriesTag.setLastBrand("雪花");
        beerSeriesTag.setFirstKeyword("8度");
        beerSeriesTag.setSecondKeyword("8°");
        beerSeriesTag.setThirdKeyword(null);
        beerSeriesTag.setFourthKeyword(null);
        beerSeriesTag.setMappedValue("清爽");
        System.out.println(beerSeriesTag);
        String tag = beerSeriesTagService.findTag(beerSeriesTag);
        System.out.println(tag);
    }

}
