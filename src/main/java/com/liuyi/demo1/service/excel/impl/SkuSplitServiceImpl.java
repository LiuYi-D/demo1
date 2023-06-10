package com.liuyi.demo1.service.excel.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liuyi.demo1.pojo.excel.SkuSource;
import com.liuyi.demo1.pojo.excel.SkuSourceListener;
import com.liuyi.demo1.pojo.excel.SkuTarget;
import com.liuyi.demo1.service.excel.SkuSplitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkuSplitServiceImpl implements SkuSplitService {
    /**
     * 把原位置的excel中的sku详情处理  并分裂后的excel写入目标位置
     * @param sourcePath  原位置的excel路径
     * @param targetPath    分裂后的excel路径
     * @return
     */
    @Override
    public String splitSku(String sourcePath,String targetPath) {
        //获取原文件信息
        SkuSourceListener skuSourceListener = new SkuSourceListener();
        skuSourceListener.setSkuSourceList(new ArrayList<SkuSource>());
        EasyExcel.read(sourcePath, SkuSource.class, skuSourceListener).sheet().doRead();
        List<SkuSource> skuSourceList = skuSourceListener.getSkuSourceList();

        //遍历所有sku 并封装成目标对象 写入到targetList中
        List<SkuTarget> targeList = new ArrayList<>();
        for (SkuSource skuSource:
                skuSourceList) {

            String sku = skuSource.getSkuDetails();
            JSONArray jsonArray = JSONArray.parseArray(sku);
            String skuId = "";
            String skuName = "";
            String skuPriceNow = "";
            String skuPriceOriginal = "";
            String skuStock = "";
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                skuId = jsonObject.getString("sku_id");
                skuName=jsonObject.getString("sku_name");
                skuPriceNow=jsonObject.getString("sku_current_price");
                skuPriceOriginal=jsonObject.getString("sku_original_price");
                skuStock=jsonObject.getString("sku_stock");
                SkuTarget target = new SkuTarget(skuSource.getPlatform(),
                        skuSource.getKeyword(),
                        skuSource.getItemCategory(),
                        skuSource.getItemName(),
                        skuSource.getItemId(),
                        skuSource.getItemUrl(),
                        skuId,
                        skuName,
                        skuPriceNow,
                        skuPriceOriginal,
                        skuStock,
                        skuSource.getPriceNow(),
                        skuSource.getPriceOriginal(),
                        skuSource.getSalesMonth(),
                        skuSource.getNumCommends(),
                        skuSource.getNumStock(),
                        skuSource.getNumCollections(),
                        skuSource.getItemScore(),
                        skuSource.getItemState(),
                        skuSource.getPlaceDelivery(),
                        skuSource.getDiscountInformation(),
                        skuSource.getItemDescribe(),
                        skuSource.getItemNorms(),
                        skuSource.getPayMethod(),
                        skuSource.getServiceCommit(),
                        skuSource.getStoreName(),
                        skuSource.getStoreScore(),
                        skuSource.getStoreId(),
                        skuSource.getStoreUrl(),
                        skuSource.getItemDetails(),
                        skuSource.getBrand(),
                        skuSource.getItemMainPicture(),
                        skuSource.getItemDetailPicture(),
                        skuSource.getStarsNum(),
                        skuSource.getWwId(),
                        skuSource.getWwName()
                );
                targeList.add(target);
            }


        }
        //写入excel
        EasyExcel.write(targetPath,SkuTarget.class).sheet().doWrite(targeList);
        return targetPath;
    }
}
