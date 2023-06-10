package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;

public class SkuSourceListener extends AnalysisEventListener<SkuSource> {


    private List<SkuSource> skuSourceList;

    public List<SkuSource> getSkuSourceList() {
        return skuSourceList;
    }

    public void setSkuSourceList(List<SkuSource> skuSourceList) {
        this.skuSourceList = skuSourceList;
    }

    @Override
    public void invoke(SkuSource skuSource, AnalysisContext analysisContext) {
        skuSourceList.add(skuSource);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
