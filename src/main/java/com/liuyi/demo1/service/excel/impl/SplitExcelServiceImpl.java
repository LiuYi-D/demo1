package com.liuyi.demo1.service.excel.impl;

import com.alibaba.excel.EasyExcel;
import com.liuyi.demo1.pojo.excel.ExcelData;
import com.liuyi.demo1.pojo.excel.ExcelDataListener;
import com.liuyi.demo1.pojo.excel.ExcelDataSplitListener;
import com.liuyi.demo1.service.excel.SplitExcelService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SplitExcelServiceImpl implements SplitExcelService {

    /**
     * 把目标位置的excel  按照column分裂
     * 根据column的种类  column相同的实例，放入到同一个List  实例的column不同，放入的List也不同
     * 最后，将所有的List放入一个新的List中
     *
     * @param path   目标位置
     * @param column  按column分裂
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public List<List> getSplitExcels(String path, String column) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        
        //获取所有数据
        ExcelDataListener excelDataListener = new ExcelDataListener();
        excelDataListener.setExcelDataList(new ArrayList<ExcelData>());
        EasyExcel.read(path, ExcelData.class,excelDataListener).sheet().doRead();
        List<ExcelData> excelDataList = excelDataListener.getExcelDataList();

        //column映射 由column拿到实例类中对应的属性名
        HashMap<String, String> columnMap = new HashMap<>();
        columnMap.put("平台名称","getPlatForm");
        columnMap.put("大区","getRegion");
        columnMap.put("城市","getCity");

        //map的作用是存入column  如16个大区会存入16个key value值为 List在Lists中的索引
        HashMap<String, Integer> map = new HashMap<>();
        int num = 0;
        List<List> lists = new ArrayList<>();
        for (ExcelData excelDate:
                excelDataList) {
            if(!columnMap.containsKey(column)){
                throw new RuntimeException("没有该列名或该列名不能作为分割条件");
            }
            //通过反射调用该对象的get方法
            Method method = ExcelData.class.getMethod(columnMap.get(column));
            String res = (String)method.invoke(excelDate);

            //对于获取到的结果，不在map中就加入并创建List，在map就直接加入相对应的List
            if(!map.containsKey(res)){
                map.put(res,num);
                ArrayList<ExcelData> datas = new ArrayList<>();
                datas.add(excelDate);
                lists.add(num,datas);
                num++;
            }else {
                List datas = lists.get(map.get(res));
                datas.add(excelDate);
                lists.set(map.get(res),datas);
            }

        }
        //System.out.println(lists.get(0));


        return lists;
    }

    @Override
    public List<List> getSplitExcels(InputStream inputStream, String column) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取所有数据
        ExcelDataListener excelDataListener = new ExcelDataListener();
        excelDataListener.setExcelDataList(new ArrayList<ExcelData>());
        EasyExcel.read(inputStream, ExcelData.class,excelDataListener).sheet().doRead();
        List<ExcelData> excelDataList = excelDataListener.getExcelDataList();

        //column映射 由column拿到实例类中对应的属性名
        HashMap<String, String> columnMap = new HashMap<>();
        columnMap.put("平台名称","getPlatForm");
        columnMap.put("大区","getRegion");
        columnMap.put("城市","getCity");

        //map的作用是存入column  如16个大区会存入16个key value值为 List在Lists中的索引
        HashMap<String, Integer> map = new HashMap<>();
        int num = 0;
        List<List> lists = new ArrayList<>();
        for (ExcelData excelDate:
                excelDataList) {
            if(!columnMap.containsKey(column)){
                throw new RuntimeException("没有该列名或该列名不能作为分割条件");
            }
            //通过反射调用该对象的get方法
            Method method = ExcelData.class.getMethod(columnMap.get(column));
            String res = (String)method.invoke(excelDate);

            //对于获取到的结果，不在map中就加入并创建List，在map就直接加入相对应的List
            if(!map.containsKey(res)){
                map.put(res,num);
                ArrayList<ExcelData> datas = new ArrayList<>();
                datas.add(excelDate);
                lists.add(num,datas);
                num++;
            }else {
                List datas = lists.get(map.get(res));
                datas.add(excelDate);
                lists.set(map.get(res),datas);
            }

        }
        //System.out.println(lists.get(0));
        return lists;
    }

    /**
     * 把数据写入对应路径的excel文件
     * @param filepath  路径名
     * @param datas     写入的数据
     */
    @Override
    public void write(String filepath, List<ExcelData> datas) {
        EasyExcel.write(filepath, ExcelData.class).sheet().doWrite(datas);
    }

    @Override
    public List<List> testSplitByHead(InputStream inputStream, String column) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        //获取headMap
        ExcelDataSplitListener excelDataSplitListener = new ExcelDataSplitListener();
        excelDataSplitListener.setExcelDataList(new ArrayList<ExcelData>());
        EasyExcel.read(inputStream, ExcelData.class,excelDataSplitListener).sheet().doRead();
        Map<String, Integer> headMap = excelDataSplitListener.getMapInformation();
        List<ExcelData> excelDataList = excelDataSplitListener.getExcelDataList();
        //获取所有数据
//        ExcelDataListener excelDataListener = new ExcelDataListener();
//        excelDataListener.setExcelDataList(new ArrayList<ExcelData>());
//        EasyExcel.read(path, ExcelData.class,excelDataListener).sheet().doRead();
//        List<ExcelData> excelDataList = excelDataListener.getExcelDataList();



        //映射
        Field[] fields = ExcelData.class.getDeclaredFields();
        Integer index = headMap.get(column);
        String field = fields[index].toString();
        String  attribute = field.substring(field.lastIndexOf(".")+1);
        char[] cs=attribute.toCharArray();
        cs[0]-=32;
        String methodName = "get"+String.valueOf(cs);


        //map的作用是存入column  如16个大区会存入16个key value值为 List在Lists中的索引
        HashMap<String, Integer> map = new HashMap<>();
        int num = 0;
        List<List> lists = new ArrayList<>();
        for (ExcelData excelDate:
                excelDataList) {

            //通过反射调用该对象的get方法
            Method method = ExcelData.class.getMethod(methodName);
            String res = (String)method.invoke(excelDate);

            //对于获取到的结果，不在map中就加入并创建List，在map就直接加入相对应的List
            if(!map.containsKey(res)){
                map.put(res,num);
                ArrayList<ExcelData> datas = new ArrayList<>();
                datas.add(excelDate);
                lists.add(num,datas);
                num++;
            }else {
                List datas = lists.get(map.get(res));
                datas.add(excelDate);
                lists.set(map.get(res),datas);
            }

        }
        //System.out.println(lists.get(0));


        return lists;
    }


}
