package com.liuyi.demo1.service.impl;

import com.liuyi.demo1.service.NumMatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumMatchServiceImplTest {
    @Autowired
    private NumMatchService numMatchService;

    @Test
    void testGetNumByName(){
        String s1 = "泰山传说官方经典正品德式进口工艺酿造世涛黑啤酒1升*12桶装包邮泡沫丰富饱满口味持久浓郁甘甜爽口营养丰富";
        String s2 = "青岛特产精酿原浆啤酒全麦白啤蓝宝石酿酒师浑浊2升桶装促销包邮";
        String s3 = "(1.35L*6桶)俄罗斯进口波罗的海远东古典啤酒 远东烈性啤酒 大麦黄啤整箱啤酒 远东古典1.35升*6桶(口感适中)";
        String s4 = "自由落体哈密瓜水果艾尔国产精酿果啤微醺酒果味酒女士低度酒饮料";
        Integer num1 = numMatchService.getNumByName(s1);
        Integer num2 = numMatchService.getNumByName(s2);
        Integer num3 = numMatchService.getNumByName(s3);
        Integer num4 = numMatchService.getNumByName(s4);
        System.out.println("num1 = "+num1 + " num2 = " +num2 + " num3 = "+num3+" num4 = "+num4);

    }

}
