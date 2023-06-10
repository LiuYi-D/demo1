package com.liuyi.demo1.mapper;

import com.liuyi.demo1.pojo.BeerSeriesTag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BeerSeriesTagMapperTest {
    @Autowired
    private BeerSeriesTagMapper beerSeriesTagMapper;
    @Test
    void testFindAll() {

        List<BeerSeriesTag> all = beerSeriesTagMapper.findAll();
        System.out.println(all);
    }
    @Test
    void testFindById(){
        BeerSeriesTag beerSeriesTag1 = beerSeriesTagMapper.findById(1);
        System.out.println(beerSeriesTag1);
    }
    @Test
    void testUpdateSeriesById(){
        String series = "sg a";
        Integer id = 2;
        System.out.println("更新前 "+beerSeriesTagMapper.findById(id));
        beerSeriesTagMapper.updateSeriesById(series, id);
        System.out.println("更新后 "+beerSeriesTagMapper.findById(id));
    }
    @Test
    void testSetSeriesNull(){
        beerSeriesTagMapper.setSeriesNull();
    }

}
