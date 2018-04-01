package com.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{favLanguages}")
    private Map<String, String> favLanguages;

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);
        model.addAttribute("countryOptions", countryOptions);
        model.addAttribute("favLanguages", favLanguages);

        return "student-form";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("student") Student student) {

        System.out.println("student: " + student.getFirstName()
         + " " + student.getLastName());

        return "student-confirmation";
    }
}
