package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.util.ConverterUtils;
import com.alibaba.fastjson.JSON;

import java.util.Map;

public class ExcelDataHeadListener extends AnalysisEventListener<ExcelData> {
    @Override
    public void invoke(ExcelData excelData, AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {

        Map<Integer, String> map = ConverterUtils.convertToStringMap(headMap, context);
        System.out.println(JSON.toJSONString(map));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
