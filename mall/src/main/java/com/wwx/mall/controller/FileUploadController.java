package com.wwx.mall.controller;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class FileUploadController {
@PostMapping("admin/storage/create")
    public String singleUpload(
            @RequestParam("file") MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String path = "d:\\pic";

        File filepath = new File(path, fileName);
        if (!filepath.getParentFile().exists())
        // 获取上传的文件名称，并结合存放路径，构建新的文件名称
        {
            filepath.getParentFile().mkdirs();

        }
        try {
            file.transferTo(new File(path + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;

    }

}
