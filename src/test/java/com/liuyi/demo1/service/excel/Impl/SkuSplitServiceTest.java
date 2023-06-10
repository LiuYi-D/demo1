package com.liuyi.demo1.service.excel.Impl;

import com.liuyi.demo1.service.excel.SkuSplitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SkuSplitServiceTest {
    @Autowired
    private SkuSplitService skuSplitService;
    @Test
    public void testSkuSplit(){
        String path = "F:\\raw_test.xlsx";
        String targetPath = "F:\\test\\testupload\\a.xlsx";
        skuSplitService.splitSku(path,targetPath);
    }
}
