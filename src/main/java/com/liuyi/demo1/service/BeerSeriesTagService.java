package com.liuyi.demo1.service;

import com.liuyi.demo1.pojo.BeerSeriesTag;

import java.util.List;

public interface BeerSeriesTagService {

    public List<BeerSeriesTag> findAll();
    public String findSingleBeerSeriesTag(BeerSeriesTag beerSeriesTag);
    public Integer updateAll();
    public void setSeriesNull();
    public String findTag(BeerSeriesTag beerSeriesTag);
}
