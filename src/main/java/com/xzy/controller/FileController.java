package com.xzy.controller;

import com.xzy.model.FileState;
import com.xzy.service.FileService;
import com.xzy.service.QueryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xzy on 2015-01-08 8:52 PM.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping(value = "/api/upload", method = RequestMethod.POST)
    public @ResponseBody
    FileState fileUploadAPI(HttpServletRequest request) {
        return this.fileService.upload(request);
    }

    @RequestMapping(value = "/api/download/{id}", method = RequestMethod.GET)
    public void fileDownloadAPI(@PathVariable("id") int id, HttpServletResponse response) {
        this.fileService.download(id, response);
    }


}
