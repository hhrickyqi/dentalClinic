package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.utils.FileUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "FileOperationController", description = "文件上传")
@RestController
@RequestMapping("/file")
@Slf4j
public class FileOperationController {
    @ApiOperation("单文件上传")
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CommonResult<Object> uploadFile(@RequestPart(value = "file") MultipartFile file,//一定记得加注解swagger3 consumes @RequestPart
                                           @RequestParam("dir") String directory) {
        try {
            String url = FileUtil.upload(file, directory);
            return CommonResult.success(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @PostMapping("/removeFile")
    public CommonResult<Object> removeFile(String relativePath) {
        return CommonResult.success(FileUtil.delete(relativePath));
    }
}
