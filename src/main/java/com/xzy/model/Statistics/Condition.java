package com.xzy.model.Statistics;

/**
 * Created by xzy on 2015-01-17 9:45 PM.
 */
public class Condition {
    private String time;
    private int tot;
    private int error;
    private int ok;
    public int getTot() {
        return tot;
    }
    public void setTot(int tot) {
        this.tot = tot;
    }
    public int getError() {
        return error;
    }
    public void setError(int error) {
        this.error = error;
    }
    public int getOk() {
        return ok;
    }
    public void setOk(int ok) {
        this.ok = ok;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}

