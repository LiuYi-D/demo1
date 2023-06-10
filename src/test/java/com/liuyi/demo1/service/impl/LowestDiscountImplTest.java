package com.liuyi.demo1.service.impl;

import com.liuyi.demo1.service.LowestDiscountSevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class LowestDiscountImplTest {
    @Autowired
    private LowestDiscountSevice lowestDiscountSevice;

    @Test
    void testGetDiscount(){
        String information = "购买至少1件时可享受优惠,满2149元减130元";
        Set<String> informations = lowestDiscountSevice.getDiscount(information);
        System.out.println(informations);
    }
    @Test
    void testGetIntByString(){
        String s = "满1999元减60";
        float[] fullReduction = lowestDiscountSevice.getIntByString(s);
        System.out.println(fullReduction[0]+"  "+fullReduction[1]);

    }

    @Test
    void testGetLowest(){
        float price = 440f;
        String information = "购买至少1件时可享受优惠\n";
        Float lowest = lowestDiscountSevice.getLowest(price, information);
        System.out.println(lowest);
    }
}
