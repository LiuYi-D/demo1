package com.liuyi.demo1.Controller;


import ch.qos.logback.core.util.FileUtil;
import com.liuyi.demo1.Utils.ZipUtil;
import com.liuyi.demo1.pojo.excel.ExcelData;
import com.liuyi.demo1.service.excel.SkuSplitService;
import com.liuyi.demo1.service.excel.SplitExcelService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private SplitExcelService splitExcelService;
    @Autowired
    private SkuSplitService skuSplitService;

    @Value("f:/test")
    private String FilePath;
    @Value(".xlsx")
    private String type;

    @RequestMapping("/splitExcel")
    public String test(@RequestParam("file") MultipartFile file, @RequestParam("colum") String column) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("文件的后缀名为：" + suffixName);
        if(!type.contains(suffixName)){
            return "上传的文件不是excel";
        }

        //将接收到的文件保存在D:\testDemo
        String folderName = "D:\\testDemo\\" + fileName.substring(0, fileName.lastIndexOf("."));
        String zipFolderName = folderName+"\\zip";
        File folder = new File(folderName);
        if(!folder.exists()){
            folder.mkdir();
            File zipFolder = new File(zipFolderName);
            zipFolder.mkdir();
        }else {
            return "该文件名已存在，请更改文件名或查询已生成的文件！  文件地址："+folderName;
        }

        String pathname = folderName+"\\"+fileName;
        try {
            file.transferTo(new File(pathname));
        }catch (IOException e){
            return "上传失败！";
        }


        //提取文件内容  把文件内容按column分割成多个List
        List<List> splitExcels = splitExcelService.getSplitExcels(pathname, column);

        //column映射 由column拿到实例类中对应的属性名
        HashMap<String, String> columnMap = new HashMap<>();
        columnMap.put("平台名称","getPlatForm");
        columnMap.put("大区","getRegion");
        columnMap.put("城市","getCity");

        //遍历所有List  按column写入到对应的excel
        for (List<ExcelData> excel:
             splitExcels) {
            Method method = ExcelData.class.getMethod(columnMap.get(column));
            String res = (String)method.invoke(excel.get(0));
            String path = zipFolderName+"\\"+"group-"+res+".xlsx";
            splitExcelService.write(path,excel);
        }

        //将结果打包成zip
        FileOutputStream outputStream = new FileOutputStream(folderName+"\\res.zip");
        ZipUtil.toZip(zipFolderName,outputStream,true);

        return "请查看 "+folderName;
    }

    @RequestMapping("/skuSplit")
    public String skuSplit(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("文件的后缀名为：" + suffixName);
        if(!type.contains(suffixName)){
            return "上传的文件不是excel";
        }

        //将接收到的文件保存在D:\testDemo
        String folderName = "D:\\testDemo\\" + fileName.substring(0, fileName.lastIndexOf("."));
        File folder = new File(folderName);
        if(!folder.exists()){
            folder.mkdir();
        }else {
            return "该文件名已存在，请更改文件名或查询已生成的文件！  文件地址："+folderName;
        }
        String pathname = folderName+"\\"+fileName;
        try {
            file.transferTo(new File(pathname));
        }catch (IOException e){
            return "上传失败！";
        }

        //处理excel
        String targetPath = folderName+"\\"+"分裂后_"+fileName;
        skuSplitService.splitSku(pathname,targetPath);

        return "请查看"+folderName;
    }



}
