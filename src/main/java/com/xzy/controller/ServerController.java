package com.xzy.controller;

import com.xzy.model.Server;
import com.xzy.service.ServerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:52 PM.
 */
@Controller
public class ServerController {
    @Resource
    private ServerService serverService;

    @RequestMapping(value = "/server", method = RequestMethod.GET)
    public String showServer(Model model){
        List<Server> list = this.serverService.getServerList();
        model.addAttribute("servers", list);
        return "server";
    }

    @RequestMapping(value = "/server/{id}", method = RequestMethod.GET)
    public String showServerById(Model model, @PathVariable("id") int id){
        return "upserver";
    }

    @RequestMapping(value = "/server/addserver", method = RequestMethod.GET)
    public String addServer(Model model){
        return "addserver";
    }

    @RequestMapping(value = "/server/upserver", method = RequestMethod.GET)
    public String upServer(Model model){
        return "upserver";
    }

    @RequestMapping(value = "/condition")
    public String condition(Model model){
        List<String> allip = this.serverService.getServerIpList();
        model.addAttribute("allip", allip);
        return "condition";
    }
    //api
    @RequestMapping(value = "/server/api/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Server showServerByIdAPI(@PathVariable("id") int id){
        return this.serverService.getServerById(id);
    }

    @RequestMapping(value= "/server/api", method = RequestMethod.POST)
    public @ResponseBody
    String addServerAPI(@RequestBody Server server){
        int status = this.serverService.addServer(server);
        return status+"";
    }

    @RequestMapping(value = "/server/api/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String upServerAPI(@RequestBody Server server){
        int status = this.serverService.upServer(server);
        return status+"";
    }

}
