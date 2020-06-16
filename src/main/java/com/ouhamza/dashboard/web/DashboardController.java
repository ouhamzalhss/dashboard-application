package com.ouhamza.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lhouceine OUHAMZA
 */
@Controller
public class DashboardController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("course","DevOps");
        return "index";
    }

}
