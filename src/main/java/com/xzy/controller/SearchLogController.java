package com.xzy.controller;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import com.xzy.model.SearchLog;
import com.xzy.model.Statistics.Statistics;
import com.xzy.service.SearchLogService;
import com.xzy.util.Time;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:52 PM.
 */
@Controller
public class SearchLogController {
    @Resource
    private SearchLogService searchLogService;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String showSearchLog(Model model){
        List<SearchLog> list = this.searchLogService.getSearchLogList(Time.dateToStringDate(new Date()));
        model.addAttribute("searchlogs", list);
        return "log";
    }

    //api
    @RequestMapping(value = "/dashboard/api", method = RequestMethod.GET)
    public @ResponseBody
    List<Statistics> dashboardAPI(){
        return this.searchLogService.getDashboard(Time.dateToStringDate(new Date()));
    }

    @RequestMapping(value = "/condition/api", method = RequestMethod.POST)
    public @ResponseBody
    Statistics conditionAPI(@RequestParam("ip") String ip){
        return this.searchLogService.getProvinceStatistics(Time.dateToStringDate(new Date()), ip);
    }
}
