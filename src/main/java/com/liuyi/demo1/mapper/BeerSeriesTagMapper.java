package com.liuyi.demo1.mapper;

import com.liuyi.demo1.pojo.BeerSeriesTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BeerSeriesTagMapper {

    //查找所有商品
    public List<BeerSeriesTag> findAll();

    //通过id查找商品
    public BeerSeriesTag findById(Integer id);

    //通过id修改标签
    public Integer updateSeriesById(String series ,Integer id);

    //此方法仅用于方便其他功能测试
    //功能为:将所有商品的 标签 设置为 null
    public void setSeriesNull();
}
