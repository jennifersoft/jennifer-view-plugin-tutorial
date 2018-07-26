package com.aries.threejs;

import com.aries.extension.starter.PluginController;
import com.aries.extension.util.ConfigUtil;
import com.aries.extension.util.PropertyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThreejsController extends PluginController {

    @RequestMapping(value = { "/threejs" }, method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getThreejsMainPage(@RequestParam(required = false, defaultValue = "index")  String tpl)
    {
        ModelAndView mav = new ModelAndView("templates/" + tpl + ".vm");
        mav.addObject("property", PropertyUtil.getValue("threejs", "message", "property 22"));
        mav.addObject("config", ConfigUtil.getValue("sherpaoracle_server_url", "http://sherpaoracle"));
        return mav;
    }
}