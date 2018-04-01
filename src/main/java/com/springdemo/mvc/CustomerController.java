package com.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult) {

        System.out.println("Last name: |" + customer.getLastName() + "|");

        System.out.println("Binding result: " + bindingResult);

        System.out.println("\n\n\n\n");

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }

    /*
    * This method pre-process all web request coming into this Controller.
    * Used here to convert input values that contain only trailing whitespace characters
    * into null values. Which at the end leads to validation error, which is exactly
    * what we need here.
    * */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        // pre-process every String form data, removing trailing white space characters from it
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
