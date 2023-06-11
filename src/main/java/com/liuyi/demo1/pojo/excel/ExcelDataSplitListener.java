package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.util.ConverterUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class ExcelDataSplitListener extends AnalysisEventListener<ExcelData> {
    private Map<String, Integer> mapInformation;
    private List<ExcelData> excelDataList;
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        Map<Integer, String> headmap = ConverterUtils.convertToStringMap(headMap, context);
        headmap.entrySet().removeIf(entry -> Objects.isNull(entry.getValue()));
        Map<String, Integer> newMap = headmap.entrySet().stream().collect(Collectors.toMap(entry -> entry.getValue(), entry -> entry.getKey()));
        this.mapInformation = newMap;
    }

    @Override
    public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
        excelDataList.add(excelData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
