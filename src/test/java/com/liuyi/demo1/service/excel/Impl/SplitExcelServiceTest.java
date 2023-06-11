package com.liuyi.demo1.service.excel.Impl;

import com.alibaba.excel.EasyExcel;
import com.liuyi.demo1.pojo.excel.ExcelData;
import com.liuyi.demo1.pojo.excel.ExcelDataHeadListener;
import com.liuyi.demo1.service.excel.SplitExcelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SplitExcelServiceTest {
    @Autowired
    private SplitExcelService splitExcelService;

    @Test
    public void testGetSplitExcels() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String path = "F:\\test2.xlsx";
        File file = new File(path);
        String name = "大区";
        String name2 = "城市";
        List<List> splitExcels = splitExcelService.getSplitExcels(path,name2);
        System.out.println(splitExcels);
    }
    @Test
    public void testWrite(){
        String path =  "F:\\123.xlsx";
        List<ExcelData> excelData = new ArrayList<>();
        ExcelData data1 = new ExcelData("1322","1321","2222","222","222","222","222","222","222");
        ExcelData data2 = new ExcelData("1111","1111","1111","1111","1111","1111","222","222","222");
        ExcelData data3 = new ExcelData("333","333","333","333","333","333","333","222","222");
        ExcelData data4 = new ExcelData("555","1355521","2555222","555","555","222","222","222","222");
        excelData.add(data1);
        excelData.add(data2);
        excelData.add(data3);
        excelData.add(data4);
        splitExcelService.write(path,excelData);

    }

    @Test
    public void testHead(){
        String fileName = "F:\\test3.xlsx";
        EasyExcel.read(fileName, ExcelData.class,new ExcelDataHeadListener()).sheet().doRead();
    }

    @Test
    public void testFiled() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        Field[] fields = ExcelData.class.getDeclaredFields();
//        System.out.println(fields[0]);

//        String path = "F:\\test3.xlsx";
//        File file = new File(path);
//        String name = "大区";
//        String name2 = "城市";
//        List<List> splitExcels = splitExcelService.testSplitByHead(path,name2);
//        System.out.println(splitExcels);
    }
}
