package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SkuSource {
    @ExcelProperty(index = 0,value = "平台")
    private String platform;
    @ExcelProperty(index = 1,value = "关键词")
    private String keyword;
    @ExcelProperty(index = 2,value = "品类")
    private String itemCategory;
    @ExcelProperty(index = 3,value = "商品名称")
    private String itemName;
    @ExcelProperty(index = 4,value = "商品id")
    private String itemId;
    @ExcelProperty(index = 5,value = "商品链接")
    private String itemUrl;
    @ExcelProperty(index = 6,value = "商品sku详情")
    private String skuDetails;
    @ExcelProperty(index = 7,value = "现价")
    private String priceNow;
    @ExcelProperty(index = 8,value = "原价")
    private String priceOriginal;
    @ExcelProperty(index = 9,value = "月销量")
    private String salesMonth;
    @ExcelProperty(index = 10,value = "评论数量")
    private String numCommends;
    @ExcelProperty(index = 11,value = "库存数量")
    private String numStock;
    @ExcelProperty(index = 12,value = "收藏数量")
    private String numCollections;
    @ExcelProperty(index = 13,value = "商品评分")
    private String itemScore;
    @ExcelProperty(index = 14,value = "商品状态")
    private String itemState;
    @ExcelProperty(index = 15,value = "发货地")
    private String placeDelivery;
    @ExcelProperty(index = 16,value = "促销信息")
    private String discountInformation;
    @ExcelProperty(index = 17,value = "商品描述")
    private String itemDescribe;
    @ExcelProperty(index = 18,value = "商品规格")
    private String itemNorms;
    @ExcelProperty(index = 19,value = "支付方式")
    private String payMethod;
    @ExcelProperty(index = 20,value = "服务承诺")
    private String serviceCommit;
    @ExcelProperty(index = 21,value = "店铺名称")
    private String storeName;
    @ExcelProperty(index = 22,value = "店铺评分")
    private String storeScore;
    @ExcelProperty(index = 23,value = "店铺id")
    private String storeId;
    @ExcelProperty(index = 24,value = "店铺链接")
    private String storeUrl;
    @ExcelProperty(index = 25,value = "商品详情")
    private String itemDetails;
    @ExcelProperty(index = 26,value = "品牌")
    private String brand;
    @ExcelProperty(index = 27,value = "商品主图")
    private String itemMainPicture;
    @ExcelProperty(index = 28,value = "商品详图")
    private String itemDetailPicture;
    @ExcelProperty(index = 29,value = "粉丝数")
    private String starsNum;
    @ExcelProperty(index = 30,value = "旺旺id")
    private String wwId;
    @ExcelProperty(index = 31,value = "旺旺名称")
    private String wwName;



}
