package com.liuyi.demo1;

import com.alibaba.excel.EasyExcel;
//import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liuyi.demo1.Utils.ZipUtil;
import com.liuyi.demo1.mapper.BeerSeriesTagMapper;
import com.liuyi.demo1.pojo.BeerSeriesTag;
import com.liuyi.demo1.pojo.excel.*;
import com.liuyi.demo1.service.BeerSeriesTagService;
import com.liuyi.demo1.service.NumMatchService;
import com.liuyi.demo1.service.excel.SplitExcelService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {


	@Test
	void testExcel() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		String path = "F:\\test2.xlsx";
		ExcelDataListener excelDataListener = new ExcelDataListener();
		excelDataListener.setExcelDataList(new ArrayList<ExcelData>());
		EasyExcel.read(path, ExcelData.class,excelDataListener).sheet().doRead();
		List<ExcelData> data = excelDataListener.getExcelDataList();
		System.out.println(data);

//		ExcelData excelData = new ExcelData("st","1plt","reg","city","price","123","456","789","123");
//		Method method = ExcelData.class.getMethod("getCity");
//		String invoke = (String)method.invoke(excelData);
//		System.out.println(invoke);
	}
	@Test
	void test() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, JSONException {
		String path = "F:\\raw_test.xlsx";
		SkuSourceListener skuSourceListener = new SkuSourceListener();
		skuSourceListener.setSkuSourceList(new ArrayList<SkuSource>());
		EasyExcel.read(path, SkuSource.class, skuSourceListener).sheet().doRead();
		List<SkuSource> skuSourceList = skuSourceListener.getSkuSourceList();
		for (SkuSource skuSource:
			 skuSourceList) {
			String sku = skuSource.getSkuDetails();
			String s1 = sku.substring(1);
			String s2 = s1.substring(0,s1.length()-1);
			JSONArray jsonArray = JSONArray.parseArray(sku);
			System.out.println(jsonArray.size());
			for(int i = 0;i<jsonArray.size()-1;i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String sku_current_price = jsonObject.getString("sku_current_price");
				String sku_deposit_price = jsonObject.getString("sku_deposit_price");
				System.out.println(sku_current_price);
				System.out.println(sku_deposit_price);


			}
			//JSONObject  jsonObject = new JSONObject(s2);


		}

	}
	@Test
	void test2() throws FileNotFoundException {
		FileOutputStream outputStream = new FileOutputStream("F:\\test\\test3\\z.zip");
		String path = "F:\\test\\test3\\zip";
		ZipUtil.toZip(path,outputStream,true);

	}

	@Test
	void testPath(){
		String currentPath=System.getProperty("user.dir");
		String excelPath = currentPath+"\\src\\main\\resource\\excel";
		System.out.println(excelPath);
	}

}
