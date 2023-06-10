package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;

public class ExcelDataListener extends AnalysisEventListener<ExcelData> {


    private List<ExcelData> excelDataList=null;

    public void setExcelDataList(List<ExcelData> excelDataList) {
        this.excelDataList = excelDataList;
    }

    public List<ExcelData> getExcelDataList() {
        return excelDataList;
    }
    @Override
    public void invoke(ExcelData excelData, AnalysisContext context) {
        excelDataList.add(excelData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
