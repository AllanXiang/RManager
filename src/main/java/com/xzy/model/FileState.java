package com.xzy.model;

/**
 * Created by xzy on 2015-01-21 9:41 AM.
 */
public class FileState {
    private String filename;
    private int status;
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
