package com.ys.music.service.Impl;

import com.ys.music.service.FileuploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class FileuploadServiceImp implements FileuploadService {
    @Value("${ftp.location}")
    private String ftplocation;
    @Override
    public String upload(MultipartFile file) {
        if(file.isEmpty()){
            return  "文件为空";
        }
        /**
         * 获取文件全名称
         */
        String OriginalFilename = file.getOriginalFilename();
        /**
         * 扩展名加时间戳
         */
        String extension = "."+OriginalFilename.substring(OriginalFilename.lastIndexOf(".")+1);
        /**
         * 或者拿系统的时间
         */
        String fileName = System.currentTimeMillis()+extension;
        /**
         * 磁盘路径
         */
        //String filePath = "D:\\Git\\";
        String filePath = ftplocation;
        File dest = new File(filePath+fileName);
        /**
         * 判断磁盘上是否有文件夹名称
         * 如果不存在就创建文件夹
         */
        if(!(dest.getParentFile().exists())){
            dest.getParentFile().mkdir();
        }
        /**
         * 放入磁盘
         */
        try {
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            return  "出错了";
        }

        return fileName;
    }
}
