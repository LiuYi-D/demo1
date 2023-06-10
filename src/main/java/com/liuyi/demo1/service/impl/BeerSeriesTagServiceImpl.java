package com.liuyi.demo1.service.impl;

import com.liuyi.demo1.exception.ErrorEnum;
import com.liuyi.demo1.exception.TagException;
import com.liuyi.demo1.mapper.BeerSeriesTagMapper;
import com.liuyi.demo1.pojo.BeerSeriesTag;
import com.liuyi.demo1.service.BeerSeriesTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class BeerSeriesTagServiceImpl implements BeerSeriesTagService {
    @Autowired
    private BeerSeriesTagMapper beerSeriesTagMapper;

    /**
     * 通过传入beerSeriesTag实例，获得该实例的系列标签
     * @param beerSeriesTag  beerSeriesTag实例
     * @return
     */
    @Override
    public String findSingleBeerSeriesTag(BeerSeriesTag beerSeriesTag) {
        String brand = beerSeriesTag.getBrand();
        String name = beerSeriesTag.getName();
        String firstKeyword = beerSeriesTag.getFirstKeyword();
        String secondKeyword = beerSeriesTag.getSecondKeyword();
        String thirdKeyword = beerSeriesTag.getThirdKeyword();
        String fourthKeyword = beerSeriesTag.getFourthKeyword();
        String mappedValue = beerSeriesTag.getMappedValue();
        String lastBrand = beerSeriesTag.getLastBrand();
        String series = beerSeriesTag.getSeries();

        //如果系列标签已经存在 抛异常
        if(series != null){
            throw new TagException(ErrorEnum.SERIES_EXIST);
        }
        //如果品牌为空 抛异常
        if(brand == null){
            throw new TagException(ErrorEnum.BRAND_NULL);
        }
        //如果果品牌值是其他，就返回其他
        if(brand.equals("其他")){
            return "其他";
        }
        //品牌不是其他  且映射值为空  抛异常
        if(mappedValue == null){
            throw new TagException(ErrorEnum.MAPPED_NULL);
        }
        //第一关键字不为空 匹配第一关键字
        if(firstKeyword != null){
            if(name.contains(firstKeyword)) {
                return mappedValue;
            }
        }
        // 第二三四关键字都不为空，则匹配二三四关键字
        if (secondKeyword!=null && thirdKeyword!=null && fourthKeyword!=null){
            if(name.contains(secondKeyword) && name.contains(thirdKeyword) && name.contains(fourthKeyword)){
                return mappedValue;
            }
        }
        //品牌不是其他  映射值不为空 关键字未匹配上  此时如果最终品牌值为空 抛异常 否则返回最终品牌+其他
        if(lastBrand == null){
            throw new TagException(ErrorEnum.LAST_NULL);
        }
        return lastBrand+"其他";

    }

    /**
     * 查询所有的商品信息
     * @return 所有商品信息
     */
    @Override
    public List<BeerSeriesTag> findAll() {
        return beerSeriesTagMapper.findAll();
    }

    /**
     * 将数据库中商品表全部更新 即对系列字段赋值
     * 系列字段已经有值则不会更新
     * 可先通过setSeriesNull() 方法将所有商品的 系列 字段设置为null
     * @return 更新成功的商品数
     */
    @Override
    public Integer updateAll() {
        //1.查询全部商品表
        List<BeerSeriesTag> all = beerSeriesTagMapper.findAll();
        int sum = 0;
        //2.遍历商品，并打标签
        for (BeerSeriesTag beerSeriesTag:all) {
            try{
                //获取标签
                String seriesTag = findSingleBeerSeriesTag(beerSeriesTag);
                beerSeriesTagMapper.updateSeriesById(seriesTag,beerSeriesTag.getId());
                System.out.println("更新成功，系列标签为 "+seriesTag+" "+beerSeriesTag.toString());
                sum++;
            }
            catch (TagException e){
                System.out.println(" 更新失败！ 失败原因为："+e.getMessage()+beerSeriesTag.toString());
            }

        }


        return sum;
    }

    /**
     * 所有商品的 系列 字段设置为null
     */
    @Override
    public void setSeriesNull() {
        beerSeriesTagMapper.setSeriesNull();
        System.out.println("已将所有商品的系列标签设置为null，以方便测试！");
    }
}
