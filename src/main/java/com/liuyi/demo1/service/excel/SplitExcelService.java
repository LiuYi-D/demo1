package com.liuyi.demo1.service.excel;

import com.liuyi.demo1.pojo.excel.ExcelData;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface SplitExcelService {
    public List<List> getSplitExcels(String path, String column) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    public void write(String filepath, List<ExcelData> datas);

    public List<List> getSplitExcels(InputStream inputStream, String column) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
