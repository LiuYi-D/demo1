package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ExcelData {
    @ExcelProperty(index = 0,value = "查价时间")
    private String selectTime;
    @ExcelProperty(index = 1,value = "平台名称")
    private String platForm;
    @ExcelProperty(index = 2,value = "大区")
    private String region;
    @ExcelProperty(index = 3,value = "城市")
    private String city;
    @ExcelProperty(index = 4,value = "单价")
    private String price;
    @ExcelProperty(index = 5,value = "到手价")
    private String lastPrice;
    @ExcelProperty(index = 6,value = "差价")
    private String gapPrice;
    @ExcelProperty(index = 7,value = "查价时间")
    private String productDate;
    @ExcelProperty(index = 8,value = "限购件数")
    private String quotaNum;

    public ExcelData() {
    }

    public ExcelData(String selectTime, String platForm, String region, String city, String price, String lastPrice, String gapPrice, String productDate, String quotaNum) {
        this.selectTime = selectTime;
        this.platForm = platForm;
        this.region = region;
        this.city = city;
        this.price = price;
        this.lastPrice = lastPrice;
        this.gapPrice = gapPrice;
        this.productDate = productDate;
        this.quotaNum=quotaNum;
    }
}
