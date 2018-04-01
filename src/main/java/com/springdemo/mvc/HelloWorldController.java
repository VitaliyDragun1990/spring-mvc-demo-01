package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping(value = "/processFormVersionTwo", method = RequestMethod.POST)
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping(value = "/processFormVersionThree", method = RequestMethod.POST)
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();
        String result = "Hey My Friend from v3! " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
