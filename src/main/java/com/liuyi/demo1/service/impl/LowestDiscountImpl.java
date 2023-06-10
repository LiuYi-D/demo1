package com.liuyi.demo1.service.impl;

import com.liuyi.demo1.service.LowestDiscountSevice;
import com.liuyi.demo1.service.LowestDiscountSevice;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LowestDiscountImpl implements LowestDiscountSevice {
    /**
     * 计算满减后的最低单价
     * @param price  页面价格
     * @param information 促销信息
     * @return  最低单价
     */
    @Override
    public Float getLowest(Float price, String information) {

        //从information中 获取所有的满减信息
        Set<String> discounts = getDiscount(information);
        if (discounts.isEmpty()){
            return price;
        }
        //遍历所有的满减信息，并将最低单价保存在lowest
        float lowest = price;
        for (String discount:
             discounts) {
            int num = 1;
            float[] fullReduction = getIntByString(discount);
            while (num*price<fullReduction[0]){
                num++;
            }
            float sum = num*price-fullReduction[1];
            if(lowest > sum/num){
                lowest = sum/num;
            }
        }
        return lowest;
    }

    /**
     * 由字符串information 提取所有的满减信息
     * @param information 促销信息
     * @return 存有所有满减信息的Set
     */
    @Override
    public Set<String> getDiscount(String information) {

        //正则匹配促销信息
        Pattern pattern = Pattern.compile("满[1-9]\\d*\\.?\\d*元?减\\d*\\.?\\d*");
        Matcher matcher = pattern.matcher(information);

        //存入Set
        Set<String> informations = new HashSet<>();
        while(matcher.find()){
            informations.add(matcher.group());
        }

        return informations;
    }

    /**
     * 把满减信息字符串转化为数组信息
     * 如：  满100减10  ->  [100,10]
     *      满1999元减50  -> [1999,50]
     * @param information  满减信息字符串
     * @return 满减信息数组
     */
    @Override
    public float[] getIntByString(String information) {
        //创建浮点数组 存储满减信息
        float[] fullReduction = new float[2];

        //字符串处理
        String[] split = information.split("减");
        String full = "";
        String redution = "";
        for (int i=0;i<split[0].length();i++) {
            if ((split[0].charAt(i) >= 48 && split[0].charAt(i) <= 57) | split[0].charAt(i) == 46) {
                full += split[0].charAt(i);
            }
        }
        for (int i=0;i<split[1].length();i++) {
            if ((split[1].charAt(i) >= 48 && split[1].charAt(i) <= 57) | split[1].charAt(i) == 46) {
                redution += split[1].charAt(i);
            }
        }

        //第0位存储  满 金额
        //第1位存储  减 金额
        fullReduction[0] = Float.parseFloat(full);
        fullReduction[1] = Float.parseFloat(redution);
        return fullReduction;

    }
}
