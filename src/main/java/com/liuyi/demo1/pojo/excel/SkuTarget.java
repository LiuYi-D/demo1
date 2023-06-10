package com.liuyi.demo1.pojo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SkuTarget {
    @ExcelProperty(value = "平台")
    private String platform;
    @ExcelProperty(value = "关键词")
    private String keyword;
    @ExcelProperty(value = "品类")
    private String itemCategory;
    @ExcelProperty(value = "商品名称")
    private String itemName;
    @ExcelProperty(value = "商品id")
    private String itemId;
    @ExcelProperty(value = "商品链接")
    private String itemUrl;
    @ExcelProperty(value = "sku_id")
    private String skuId;
    @ExcelProperty(value = "sku名称")
    private String skuName;
    @ExcelProperty(value = "sku现价")
    private String skuPriceNow;
    @ExcelProperty(value = "sku原价")
    private String skuPriceOriginal;
    @ExcelProperty(value = "sku库存")
    private String skuStock;
    @ExcelProperty(value = "现价")
    private String priceNow;
    @ExcelProperty(value = "原价")
    private String priceOriginal;
    @ExcelProperty(value = "月销量")
    private String salesMonth;
    @ExcelProperty(value = "评论数量")
    private String numCommends;
    @ExcelProperty(value = "库存数量")
    private String numStock;
    @ExcelProperty(value = "收藏数量")
    private String numCollections;
    @ExcelProperty(value = "商品评分")
    private String itemScore;
    @ExcelProperty(value = "商品状态")
    private String itemState;
    @ExcelProperty(value = "发货地")
    private String placeDelivery;
    @ExcelProperty(value = "促销信息")
    private String discountInformation;
    @ExcelProperty(value = "商品描述")
    private String itemDescribe;
    @ExcelProperty(value = "商品规格")
    private String itemNorms;
    @ExcelProperty(value = "支付方式")
    private String payMethod;
    @ExcelProperty(value = "服务承诺")
    private String serviceCommit;
    @ExcelProperty(value = "店铺名称")
    private String storeName;
    @ExcelProperty(value = "店铺评分")
    private String storeScore;
    @ExcelProperty(value = "店铺id")
    private String storeId;
    @ExcelProperty(value = "店铺链接")
    private String storeUrl;
    @ExcelProperty(value = "商品详情")
    private String itemDetails;
    @ExcelProperty(value = "品牌")
    private String brand;
    @ExcelProperty(value = "商品主图")
    private String itemMainPicture;
    @ExcelProperty(value = "商品详图")
    private String itemDetailPicture;
    @ExcelProperty(value = "粉丝数")
    private String starsNum;
    @ExcelProperty(value = "旺旺id")
    private String wwId;
    @ExcelProperty(value = "旺旺名称")
    private String wwName;
    public SkuTarget() {
    }

    public SkuTarget(String platform, String keyword, String itemCategory, String itemName, String itemId, String itemUrl, String skuId, String skuName, String skuPriceNow, String skuPriceOriginal, String skuStock, String priceNow, String priceOriginal, String salesMonth, String numCommends, String numStock, String numCollections, String itemScore, String itemState, String placeDelivery, String discountInformation, String itemDescribe, String itemNorms, String payMethod, String serviceCommit, String storeName, String storeScore, String storeId, String storeUrl, String itemDetails, String brand, String itemMainPicture, String itemDetailPicture, String starsNum, String wwId, String wwName) {
        this.platform = platform;
        this.keyword = keyword;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemUrl = itemUrl;
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPriceNow = skuPriceNow;
        this.skuPriceOriginal = skuPriceOriginal;
        this.skuStock = skuStock;
        this.priceNow = priceNow;
        this.priceOriginal = priceOriginal;
        this.salesMonth = salesMonth;
        this.numCommends = numCommends;
        this.numStock = numStock;
        this.numCollections = numCollections;
        this.itemScore = itemScore;
        this.itemState = itemState;
        this.placeDelivery = placeDelivery;
        this.discountInformation = discountInformation;
        this.itemDescribe = itemDescribe;
        this.itemNorms = itemNorms;
        this.payMethod = payMethod;
        this.serviceCommit = serviceCommit;
        this.storeName = storeName;
        this.storeScore = storeScore;
        this.storeId = storeId;
        this.storeUrl = storeUrl;
        this.itemDetails = itemDetails;
        this.brand = brand;
        this.itemMainPicture = itemMainPicture;
        this.itemDetailPicture = itemDetailPicture;
        this.starsNum = starsNum;
        this.wwId = wwId;
        this.wwName = wwName;
    }


}
