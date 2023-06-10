package com.liuyi.demo1.service;

import java.util.Set;

public interface LowestDiscountSevice {
    public Float getLowest(Float price,String information);
    public Set<String> getDiscount(String information);
    public float[] getIntByString(String information);

}
