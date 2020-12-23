package com.ys.music.controller.Fileupload;

import com.ys.music.common.ResponseBean;
import com.ys.music.service.FileuploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;


@RestController
@RequestMapping(value = "/common")
@CrossOrigin
@Api(value = "通用", tags = {"文件上传"})
public class Fileupload {
    @Autowired
    private FileuploadService fileuploadService;
    @Value("${ftp.location}")
    private String ftplocation;

    /**
     * 通用上传
     *
     * @param file
     * @return
     */
    @PostMapping(value = "file")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public ResponseBean updateSinger(@RequestParam("file") MultipartFile file) {

        HashMap<String, Object> hashMap = new HashMap<>();
        Object upload = fileuploadService.upload(file);
        hashMap.put("pic", upload);
        return ResponseBean.ofSuccess("200", hashMap);
    }

    /**
     * 图片预览
     *
     * @param filename
     * @param response
     */
    @GetMapping("/getImage")
    @ResponseBody
    public void getImagesId(String filename, HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        String filePath = ftplocation + filename;
        File file = new File(filePath);
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                long size = file.length();
                byte[] temp = new byte[(int) size];
                fis.read(temp, 0, (int) size);
                fis.close();
                byte[] data = temp;
                response.setContentType("image/png");
                os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
