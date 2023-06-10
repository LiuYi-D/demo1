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
        String information = "购买1-3件时享受单件价¥1969，超出数量以结算价为准,满399";
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
        float price = 1969.00f;
        String information = "购买1-3件时享受单件价¥1969，超出数量以结算价为准,满399减10";
        Float lowest = lowestDiscountSevice.getLowest(price, information);
        System.out.println(lowest);
    }
}
