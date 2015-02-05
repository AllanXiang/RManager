package com.xzy.service;

import com.xzy.model.FileState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xzy on 2015-01-20 3:26 PM.
 */
public interface FileService {
    public FileState upload(HttpServletRequest request);
    public void download(int id, HttpServletResponse response);
}
