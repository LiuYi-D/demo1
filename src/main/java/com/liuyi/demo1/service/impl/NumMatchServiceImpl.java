package com.liuyi.demo1.service.impl;

import com.liuyi.demo1.service.NumMatchService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NumMatchServiceImpl implements NumMatchService {
    /**
     * 通过商品名称提取单量
     * @param name 商品名称
     * @return 单量
     */
    @Override
    public Integer getNumByName(String name) {
        //numUnit用来存储匹配到的字符串
        String numUnit = "";

        //把商品名称中的大写转换为小写  (ML,Ml,mL) -> ml   L -> l
        String lowerCase = name.toLowerCase();

        //正则匹配
        Pattern pattern = Pattern.compile("[1-9]\\d*\\.?\\d*(ml|l|升|毫升)");
        Matcher matcher = pattern.matcher(lowerCase);

        //如果匹配到就赋给numUnit 否则就返回0
        if(matcher.find()){
            numUnit = matcher.group();
        }else {
            return 0;
        }

        //strNum为容量数字  strUnit为容量单位
        String strNum = "";
        String strUnit = "";

        //提取数字和单位
        if (numUnit != null && !"".equals(numUnit)){
            for (int i=0;i<numUnit.length();i++){
                if((numUnit.charAt(i)>=48 && numUnit.charAt(i)<=57) | numUnit.charAt(i)==46){
                    strNum += numUnit.charAt(i);
                }else {
                    strUnit += numUnit.charAt(i);
                }
            }
        }

        //将数字由字符串转换为浮点数
        //调用自定义unitConversion()方法 将单位换算  ml -> 1   l -> 1000
        //最后强制转换浮点数为整数 并返回
        return (int)(Float.parseFloat(strNum)*unitConversion(strUnit));

    }



    /**
     * 单位转换为毫升
     * @param unit
     * @return
     */
    public Integer unitConversion(String unit){
        Map<String, Integer> map = new HashMap<>();
        map.put("ml",1);
        map.put("l",1000);
        map.put("毫升",1);
        map.put("升",1000);

        return map.get(unit);

    }
}
