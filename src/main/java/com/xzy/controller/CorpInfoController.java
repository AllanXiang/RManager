package com.xzy.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.xzy.model.CorpInfo;
import com.xzy.service.CorpInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:52 PM.
 */
@Controller
public class CorpInfoController {
    @Resource
    private CorpInfoService corpInfoService;

    @RequestMapping(value = "/info_query")
    public String info_query(){
        return "info_query";
    }

    @RequestMapping(value = "/info_query",method = RequestMethod.POST)
    public String showCorpInfo(Model model, @RequestParam(value = "select", required = false) Integer select,
                               @RequestParam(value = "search", required = false) String search){
        List<CorpInfo> list = new ArrayList<CorpInfo>();
        if(search==null){
            list = this.corpInfoService.getCorpInfoListByName("百度");
        }else {
            if (select == 0) {
                list = this.corpInfoService.getCorpInfoListByName(search);
            } else {
                list = this.corpInfoService.getCorpInfoListByNo(search);
            }
        }
        model.addAttribute("corpinfos", list);
        model.addAttribute("search", search);
        return "info_query";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String showServerById(Model model, @PathVariable("id") int id){
        CorpInfo corpinfo = this.corpInfoService.getCorpInfoById(id);
        model.addAttribute("corpinfo", corpinfo);
        return "info";
    }

    @RequestMapping(value = "/info/api/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String upServerAPI(@RequestBody CorpInfo corpinfo){
        int status = this.corpInfoService.upCorpInfo(corpinfo);
        return status+"";
    }
}
