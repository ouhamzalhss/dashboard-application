package com.ouhamza.dashboard.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lhouceine OUHAMZA
 */
@Controller
public class DashboardController {

    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping("/")
    public String welcome(Model model) {
        logger.info("Hello mes amis ");
        model.addAttribute("course","DevOps");
        return "index";
    }

}
